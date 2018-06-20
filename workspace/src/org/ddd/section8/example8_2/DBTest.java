package org.ddd.section8.example8_2;

import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) throws Exception{
		Statement stmt = MySqlDAO.getStatement();
		String sql = "create table student(no int primary key, name char(20))";
		stmt.execute(sql);
		stmt.close();
	}	
}
