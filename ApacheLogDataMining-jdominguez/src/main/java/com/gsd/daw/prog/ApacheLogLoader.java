package com.gsd.daw.prog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ApacheLogLoader {
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
		String nombreFichero = args[4];

		// Creacion de la conexión
		
		Connection conn = generarConexion(ip, estancia, usuario, contrasena);
		if (conn == null) {
			return;
		}
		System.out.println("INFO: conectado a BBDD.");
		// Lectura de datos a estructuras planas
		// Esto sin colecciones será un String[][] array de tamaño máximo 40000
		// elementos
		// Crea una clase aparte, cuya responsabilidad sea recibir un nombre de fichero
		// y devolver una estructura String[40000][6] con los datos en columnas
		Map<Integer, String[][]> datos = Utilidades.ficheroToArray(nombreFichero);
		if (datos == null) {
			return;
		}
		int numeroLineasLeidas = datos.keySet().iterator().next();
		String[][] datosOrganizados = datos.get(numeroLineasLeidas);
		

		System.out.println("INFO: leidas [" + numeroLineasLeidas + "] lineas del fichero.");
		// Conversion de estructuras planas a objetos del modelo
		// Crea una clase que modele los datos que tiene una linea de log de Apache
		// Convierte la estructura "anónima" en un array de objetos del modelo

		List<Log> listaLog = new ArrayList<>();
		for (int i = 0; i < datosOrganizados.length; i++) {

			try {
				listaLog.add(new Log(datosOrganizados[i]));
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}

		}

		Log[] arrayLog = listaLog.toArray(new Log[0]);
		System.out.println("INFO: creados [" + arrayLog.length + "] objetos del modelo.");
		// Guardado de los objetos del modelo en BBDD
		// La clase del modelo debe tener un método save( Connection ) que recibe una
		// conexion JDBC y hace que los datos del objeto se guarden en BBDD
		int j = 0;
		int i = 0;
		for (; i < arrayLog.length; i++) {
			try {
				arrayLog[i].save(conn);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				j++;
			}

		}
		System.out.println("INFO: insertadas [" + (i - j) + "] filas en BBDD.");

	}

	private static boolean comprobarArgumentos(String[] args) {
		if (args.length == 5) {
			return true;
		}
		System.err.println(
				"Los argumentos tienen que ser en este formato: [IP,Instancia,Usuario,Password,NombreFichero]");

		switch (args.length) {
		case 0:
			System.err.println("Faltan los argumentos [IP,Instancia,Usuario,Password,NombreFichero]");
			break;
		case 1:
			System.err.println("Faltan los argumentos [Instancia,Usuario,Password,NombreFichero]");
			break;
		case 2:
			System.err.println("Faltan los argumentos [Usuario,Password,NombreFichero]");
			break;
		case 3:
			System.err.println("Faltan los argumentos [Password,NombreFichero]");
			break;
		case 4:
			System.err.println("Faltan los argumentos [NombreFichero]");
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