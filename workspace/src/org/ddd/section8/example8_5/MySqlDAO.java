package org.ddd.section8.example8_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class MySqlDAO {
	public static Connection getConnection()  throws Exception{
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ccm";
		String userName = "root";
		String password = "root";
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}
	public static Statement getStatement() throws Exception{
		Statement stmt = getConnection().createStatement();
		return stmt;
	}
	public static PreparedStatement prepareStatement(String sql) throws Exception{
		return getConnection().prepareStatement(sql);
	}
}
