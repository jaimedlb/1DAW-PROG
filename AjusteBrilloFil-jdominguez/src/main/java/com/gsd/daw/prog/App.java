package com.gsd.daw.prog;

public class App {

	public static void main(String[] args) {

		if (!Utilidades.comprobarRobustez(args)) {
			return;
			
		}
		String[] imagen = ImagenFil.conversorArray(args);
		if (imagen == null) {
			return;
		}
		String[] numerosSpliteados = new String[3];
		for (int i = 3; i < imagen.length; i++) {
			numerosSpliteados = imagen[i].split(",");
			if(numerosSpliteados.length!=3) {
				System.err.println("El formato de RGB tiene que ser 0-255,0-255,0-255");
				return;
			}
			int[] numerosSpliteadosInt = new int[3];
			for (int j = 0; j < numerosSpliteados.length; j++) {
				try {
					numerosSpliteadosInt[j] = Integer.parseInt(numerosSpliteados[j]);
				} catch (Exception e) {
					System.err.println("El formato de RGB tiene que ser 0-255,0-255,0-255");
					return;
				}
				if (numerosSpliteadosInt[j] > 255 || numerosSpliteadosInt[j] < 0) {
					System.err.println("El formato de RGB tiene que ser 0-255,0-255,0-255");
					return;
				}
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
