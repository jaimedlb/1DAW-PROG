package com.gsd.daw.prog;

public class App {

	public static void main(String[] args) {

		String[] imagen = ImagenFil.ConversorArray(args);
		for (int i = 2; i < imagen.length - 3; i++) {
			String[] numerosSpliteados = imagen[i].split(",");
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

			
			
			
		}
		ImagenFil.StringconversorFil(imagen);

	}
}
