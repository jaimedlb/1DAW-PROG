package com.gsd.daw.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

	public static Map<Integer, String[][]> ficheroToArray(String nombreFichero) {

		Scanner inputScannerFromFile = null;
		File f = new File(nombreFichero);
		try {
			inputScannerFromFile = new Scanner(f);

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se puede abrir [" + nombreFichero + "]\n" + e.getMessage());
			return null;
		}
		int i = 0;
		String[][] arrayLog = new String[40000][6];
		while (inputScannerFromFile.hasNext()) {
			String line = inputScannerFromFile.nextLine();
			arrayLog[i] = parseLogLineString(line);
			i++;

		}
		Map<Integer, String[][]> mapa = new HashMap<>();
		mapa.put(i, arrayLog);

		return mapa;

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
	public static List<String[]> estructurarSelect(Connection conexion) throws SQLException {

		String sql = "select * from APACHE_LOG_TBL";
		PreparedStatement preparedStmt = conexion.prepareStatement(sql);

		ResultSet resultadoStmt = preparedStmt.executeQuery();
		List<String[]> valores = new ArrayList<>();
		while (resultadoStmt.next()) {

			String ip = resultadoStmt.getString("IP");
			String timestamp = resultadoStmt.getString("TIMESTAMP");
			String request = resultadoStmt.getString("REQUEST");
			String result = resultadoStmt.getString("RESULT");
			String bytes = resultadoStmt.getString("BYTES");
			String ua = resultadoStmt.getString("UA");
			String[] query = { ip, timestamp, request, result, bytes, ua };
			valores.add(query);
		}
		preparedStmt.close();

		return valores;
	}
}
