package com.gsd.daw.prog;

public class App {

	public static void main(String[] args) {

		String[] imagen = ImagenFil.ConversorArray(args);
		String[] numerosSpliteados=new String[3];
		for (int i = 3; i < imagen.length - 3; i++) {
		 numerosSpliteados = imagen[i].split(",");
			int[] numerosSpliteadosInt = new int[3];
			for (int j = 0; j < numerosSpliteados.length; j++) {
				numerosSpliteadosInt[j] = Integer.parseInt(numerosSpliteados[j]);
				numerosSpliteadosInt[j] = numerosSpliteadosInt[j] + Integer.parseInt(args[1]);
				if (numerosSpliteadosInt[j] < 0) {
					numerosSpliteadosInt[j] = 0;
				}
				if (numerosSpliteadosInt[j] > 255) {
					numerosSpliteadosInt[j] = 255;
				}
			}
			for (int j = 0; j < numerosSpliteadosInt.length; j++) {
				numerosSpliteados[j]=String.valueOf(numerosSpliteadosInt[j]);
			}
			imagen[i]=numerosSpliteados[0]+","+numerosSpliteados[1]+","+numerosSpliteados[2];	
			
		}
		ImagenFil.StringconversorFil(imagen);

	}
}
