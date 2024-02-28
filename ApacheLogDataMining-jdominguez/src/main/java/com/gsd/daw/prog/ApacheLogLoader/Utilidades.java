package com.gsd.daw.prog.ApacheLogLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		System.out.println("INFO: conectado a BBDD.");
		return conn;
	}
	
	private static String[] parseLogLineString(String line) {
		String LOG_ENTRY_PATTERN = "^(\\S+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\S+) \"(.*?)\" \"(.*?)\"$";
		Pattern pattern = Pattern.compile(LOG_ENTRY_PATTERN);

		String[] res = new String[6];

		Matcher matcher = pattern.matcher(line);
		if (matcher.matches()) {
			res[0] = matcher.group(1);
			res[1] = matcher.group(4);
			res[2] = matcher.group(5);
			res[3] = matcher.group(6);
			res[4] = matcher.group(7);
			res[5] = matcher.group(9);
		}
		return res;
	}

	public static List<String[]> estructuraLog(String fichero) {
		Scanner inputFile = null;
		try {
			File f = new File(fichero);
			inputFile = new Scanner(f);

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se encuantra el fichero [" + fichero + "]");
			return null;
		}
		List<String[]> l1 = new ArrayList<>();
		while (inputFile.hasNext()) {
			String[] valor = parseLogLineString(inputFile.nextLine());
			l1.add(valor);

		}
		/*
		 * String[][] valores=new String[10000][6]; for (int j = 0; inputFile.hasNext();
		 * j++) {
		 * 
		 * String[] valor= parseLogLineString(inputFile.nextLine()); for (int i = 0; i <
		 * valor.length; i++) { valores[j][i]= valor[i]; } }
		 */

		return l1;
	}
}
