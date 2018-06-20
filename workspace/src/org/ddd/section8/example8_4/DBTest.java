package org.ddd.section8.example8_4;

import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) throws Exception{
		Statement stmt = MySqlDAO.getStatement();
		String sql = "select id,name,sex from student  ";
		sql = "insert into student(id,name) values (6,'wang')";
		stmt.execute(sql);
//		ResultSet rs = stmt.executeQuery(sql);
//		while(rs.next()){
//			System.out.print("学号：" + rs.getInt("id"));
//			System.out.println("	姓名：" + rs.getString(2));
//		}
		stmt.close();
	}	
}
