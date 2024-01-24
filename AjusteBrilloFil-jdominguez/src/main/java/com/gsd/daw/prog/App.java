package com.gsd.daw.prog;

public class App {

	public static void main(String[] args) {

		if (!Utilidades.ComprobarRobustez(args)) {
			return;
		}
		String[] imagen = ImagenFil.ConversorArray(args);
		if (imagen == null) {
			return;
		}
		String[] numerosSpliteados = new String[3];
		for (int i = 3; i < imagen.length; i++) {
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
				numerosSpliteados[j] = String.valueOf(numerosSpliteadosInt[j]);
			}
			imagen[i] = numerosSpliteados[0] + "," + numerosSpliteados[1] + "," + numerosSpliteados[2];

		}
		for (int i = 0; i < imagen.length; i++) {
			System.out.println(imagen[i]);
		}
	}
}
