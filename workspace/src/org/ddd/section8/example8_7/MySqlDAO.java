package org.ddd.section8.example8_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySqlDAO {
	public static Connection getConnection()  throws Exception{
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/simple";
		String userName = "root";
		String password = "111111";
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}
}
