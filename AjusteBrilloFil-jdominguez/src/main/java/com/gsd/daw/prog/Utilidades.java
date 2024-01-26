package com.gsd.daw.prog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Utilidades {
	public static boolean comprobarRobustez(String[] args) {
		if (args.length != 2) {
			System.err.println("pasame dos argumentos");
			return false;
		}try {
			Integer.parseInt(args[1]);
			
		} catch (Exception e) {
			System.out.println("El formato de RGB tiene que ser 0-255,0-255,0-255");
			return false;
		}
		if (Integer.parseInt(args[1]) > 255 || Integer.parseInt(args[1]) < -255) {
			System.err.println("pasame un numero entre -255 y 255");
			return false;
		}
		if (Integer.parseInt(args[1]) > 255 || Integer.parseInt(args[1]) < -255) {
			System.err.println("pasame un numero entre -255 y 255");
			return false;
		}

		return true;
	}

	public static boolean comprobarNumeroLineas(String file, int tamaño) throws IOException {
		File archivo = new File(file);
		FileReader arhivoLectura = new FileReader(archivo);
		BufferedReader bufferArchivo = new BufferedReader(arhivoLectura);
		int contadorLineas = 0;
		String linea = bufferArchivo.readLine();
		while (linea != null) {
			contadorLineas++;
			linea = bufferArchivo.readLine();
		}
		if ((contadorLineas - 3) == tamaño) {
			bufferArchivo.close();
			return true;
		}
		bufferArchivo.close();
		return false;
	}

}
