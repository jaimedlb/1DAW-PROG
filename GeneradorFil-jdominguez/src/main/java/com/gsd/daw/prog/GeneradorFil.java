package com.gsd.daw.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GenereadorFil {

	public static boolean StringconversorFil(String[] fil) {

		try {
			String[] nombreSpliteado = String.valueOf(fil[0]).split("#|\\.");
			String nombreArchivo = nombreSpliteado[1];
			String nombreFinal = nombreArchivo + "-cambiado.fil";
			File archivo = new File(nombreFinal);

			FileWriter escribo = new FileWriter(archivo);
			escribo.write("#" + nombreFinal + "\n");
			for (int i = 1; i < fil.length; i++) {
				if (i == fil.length - 1) {
					escribo.write(fil[i]);
				} else {
					escribo.write(fil[i] + "\n");
				}
			}
			escribo.close();
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al crear el archivo.");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static String[] GeneradorAleatorioRGB(){
		int[] ValoresInt= new int[3];
		Random random = new Random();
		int randomNumber = random.nextInt(256);
		
		
		return null;

	}

}
