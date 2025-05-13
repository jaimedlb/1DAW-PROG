package com.gsd.daw.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author jdominguez
 */
public class App {

	public static void main(String[] args) {
		if (args.length < 2) {

			System.err.println("Se necesitan 2 argumentos para continuar");
			return;
		}
		String ficheroFiguras = args[0];
		String ficheroSvg = args[1];

		Scanner inputScannerFromFile = null;
		File f = new File(ficheroFiguras);
		try {
			inputScannerFromFile = new Scanner(f);

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se puede abrir [" + ficheroFiguras + "]\n" + e.getMessage());
			return;
		}
		boolean noError = true;
		if(!inputScannerFromFile.hasNext()) {
			return;
		}
		while (inputScannerFromFile.hasNext()) {

			String line = inputScannerFromFile.nextLine();

			if (!Utilidades.comprobarLineas(line)) {
				noError = false;
				return;
			}

		}
		if (noError == true) {
			try (FileWriter writer = new FileWriter(ficheroSvg)) {
				writer.write(Utilidades.devolverContenedor().toSvg());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		inputScannerFromFile.close();

	}
}
