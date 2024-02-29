package com.gsd.daw.prog;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.oracore.Util;

public class ApacheAnalizer {
	public static void main( String[] args ) {
	    // Comprobación de argumentos
		if (args.length != 4) {
			System.err.println("Para que el programa funcione se necesitan 5 parametros");
			return;
		}
		
	    // Creacion de la conexión
		Connection conexion= Utilidades.conexion(args);
		if(conexion==null) {
			return;
		}
	    System.out.println( "INFO: conectado a BBDD." );

	    // Carga de objetos del modelo de BBDD a estructura plana
	    // Esto sin colecciones será un String[][] array de tamaño máximo 10000
	    // elementos
	    // Crea una clase aparte cuya responsabilidad sea recibir una conexion de BBDD 
	    // y devolver una estructura String[10000][6] con los datos en columnas
	    List<String[]> valores=null;
	    try {
			
	    	valores=com.gsd.daw.prog.Utilidades.estructurarSelect(conexion);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

  System.out.println( "INFO: leidas [" + valores.size() + "] lineas de BBDD." );

	    // Conversion de estructuras planas a objetos del modelo
	    // Reusa la clase que ya creaste para convertir la estructura "anónima"
	    // en un array de objetos del modelo
  List<Log> objLog = new ArrayList<>();
	for (int i = 0; i < valores.size(); i++) {
		objLog.add(new Log(valores.get(i)));
	}

	    System.out.println( "INFO: creados [" + objLog.size() + "] objetos del modelo." );

	    // Crea una clase separada para realizar cálculos y analisis sobre
	    // el array de objetos del modelo
	    // Puede ser una librería de funciones static (sin datos propios)
	    // que reciban un array de objetos del modelo y realicen cálculos sobre ellos
	    // Recuerda dividir responsabilidades entre calcular e imprimir.
Calculos.numeroIps(objLog);
	    // Los cálculos que se piden están especificados en el enunciado
	}
}
