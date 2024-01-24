package com.gsd.daw.prog;

public class Calculadora {

	public static String calculadora(String[] argumentos) {
		if (!Utilidades.robustez(argumentos)) {
			return "";
		}
		Double notaFinal = 0.1;
		Double notasC = 0.0;
		Double notasP = 0.0;
		Double notaAc = 0.0;
		Double notaAs = 0.0;
		int P = 0;
		int C = 0;
		for (int i = 0; i < argumentos.length; i++) {
			String[] caracteres = (argumentos[i].split("-"));
			Double nota = Double.parseDouble(caracteres[1]);
			if (caracteres[0].equals("C")) {
				if (nota < 3) {
					notaFinal = 0.0;
					break;
				} else {
					notasC = nota + notasC;
					C++;
				}
			}
			if (caracteres[0].equals("P")) {
				if (nota < 5) {
					notaFinal = 0.0;
					break;
				} else {
					notasP = nota + notasP;
					P++;
				}
			}
			if (caracteres[0].equals("A")) {
				notaAc = nota;
			}
			if (caracteres[0].equals("T")) {
				notaAs = nota;
			}
		}
		if (notaFinal == 0.0) {
			
			return Utilidades.imprimirNota(notaFinal);
		}
		double mediaT = ((notasP / P) + (notasC / C)) / 2;
		if (mediaT < 5) {
			notaFinal = mediaT;
			return Utilidades.imprimirNota(notaFinal);
		}
		notaFinal = (mediaT * 0.8) + (notaAc + notaAs);

		return Utilidades.imprimirNota(notaFinal);

	}
}
