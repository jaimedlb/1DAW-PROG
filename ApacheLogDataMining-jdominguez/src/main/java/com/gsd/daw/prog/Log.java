package com.gsd.daw.prog;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

public class Log {
	private String ip;
	private String timeStamp;
	private String request;
	private String result;
	private int bytes;
	private String ua;

	public Log(String[] log) throws ParseException{
		this.ip = log[0];
		this.timeStamp = log[1];
		this.request = log[2];
		this.result = log[3];
		this.bytes = Integer.parseInt(log[4]);
		this.ua = log[5];
	}

	public void save(Connection conexion) throws SQLException {
		String sql = "INSERT INTO APACHE_LOG_TBL2 VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStmt = conexion.prepareStatement(sql);
		preparedStmt.setString(1, ip);
		preparedStmt.setDate(2, convertirTimeStampToDate());
		preparedStmt.setString(3, request);
		preparedStmt.setString(4, result);
		preparedStmt.setInt(5, bytes);
		preparedStmt.setString(6, ua);
		preparedStmt.execute();
		preparedStmt.close();
	}
	private Date convertirTimeStampToDate() {
		Date hola= new Date();
		String[] date= timeStamp.split("\\/|\\:");
		return date[0]+"/"+Utilidades.fechaNombreToNumero(date[1])+"/"+date[2]+" "+date[3]+":"+date[4]+":"+date[5];
	}

	public String getIp() {
		return ip;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public String getRequest() {
		return request;
	}

	public String getResult() {
		return result;
	}

	public int getBytes() {
		return bytes;
	}

	public String getUa() {
		return ua;
	}

}
