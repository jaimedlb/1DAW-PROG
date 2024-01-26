package com.gsd.daw.prog;

import java.io.File;
import java.io.FileWriter;

public class App {

	public static void main(String[] args) {
		System.out.println("#aleatorio");
System.out.println(args[0]);
System.out.println(args[1]);
		for (int i = 0; i < (Integer.parseInt(args[0])*Integer.parseInt(args[1])); i++) {
			System.out.println(GenereadorFil.GeneradorAleatorioRGB());
		}
		
	}
}
