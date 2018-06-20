package org.ddd.section8.example8_5;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBTest {
	public static void main(String[] args) throws Exception{
		String sql = "select * from student where id = ?";
		PreparedStatement ps = MySqlDAO.prepareStatement(sql);
		ps.setInt(1, 1);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.print("学号" + rs.getInt("id"));
			System.out.println("	姓名" + rs.getString(2));
		}
	}	
}
