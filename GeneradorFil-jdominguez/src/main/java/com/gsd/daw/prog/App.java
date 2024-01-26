package com.gsd.daw.prog;

import java.io.File;
import java.io.FileWriter;

public class App {

	public static void main(String[] args) {
		File archivo = new File("aleatorio.fil");
		int ancho = Integer.parseInt(args[0]);
		int alto = Integer.parseInt(args[1]);
		FileWriter escribo = null;
		try {
			escribo = new FileWriter(archivo);
			escribo.write("# archivo Generado aleatoriamente \n");
			escribo.write(ancho+"\n");
			escribo.write(alto+"\n");
			for (int i = 0; i < (ancho * alto)-1; i++) {
				escribo.write(GenereadorFil.GeneradorAleatorioRGB()+"\n");
			}
			escribo.write(GenereadorFil.GeneradorAleatorioRGB());

			escribo.close();

		} catch (Exception e) {
			System.err.println("no se encuentra el archivo");
			return;
		}
		
	}
}
