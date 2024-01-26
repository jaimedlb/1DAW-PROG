package com.gsd.daw.prog;

import java.util.Random;

public class GenereadorFil {
	public static String GeneradorAleatorioRGB() {
		int[] valoresInt = new int[3];
		Random random = new Random();
		for (int i = 0; i < valoresInt.length; i++) {
			int randomNumber = random.nextInt(256);
			valoresInt[i] = randomNumber;
		}
		String valoresString = "";
		for (int i = 0; i < valoresInt.length; i++) {
			if (i == valoresInt.length - 1) {
				valoresString = valoresString + String.valueOf(valoresInt[i]);
			} else {
				valoresString = valoresString + String.valueOf(valoresInt[i]) + ",";
			}
		}
		return valoresString;

	}

}
