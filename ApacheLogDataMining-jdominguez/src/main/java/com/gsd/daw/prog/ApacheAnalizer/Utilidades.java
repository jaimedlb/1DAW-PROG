package com.gsd.daw.prog.ApacheAnalizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Utilidades {

	public static Connection conexion(String[] parametros) {
		String ip = parametros[0];
		String contenedor = parametros[1];
		String usuario = parametros[2];
		String contrasena = parametros[3];
		String connectionString = "jdbc:oracle:thin:@//" + ip + "/" + contenedor;
		Connection conn =null;
		try {
			 conn = DriverManager.getConnection(connectionString, usuario, contrasena);
		} catch (SQLException e) {
			System.err.println("Parametros incorrectos: " + e.getMessage());
			return null;
		}
		
		return conn;
	}
	

	public static List<String[]> estructurarLog(Connection conexion)throws SQLException{
		
		String sql = "select * from APACHE_LOG_TBL";
		PreparedStatement preparedStmt = conexion.prepareStatement(sql);
		
		ResultSet resultadoStmt= preparedStmt.executeQuery();
		
		while (resultadoStmt.next()) {
			
		String ip =resultadoStmt.getString("IP");
		String timestamp =resultadoStmt.getString("TIMESTAMP");
		String request =resultadoStmt.getString("REQUEST");
		String result =resultadoStmt.getString("RESULT");
		String bytes =resultadoStmt.getString("BYTES");
		String ua =resultadoStmt.getString("UA");
		String[] query={ip,timestamp,request,result,bytes,ua};
		
		}
		preparedStmt.close();
		
		return null;
	}
}
