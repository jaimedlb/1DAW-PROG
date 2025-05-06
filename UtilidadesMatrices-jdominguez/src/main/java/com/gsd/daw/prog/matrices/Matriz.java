package com.gsd.daw.prog.matrices;

public class Matriz {

	public static int[][] crearIncrementada(int[][] m, int incremento) {
		if (!isMatrizValida(m))
			return null;
		int[][] matrizIncrementada = new int[m.length][m[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				matrizIncrementada[i][j] = m[i][j] + incremento;
			}

		}
		return matrizIncrementada;
	}

	public static int[][] crearSuma(int[][] a, int[][] b) {
		if (!isMatrizValida(a) || !isMatrizValida(b) || a.length != b.length)
			return null;

		for (int i = 0; i < b.length; i++) {
			if (a[i] == null || b[i] == null)
				return null;
			if (a[i].length != b[i].length)
				return null;
		}
		int[][] nuevaMatriz = new int[a.length][a[0].length];
		;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				nuevaMatriz[i][j] = a[i][j] + b[i][j];
			}
		}

		return nuevaMatriz;
	}

	public static int[][] crearTraspuesta(int[][] m) {
		if (!isMatrizValida(m))
			return null;

		int[][] matrizTranspuesta = new int[m[0].length][m.length];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				matrizTranspuesta[j][i] = m[i][j];
			}
		}

		return matrizTranspuesta;
	}

	public static int getMaximoElemento(int[][] m) {
		if (!isMatrizValida(m))
			return Integer.MIN_VALUE;
		int maximoValor = Integer.MIN_VALUE;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] > maximoValor)
					maximoValor = m[i][j];
			}
		}

		return maximoValor;
	}

	public static int[] getPosicionMaximoElemento(int[][] m) {
		if (!isMatrizValida(m))
			return null;
		int maximoValor = Integer.MIN_VALUE;
		int[] posicion = new int[2];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] > maximoValor) {
					maximoValor = m[i][j];
					posicion[0] = i;
					posicion[1] = j;
				}
			}
		}

		return posicion;
	}

	public static void incrementar(int[][] m, int incremento) {
		if (!isMatrizValida(m))
			return;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] += incremento;
			}

		}

	}

	public static boolean isMatrizValida(int[][] m) {

		if (m == null || m.length == 0) {
			return false;
		}

		int numColumnas = m[0].length;
		for (int i = 0; i < m.length; i++) {
			if (m[i] == null || m[i].length != numColumnas) {
				return false;
			}
		}

		return true;
	}

	public static void sumar(int[][] a, int[][] b) {
		if (!isMatrizValida(a) || !isMatrizValida(b) || a.length != b.length)
			return;

		for (int i = 0; i < b.length; i++) {
			if (a[i] == null || b[i] == null)
				return;
			if (a[i].length != b[i].length)
				return;
		}

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				a[i][j] += b[i][j];
			}
		}

	}

	public static String toString(int[][] m) {
		if (!isMatrizValida(m))
			return null;

		StringBuilder sb = new StringBuilder();
		for (int[] fila : m) {
			for (int valor : fila) {
				sb.append(valor + " ");

			}
		}
		return sb.toString().trim();
	}

}
