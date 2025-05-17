package com.gsd.daw.prog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApacheAnalizer {
	public static final String SGBD_MYSQL = "MYSQL";
	public static final String SGBD_ORACLE = "ORACLE";
	public static final String SGBD_POSTGRESQL = "POSTGRESQL";

	public static void main(String[] args) {
		// Comprobación de argumentos
		if (!comprobarArgumentos(args)) {
			return;
		}
		String ip = args[0];
		String estancia = args[1];
		String usuario = args[2];
		String contrasena = args[3];
		// Creacion de la conexión
		Connection conn = generarConexion(ip, estancia, usuario, contrasena);
		if (conn == null) {
			return;
		}
		System.out.println("INFO: conectado a BBDD.");

		// Carga de objetos del modelo de BBDD a estructura plana
		// Esto sin colecciones será un String[][] array de tamaño máximo 40000
		// elementos
		// Crea una clase aparte cuya responsabilidad sea recibir una conexion de BBDD
		// y devolver una estructura String[<tamano-de-los-datos>][6] con los datos en
		// columnas
		List<String[]> valores = null;
		try {

			valores = com.gsd.daw.prog.Utilidades.estructurarSelect(conn);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println("INFO: leidas [" + valores.size() + "] lineas de BBDD.");

		// Conversion de estructuras planas a objetos del modelo
		// Reusa la clase que ya creaste para convertir la estructura "anónima"
		// en un array de objetos del modelo
		List<Log> objLog = new ArrayList<>();
		for (int i = 0; i < valores.size(); i++) {
			try {

				objLog.add(new Log(valores.get(i)));
			} catch (Exception e) {
				System.err.println("problema en la base de datos" + e.getMessage());
			}
		}

		System.out.println("INFO: creados [" + objLog.size() + "] objetos del modelo.");

		// Crea una clase separada para realizar cálculos y analisis sobre
		// el array de objetos del modelo
		// Puede ser una librería de funciones static (sin datos propios)
		// que reciban un array de objetos del modelo y realicen cálculos sobre ellos
		// Recuerda dividir responsabilidades entre calcular e imprimir.

		// Los cálculos que se piden están especificados en el enunciado

		System.out.println("Ips que aparecen mas de 10 veces");
		Calculos.imprimirIps(Calculos.calcularnumeroIpsMayorDiez(objLog));
		System.out.println("Cuantas veces aparecen cada status code");
		Calculos.imprimirResult(Calculos.numeroStatusCode(objLog));
	
	}

	private static boolean comprobarArgumentos(String[] args) {
		if (args.length == 4) {
			return true;
		}
		System.err.println("Los argumentos tienen que ser en este formato: [IP,Instancia,Usuario,Password]");

		switch (args.length) {
		case 0:
			System.err.println("Faltan los argumentos [IP,Instancia,Usuario,Password]");
			break;
		case 1:
			System.err.println("Faltan los argumentos [Instancia,Usuario,Password]");
			break;
		case 2:
			System.err.println("Faltan los argumentos [Usuario,Password]");
			break;
		case 3:
			System.err.println("Faltan los argumentos [Password]");
			break;

		default:
			break;
		}

		return false;
	}

	private static Connection generarConexion(String ip, String estancia, String usuario, String contrasena) {
		String conexionString = "";
		String sgbd = System.getenv("SGBD");
		if (sgbd == null) {
			System.err.println("WARN: Variable SGBD no configurada, se asume mySQL");
			sgbd = SGBD_MYSQL;
		}
		switch (sgbd) {
		case SGBD_POSTGRESQL:
			conexionString = String.format("jdbc:postgresql://%s/%s", ip, estancia);
			break;
		case SGBD_ORACLE:
			conexionString = String.format("jdbc:oracle:thin:@//%s/%s", ip, estancia);
			break;
		case SGBD_MYSQL:
			conexionString = String.format("jdbc:mysql://%s:3306/%s?serverTimezone=UTC", ip, estancia);
			System.out.println(conexionString);
			break;
		default:
			conexionString = String.format("jdbc:mysql://%s:3306/%s?serverTimezone=UTC", ip, estancia);
			break;
		}

		try {
			return DriverManager.getConnection(conexionString, usuario, contrasena);
		} catch (SQLException e) {
			System.err.println("ERROR al obtener la conexión: " + e.getMessage());
			return null;
		}

	}
}
