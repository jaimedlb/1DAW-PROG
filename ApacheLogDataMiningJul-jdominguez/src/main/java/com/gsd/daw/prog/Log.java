package com.gsd.daw.prog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

public class Log {
	private String ipAddress;
	private String timeStamp;
	private String httpRequest;
	private String httpStatusCode;
	private int responseSize;
	private String userAgent;

	public Log(String[] datos) throws NumberFormatException {

		this.ipAddress = datos[0];
		this.timeStamp = datos[1];
		this.httpRequest = datos[2];
		this.httpStatusCode = datos[3];
		this.responseSize = Integer.parseInt(datos[4]);
		this.userAgent = datos[5];
	}

	public boolean save(Connection conn) throws SQLException {

		String sql = "INSERT INTO APACHE_LOG_TBL VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(sql);

		preparedStmt.setString(1, ipAddress);
		preparedStmt.setString(2, timeStamp);
		preparedStmt.setString(3, httpRequest);
		preparedStmt.setString(4, httpStatusCode);
		preparedStmt.setInt(5, responseSize);
		preparedStmt.setString(6, userAgent);
		preparedStmt.execute();
		preparedStmt.close();
		return true ;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getTimestamp() {
		return timeStamp;
	}

	public String getHttpRequest() {
		return httpRequest;
	}

	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	public int getResponseSize() {
		return responseSize;
	}

	public String getUserAgent() {
		return userAgent;
	}

}
