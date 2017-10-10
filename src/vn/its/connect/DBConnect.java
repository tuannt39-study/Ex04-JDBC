package vn.its.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getDBConnection() {
		final String driver = "oracle.jdbc.driver.OracleDriver";
		final String user_name = "ITSOL";
		final String password = "1234";
		final String server_name = "localhost";
		final String port_number = "1521";
		final String sid_number = "xe";
		Connection conn = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			final String db_url = "jdbc:oracle:thin:@" + server_name + ":" + port_number + ":" + sid_number;
			conn = DriverManager.getConnection(db_url, user_name, password);
			return conn;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void main(String[] args) {
		System.out.println(getDBConnection());
	}
}
