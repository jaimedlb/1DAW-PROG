package com.gsd.daw.prog.ApacheAnalizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilidades {

	public static void main(String[] args) {

		String connectionString =  "jdbc:oracle:thin:@//127.0.0.1/XEPDB1";
		try {
			Connection conn = DriverManager.getConnection(connectionString, "C##jaime", "Abrete01");
			jdbcDemo(conn);
		} catch (SQLException e) {
			System.err.println("Las BBDD no son lo tuyo: " + e.getMessage());
		}
	}

	private static void jdbcDemo(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM prueba_tb");
		while (resultSet.next()) {
			System.out.print("Nombre: " + resultSet.getString("nombre"));
			System.out.print(" Email: " + resultSet.getString("email") + "\n");
		} 
		resultSet.close();
		stmt.close();
		conn.close();
	}
}
