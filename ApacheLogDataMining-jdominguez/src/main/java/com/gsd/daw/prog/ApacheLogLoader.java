package com.gsd.daw.prog;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApacheLogLoader {
	public static void main(String[] args) {
		// Comprobación de argumentos
		if (args.length != 5) {
			System.err.println("Para que el programa funcione se necesitan 5 parametros");
			return;
		}

		// Creacion de la conexión
		Connection conexion= Utilidades.conexion(args);
		if(conexion==null) {
			return;
		}
		System.out.println("INFO: conectado a BBDD.");

		// Lectura de datos a estructuras planas
		// Esto sin colecciones será un String[][] array de tamaño máximo 10000
		// elementos
		// Crea una clase aparte cuya responsabilidad sea recibir un nombre de fichero
		// y devolver una estructura String[10000][6] con los datos en columnas

		List<String[]> valores = Utilidades.estructurarLog(args[4]);
		if(valores==null) {
			return;
		}
		System.out.println("INFO: leidas [" + valores.size() + "] lineas del fichero.");
		
		// Conversion de estructuras planas a objetos del modelo
		// Crea una clase que modele los datos que tiene una linea de log de Apache
		// Convierte la estructura "anónima" en un array de objetos del modelo
		List<Log> objLog = new ArrayList<>();
		for (int i = 0; i < valores.size(); i++) {
			try {
				objLog.add(new Log(valores.get(i)));				
			} catch (Exception e) {
				System.err.println("problema en el fichero"+e.getMessage());
			}
		}

		 System.out.println("INFO: creados [" + objLog.size() + "] objetos del modelo.");
		 

		// Guardado de los objetos del modelo en BBDD
		// La clase del modelo debe tener un método save( Connection ) que recibe una
		// conexion JDBC y hace que los datos del objeto se guarden en BBDD
		 int i;
			for (i = 0; i < objLog.size(); i++) {
				Log l1= objLog.get(i);
				try {
					
					l1.save(conexion);
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
			
		

		 System.out.println("INFO: insertadas [" + i + "] filas en BBDD.");
	}
}
