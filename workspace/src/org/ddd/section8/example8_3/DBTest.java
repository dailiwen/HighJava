package org.ddd.section8.example8_3;

import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) throws Exception{
		Statement stmt = MySqlDAO.getStatement();
		//String sql = "insert into student(id,name) values(10,'jim')";
		String sql = "update student set name ='wangba' where id =10 ";
		stmt.execute(sql);
		stmt.close();
	}	
}

