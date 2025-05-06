package com.gsd.daw.prog;


import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author jdominguez
 */
public class App { 
    public static void main(String[] args) {
    	if(args.length<2) {
			throw new IllegalArgumentException("Se necesitan 2 argumentos para continuar");
		}
    	String ficheroFiguras = args[0];
    	String ficheroSvg =args[1];
    	

		Scanner inputScannerFromFile = null;
		File f = new File(args[0]);
		try {
			inputScannerFromFile = new Scanner(f);
			
			
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se puede abrir [" + args[0] + "]\n" + e.getMessage());
			return;
		}
List<List<String>> lista= new ArrayList<>();
		while (inputScannerFromFile.hasNext()) {
			List<String> sublista= new ArrayList<>();
			String line = inputScannerFromFile.nextLine();
			String[] parametros= line.split(" ");
			for(String parametro:parametros) {
				sublista.add(parametro);
			}
			lista.add(sublista);
			
		}

		inputScannerFromFile.close();


    }
}
