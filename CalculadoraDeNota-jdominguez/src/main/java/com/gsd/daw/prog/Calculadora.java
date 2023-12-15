package com.gsd.daw.prog;

import java.text.DecimalFormat;

public class Calculadora {
	public static boolean robustez(String[] argumentos) {
		boolean cierto = true;
		int C = 0, P = 0, A = 0, T = 0;
		if (argumentos.length == 0) {
			System.out.println("ponme algun argumento");
			return cierto = false;
		}
		if (argumentos.length > 20) {
			System.out.println("no pongas mas de 20 argumentos");
			return cierto = false;
		} else {
			for (int i = 0; i < argumentos.length; i++) {
				String[] caracteres = (argumentos[i].split("-"));
				if (caracteres.length == 1) {
					System.out.println("pasame bien el formato [CPTA]-<numero-decimal>");
					return cierto = false;
				} else {
					if ((caracteres[0].equals("C") || caracteres[0].equals("P") || caracteres[0].equals("A")
							|| caracteres[0].equals("T"))) {

						try {
							Double.parseDouble(caracteres[1]);
						} catch (NumberFormatException qwe) {

							System.out.println("pasamed bien el formato [CPTA]-<numero-decimal>");
							return cierto = false;
						}
					} else {
						System.out.println("pasame bien el formato [CPTA]-<numero-decimal>");
						return cierto = false;
					}
				}
				if (cierto) {
					if ((caracteres[0].equals("C"))) {
						C++;
						if (Double.parseDouble(caracteres[1]) < 0 || Double.parseDouble(caracteres[1]) > 10) {
							System.out.println("ERROR: el numero en la nota ["+argumentos[i]+"] no esta dentro de limites");
							return cierto = false;
						}
					} else {
						if ((caracteres[0].equals("P"))) {
							P++;
							if (Double.parseDouble(caracteres[1]) < 0 || Double.parseDouble(caracteres[1]) > 10) {
								System.out.println("ERROR: el numero en la nota ["+argumentos[i]+"] no esta dentro de limites");
								return cierto = false;
							}
						} else {
							if ((caracteres[0].equals("A"))) {
								A++;
								if (Double.parseDouble(caracteres[1]) < 0 || Double.parseDouble(caracteres[1]) > 1) {
									System.out.println("ERROR: el numero en la nota ["+argumentos[i]+"] no esta dentro de limites");
									return cierto = false;
								}
							} else {
								T++;
								if (Double.parseDouble(caracteres[1]) < 0 || Double.parseDouble(caracteres[1]) > 1) {
									System.out.println("ERROR: el numero en la nota ["+argumentos[i]+"] no esta dentro de limites");
									return cierto = false;
								}
							}
						}
					}
				}
			}
			if (C >= 1 && P >= 1 && A == 1 && T == 1) {
				return cierto;
			} else {
				System.out.println("tiene que haber al menos una nota de examen, practicas, asistencia y actitud");
				return cierto = false;
			}
		}
	}
	public static void calculadora(String[] argumentos) {
		if (robustez(argumentos)) {
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
			if(notaFinal==0.0){
				System.out.println(0);
			}else {
			double mediaT = ((notasP / P) + (notasC / C)) / 2;
			if (mediaT < 4) {
				notaFinal = mediaT;
			} else {
				notaFinal = (mediaT * 0.8) + (notaAc + notaAs);
			}
			if (notaFinal == 10) {
				System.out.println("MH");
			}else {
				DecimalFormat df = new DecimalFormat("#.00");
				System.out.println(df.format(notaFinal));
			}}
		}
	}
}
