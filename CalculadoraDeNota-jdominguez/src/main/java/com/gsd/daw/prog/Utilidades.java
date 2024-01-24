package com.gsd.daw.prog;

public class Utilidades {
	public static boolean robustez(String[] argumentos) {
		boolean cierto = true;
		int C = 0, P = 0, A = 0, T = 0;
		if (argumentos.length > 4 || argumentos.length < 20) {
			System.out.println("argumento no valido, Limite: <4-20>");
			return false;
		}
		for (int i = 0; i < argumentos.length; i++) {
			String[] caracteres = (argumentos[i].split("-"));
			if (caracteres.length == 1) {
				System.out.println("pasame bien el formato [CPTA]-<numero-decimal>");
				return false;
			}
			if ((!caracteres[0].equals("C") || !caracteres[0].equals("P") || !caracteres[0].equals("A")
					|| !caracteres[0].equals("T"))) {
				System.out.println("pasamed bien el formato [CPTA]-<numero-decimal>");
				return false;
			}
			try {
				Double.parseDouble(caracteres[1]);
			} catch (NumberFormatException qwe) {
				System.out.println("pasame bien el formato [CPTA]-<numero-decimal>");
				return false;
			}

				if ((caracteres[0].equals("C"))) {
					C++;
					if (Double.parseDouble(caracteres[1]) < 0 || Double.parseDouble(caracteres[1]) > 10) {
						System.out.println(
								"ERROR: el numero en la nota [" + argumentos[i] + "] no esta dentro de limites");
						return cierto = false;
					}
				} else {
					if ((caracteres[0].equals("P"))) {
						P++;
						if (Double.parseDouble(caracteres[1]) < 0 || Double.parseDouble(caracteres[1]) > 10) {
							System.out.println(
									"ERROR: el numero en la nota [" + argumentos[i] + "] no esta dentro de limites");
							return cierto = false;
						}
					} else {
						if ((caracteres[0].equals("A"))) {
							A++;
							if (Double.parseDouble(caracteres[1]) < 0 || Double.parseDouble(caracteres[1]) > 1) {
								System.out.println("ERROR: el numero en la nota [" + argumentos[i]
										+ "] no esta dentro de limites");
								return cierto = false;
							}
						} else {
							T++;
							if (Double.parseDouble(caracteres[1]) < 0 || Double.parseDouble(caracteres[1]) > 1) {
								System.out.println("ERROR: el numero en la nota [" + argumentos[i]
										+ "] no esta dentro de limites");
								return cierto = false;
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
