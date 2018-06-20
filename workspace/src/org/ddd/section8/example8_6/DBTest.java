package org.ddd.section8.example8_6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args){
		Connection con  = null;
		try{
			con = MySqlDAO.getConnection();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			String sql1 = "select max(no) from student";
			ResultSet rs = stmt.executeQuery(sql1);
			int no = 0;
			while(rs.next()){
				no = rs.getInt(1) + 1;
			}
			String sql2 = "insert into student values(" + no + ",'wahaha')";
			stmt.execute(sql2);
			con.commit();
			stmt.close();
			con.close();
		}catch(Exception e){
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}	
}
