package com.gsd.daw.prog;
public class App {

	public static void main(String[] args) {
		
		 String[] imagen=ImagenFil.ConversorArray(args);
		 for (int i = 2; i < imagen.length-3; i++) {
			String[] numerosSpliteados=imagen[i].split(",");
			int[] numerosSpliteadosInt=new int[3];
			for (int j = 0; j < numerosSpliteados.length; j++) {
				numerosSpliteadosInt[j]=Integer.parseInt(numerosSpliteados[j]);
			}
			
		}
		ImagenFil.StringconversorFil(imagen);
		
		} 
	}
