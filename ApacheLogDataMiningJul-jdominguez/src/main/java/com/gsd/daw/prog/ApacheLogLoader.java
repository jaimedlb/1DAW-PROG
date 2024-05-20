package com.gsd.daw.prog;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApacheLogLoader {
	public static Logger LOGGER = ApacheLogLoader.getLogger();

	public static Logger getLogger() {
		return Logger.getLogger("LOGGER ApacheLogLoader");
	}

	public static void main(String[] args) {
		Utilidades.comprobarlogLevel();
		// Comprobación de argumentos

		if (args.length != 5) {
			LOGGER.log(Level.SEVERE,"Para que el programa funcione se necesitan 5 o 6 parametros");
			return;
		}

		// Creacion de la conexión
		Connection conexion = Utilidades.conexion(args);
		if (conexion == null) {
			return;
		}
		LOGGER.log(Level.INFO,"conectado a BBDD.");


		// Lectura de datos a estructuras planas
		// Esto sin colecciones será un String[][] array de tamaño máximo 10000
		// elementos
		// Crea una clase aparte cuya responsabilidad sea recibir un nombre de fichero
		// y devolver una estructura String[10000][6] con los datos en columnas

		List<String[]> valores = Utilidades.estructurarLog(args[4]);
		if (valores == null) {
			return;
		}
		LOGGER.log(Level.INFO,"INFO: leidas [" + valores.size() + "] lineas del fichero.");

		// Conversion de estructuras planas a objetos del modelo
		// Crea una clase que modele los datos que tiene una linea de log de Apache
		// Convierte la estructura "anónima" en un array de objetos del modelo
		List<Log> objLog = new ArrayList<>();
		for (int i = 0; i < valores.size(); i++) {
			try {
				objLog.add(new Log(valores.get(i)));
				LOGGER.log(Level.FINE,"Parseada linea ["+i+"] con timestamp: ["+valores.get(i)[1]+"]");
				
			} catch (Exception e) {

			}
		}
		LOGGER.log(Level.INFO,"creados [" + objLog.size() + "] objetos del modelo.");

		// Guardado de los objetos del modelo en BBDD
		// La clase del modelo debe tener un método save( Connection ) que recibe una
		// conexion JDBC y hace que los datos del objeto se guarden en BBDD
		int i;
		int contador = 0;
		for (i = 0; i < objLog.size(); i++) {
			Log l1 = objLog.get(i);
			try {

				if (l1.save(conexion)) {
					LOGGER.log(Level.FINE,"Insertando linea ["+i+"] con timestamp: ["+l1.getTimeStamp()+"]");
					contador++;
				}
			} catch (SQLException e) {	
				System.err.println(e.getMessage());
			}

		}
		try {
			conexion.close();
		} catch (Exception e) {
		}
		LOGGER.log(Level.INFO,"insertadas [" + contador + "] filas en BBDD.");
	}
}
