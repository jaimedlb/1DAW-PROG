package com.gsd.daw.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImagenFil {

	public static String[] ConversorArray(String[] fil) {
		Scanner inputFile = null;
		try {
			File f = new File(fil[0]);
			inputFile = new Scanner( f );

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se puede abrir el fichero [" + fil[0] + "]");
		}
		while (inputFile.hasNext()) {
            String line = inputFile.nextLine();
            System.out.println("---" + line + "---");
        }
		return null;
	}
}
