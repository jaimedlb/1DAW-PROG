package com.gsd.daw.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;

public class App {

	public static void main(String[] args) {
		File archivo = new File("aleatorio.fil");
		int fila = Integer.parseInt(args[0]);
		int columna = Integer.parseInt(args[1]);
		FileWriter escribo = null;
		try {
			escribo = new FileWriter(archivo);
			escribo.write("# archivo Generado aleatoriamente \n");
			escribo.write(fila);
			escribo.write(columna);
			for (int i = 0; i == fila * columna; i++) {

				escribo.write(GenereadorFil.GeneradorAleatorioRGB());
			}
			escribo.close();

		} catch (Exception e) {
			System.err.println("no se encuentra el archivo");
			return;
		}

	}
}
