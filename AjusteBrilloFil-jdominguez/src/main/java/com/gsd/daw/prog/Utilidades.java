package com.gsd.daw.prog;
import java.io.File;
import java.util.Scanner;
public class Utilidades {
	public static boolean ComprobarRobustez(String[] args) {
		if (args.length != 2) {
			System.err.println("pasame dos argumentos");
			return false;
		}
		if (Integer.parseInt(args[1]) > 255 || Integer.parseInt(args[1]) < -255) {
			System.err.println("pasame un numero entre -255 y 255");
			return false;
		}

		return true;
	}

	public static boolean comprobarLineas (File archivo) {
	
		
		return true;
	}
}
