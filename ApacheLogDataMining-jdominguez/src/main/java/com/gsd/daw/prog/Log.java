package com.gsd.daw.prog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class Log {
	private int hash;
	private String ip;
	private String timeStamp;
	private String request;
	private String result;
	private int bytes;
	private String ua;

	public Log(String[] log) throws ParseException {
		this.ip = log[0];
		this.timeStamp = log[1];
		this.request = log[2];
		this.result = log[3];
		this.bytes = Integer.parseInt(log[4]);
		this.ua = log[5];
		this.hash = (ip + timeStamp + request + result + bytes + ua).hashCode();
	}

	private boolean comprobacionPrimaryKey(Connection conexion) throws SQLException {
		String sql = "select HASH from APACHE_LOG_TBL where HASH=?";
		PreparedStatement preparedStmt = conexion.prepareStatement(sql);
		preparedStmt.setInt(1, hash);
		ResultSet resultadoStmt = preparedStmt.executeQuery();
		if (!resultadoStmt.next()) {
			preparedStmt.close();
			resultadoStmt.close();
			return true;

		}

		String hash = resultadoStmt.getString("HASH");

		if (this.hash == Integer.parseInt(hash)) {
			preparedStmt.close();
			resultadoStmt.close();
			return false;
		}
		preparedStmt.close();
		resultadoStmt.close();
		return true;
	}

	public boolean save(Connection conexion) throws SQLException {
		if (!comprobacionPrimaryKey(conexion)) {
			return false;
		}
		String sql = "INSERT INTO APACHE_LOG_TBL VALUES (?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = conexion.prepareStatement(sql);
		preparedStmt.setInt(1, hash);
		preparedStmt.setString(2, ip);
		preparedStmt.setString(3, timeStamp);
		preparedStmt.setString(4, request);
		preparedStmt.setString(5, result);
		preparedStmt.setInt(6, bytes);
		preparedStmt.setString(7, ua);
		preparedStmt.execute();
		preparedStmt.close();
		return true;
	}
	/*
	 * private Date convertirTimeStampToDate() { Date hola= new Date(); String[]
	 * date= timeStamp.split("\\/|\\:"); return
	 * date[0]+"/"+Utilidades.fechaNombreToNumero(date[1])+"/"+date[2]+" "+date[3]+
	 * ":"+date[4]+":"+date[5]; }
	 */

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
