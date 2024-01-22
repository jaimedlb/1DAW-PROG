package com.gsd.daw.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImagenFil {

	public static String[] ConversorArray(String[] fil) {
		Scanner inputFile = null;
		try {
			File f = new File(fil[0]);
			inputFile = new Scanner(f);

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se puede abrir el fichero [" + fil[0] + "]");
		}
		inputFile.nextLine();
		int filas = Integer.parseInt(inputFile.nextLine());
		int columnas = Integer.parseInt(inputFile.nextLine());
		String[] parametros = new String[(filas * columnas)+2];
		parametros[0]=String.valueOf(filas);
		parametros[1]=String.valueOf(columnas);

		for (int i = 2; i < parametros.length; i++) {
			String linea = inputFile.nextLine();
			parametros[i] = linea;

		}
		System.out.println();
		return parametros;
	}
}
