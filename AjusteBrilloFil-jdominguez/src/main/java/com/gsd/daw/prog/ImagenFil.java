package com.gsd.daw.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ImagenFil {

	public static String[] conversorArray(String[] fil) {
		Scanner inputFile = null;
		int filas = 0;
		int columnas = 0;

		try {
			File f = new File(fil[0]);
			inputFile = new Scanner(f);

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se puede abrir el fichero [" + fil[0] + "]");
			return null;
		}

		String comentario = String.valueOf(inputFile.nextLine());
		try {
			filas = Integer.parseInt(inputFile.nextLine());
			columnas = Integer.parseInt(inputFile.nextLine());
		} catch (Exception e) {
			System.err.println("Las lineas 2 y 3 tiene que ser un numero para saber la longitud");
			inputFile.close();
			return null;

		}
		try {

			if (!Utilidades.comprobarNumeroLineas(fil[0], (filas * columnas))) {
				inputFile.close();
				System.err.println("la Filas X columnas no concuerda con los datos");
				return null;
			}
		} catch (IOException e) {
			System.err.println("Error en archivo");
		}

		String[] parametros = new String[(filas * columnas) + 3];
		parametros[0] = comentario;
		parametros[1] = String.valueOf(filas);
		parametros[2] = String.valueOf(columnas);

		for (int i = 3; i < parametros.length; i++) {
			String linea = inputFile.nextLine();
			parametros[i] = linea;

		}
		inputFile.close();
		return parametros;
	}
	/*
	 * public static boolean StringconversorFil(String[] fil) {
	 * 
	 * try { String[] nombreSpliteado=String.valueOf(fil[0]).split("#|\\."); String
	 * nombreArchivo=nombreSpliteado[1]; String
	 * nombreFinal=nombreArchivo+"-cambiado.fil"; File archivo =new
	 * File(nombreFinal);
	 * 
	 * FileWriter escribo = new FileWriter(archivo);
	 * escribo.write("#"+nombreFinal+"\n"); for (int i = 1; i < fil.length; i++) {
	 * if(i==fil.length-1) { escribo.write(fil[i]); }else {
	 * escribo.write(fil[i]+"\n"); } } escribo.close(); }catch (IOException e) {
	 * System.out.println("Ha ocurrido un error al crear el archivo.");
	 * e.printStackTrace(); return false; } return true; }
	 */
}
