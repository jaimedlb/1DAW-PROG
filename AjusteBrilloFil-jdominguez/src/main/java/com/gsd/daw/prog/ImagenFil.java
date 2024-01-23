package com.gsd.daw.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
		String comentario="#"+String.valueOf(fil[0]);
		inputFile.nextLine();
		int filas = Integer.parseInt(inputFile.nextLine());
		int columnas = Integer.parseInt(inputFile.nextLine());
		String[] parametros = new String[(filas * columnas)+3];
		parametros[0]=comentario;
		parametros[1]=String.valueOf(filas);
		parametros[2]=String.valueOf(columnas);

		for (int i = 3; i < parametros.length; i++) {
			String linea = inputFile.nextLine();
			parametros[i] = linea;

		}

		return parametros;
	}
	/*public static boolean StringconversorFil(String[] fil) {
		
		try {
		String[] nombreSpliteado=String.valueOf(fil[0]).split("#|\\.");
		String nombreArchivo=nombreSpliteado[1];
		String nombreFinal=nombreArchivo+"-cambiado.fil";
		File archivo =new File(nombreFinal);
			 
			FileWriter escribo = new FileWriter(archivo);
			escribo.write("#"+nombreFinal+"\n");
			for (int i = 1; i < fil.length; i++) {
				if(i==fil.length-1) {
					escribo.write(fil[i]);
				}else {
					escribo.write(fil[i]+"\n");					
				}
			}
			escribo.close();
		}catch (IOException e) {
			System.out.println("Ha ocurrido un error al crear el archivo.");
            e.printStackTrace();
            return false;
		}
		return true;
	}*/
}

