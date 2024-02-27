package com.gsd.daw.prog.ApacheLogLoader;

public class ApacheLogLoader {
	public static void main(String[] args) {
		// Comprobación de argumentos
		if(args.length!=5) {
			System.err.println("Para que el programa funcione se necesitan 5 parametros");
			return;
		}

		// Creacion de la conexión
		Utilidades.conexion(args);
		


		// Lectura de datos a estructuras planas
		// Esto sin colecciones será un String[][] array de tamaño máximo 10000
		// elementos
		// Crea una clase aparte cuya responsabilidad sea recibir un nombre de fichero
		// y devolver una estructura String[10000][6] con los datos en columnas
		
String[][] valores=Utilidades.estructuraLog(args[4]);
		
	System.out.println("INFO: leidas [" + vañp + "] lineas del fichero.");

		// Conversion de estructuras planas a objetos del modelo
		// Crea una clase que modele los datos que tiene una linea de log de Apache
		// Convierte la estructura "anónima" en un array de objetos del modelo

		//System.out.println("INFO: creados [" + ponTuVariableAqui + "] objetos del modelo.");

		// Guardado de los objetos del modelo en BBDD
		// La clase del modelo debe tener un método save( Connection ) que recibe una
		// conexion JDBC y hace que los datos del objeto se guarden en BBDD

	//	System.out.println("INFO: insertadas [" + i + "] filas en BBDD.");
	}
}
