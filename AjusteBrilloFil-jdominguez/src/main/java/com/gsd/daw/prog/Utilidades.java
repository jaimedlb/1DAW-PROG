package com.gsd.daw.prog;

public class Utilidades {
	public static boolean ComprobarRobustez(String[] args) {
		if(args.length!=2) {
			System.err.println("pasame dos argumentos");
			return false;
		}
		if(Integer.parseInt(args[1])>255||Integer.parseInt(args[1])<-255) {
			System.err.println("pasame un numero entre -255 y 255");
			return false;
		}
		
		return true;
	}
}
