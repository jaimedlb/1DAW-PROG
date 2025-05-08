package com.gsd.daw.prog;

import java.util.HashMap;

import java.util.Map;

import com.gsd.daw.prog.figuras.Circulo;
import com.gsd.daw.prog.figuras.Color;
import com.gsd.daw.prog.figuras.Contenedor;
import com.gsd.daw.prog.figuras.Elipse;
import com.gsd.daw.prog.figuras.Linea;
import com.gsd.daw.prog.figuras.LineaPoligonal;
import com.gsd.daw.prog.figuras.Poligono;
import com.gsd.daw.prog.figuras.Punto;
import com.gsd.daw.prog.figuras.Rectangulo;
import com.gsd.daw.prog.figuras.Stroke;

public class Utilidades {

	private static int numeroLinea = 1;
	private static Contenedor contenedorPrincipal = null;
	private static Map<String, Stroke> mapaStroke = new HashMap<>();
	

	

	public static boolean comprobarLineas(String line) {
		String[] parametros = line.split(" ");

		if ("CO".equals(parametros[0])) {
			if (!comprobarAtributosContenedor(parametros)) {
				return false;
			}
			int ancho = Integer.parseInt(parametros[1]);
			int alto = Integer.parseInt(parametros[2]);
			contenedorPrincipal = new Contenedor(ancho, alto);
			

		}
		if (contenedorPrincipal == null) {
			System.err.println("El contenedor no esta definido en la 1 linea");
			return false;
		}
		switch (parametros[0]) {

		case "ST":
			if (!comprobarAtributosStroke(parametros)) {
				return false;
			}
			
			mapaStroke.put(parametros[1], construirStroke(parametros));
			break;
		case "CI":
			if (!comprobarAtributosCirculo(parametros)) {
				return false;
			}

			construirCirculo(parametros);
			break;

		case "EL":
			if (!comprobarAtributosElipse(parametros)) {
				return false;
			}

			construirElipse(parametros);
			break;
		case "LI":
			if (!comprobarAtributosLinea(parametros)) {
				return false;
			}
			construirLinea(parametros);
			break;
		case "LP":
			if (!comprobarAtributosLineaPoligonal(parametros)) {
				return false;

			}

		construirLineaPoligonal(parametros);
			break;
		case "PO":
			if (!comprobarAtributosPoligono(parametros)) {
				return false;
			}
			construirPoligono(parametros);
			break;
		case "RE":
			if (!comprobarAtributosRectangulo(parametros)) {
				return false;
			}
			construirRectangulo(parametros);
			break;
		default:
			break;

		}

		numeroLinea++;
		return true;
	}
public static Contenedor devolverContenedor() {
	return contenedorPrincipal;
	
}
	
	
	
	
 	private static Stroke construirStroke(String[] parametros) {
		byte rojo = (byte) Integer.parseInt(parametros[2]);
		byte verde = (byte) Integer.parseInt(parametros[3]);
		byte azul = (byte) Integer.parseInt(parametros[4]);
		int grosor = Integer.parseInt(parametros[parametros.length-1]);

		return new Stroke(new Color(rojo, verde, azul), grosor);
	}

	private static void construirCirculo(String[] parametros) {
		String[] xy = parametros[1].split(",");
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);

		Punto punto = new Punto(x, y);
		
Circulo circulo = new Circulo(punto, Integer.parseInt(parametros[2]));
circulo.setStroke(mapaStroke.get(parametros[3]));
		contenedorPrincipal.addCirculo(circulo);

	}

	private static void construirElipse(String[] parametros) {
		String[] xy = parametros[1].split(",");
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);
		int radio1 = Integer.parseInt(parametros[2]);
		int radio2 = Integer.parseInt(parametros[3]);
		Punto punto = new Punto(x, y);
		Elipse elipse = new Elipse(punto, radio1, radio2);

		elipse.setStroke(mapaStroke.get(parametros[4]));
		contenedorPrincipal.addElipse(elipse);
	}

	private static void construirLinea(String[] parametros) {
		String[] xy = parametros[1].split(",");
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);
		String[] xy2 = parametros[2].split(",");
		int x2 = Integer.parseInt(xy2[0]);
		int y2 = Integer.parseInt(xy2[1]);
		Linea linea = new Linea(new Punto(x, y), new Punto(x2, y2));
		linea.setStroke(mapaStroke.get(parametros[3]));
		contenedorPrincipal.addLinea(linea);

	}

	private static void construirLineaPoligonal(String[] parametros) {
		Punto[] puntos = new Punto[parametros.length - 2];
		for (int i = 1; i < parametros.length - 1; i++) {
			String[] xy = parametros[i].split(",");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			puntos[i-1] = new Punto(x, y);
		}
		LineaPoligonal lineaPoligonal = new LineaPoligonal(puntos);
		lineaPoligonal.setStroke(mapaStroke.get(parametros[parametros.length - 1]));
		contenedorPrincipal.addLineaPoligonal(lineaPoligonal);
	}

	private static void construirPoligono(String[] parametros) {
		Punto[] puntos = new Punto[parametros.length - 2];
		for (int i = 1; i < parametros.length - 1; i++) {
			String[] xy = parametros[i].split(",");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			puntos[i-1] = new Punto(x, y);
		}
		Poligono poligono = new Poligono(puntos);
		poligono.setStroke(mapaStroke.get(parametros[parametros.length - 1]));
		contenedorPrincipal.addPoligono(poligono);

	}

	private static void construirRectangulo(String[] parametros) {
		String[] xy = parametros[1].split(",");
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);
		int ancho = Integer.parseInt(parametros[2]);
		int alto = Integer.parseInt(parametros[3]);
		Punto punto = new Punto(x, y);
		Rectangulo rectangulo = new Rectangulo(punto, ancho, alto);
		rectangulo.setStroke(mapaStroke.get(parametros[parametros.length - 1]));
		contenedorPrincipal.addRectangulo(rectangulo);
	}

	private static boolean comprobarAtributosRectangulo(String[] parametros) {

		if (parametros.length != 5) {
			System.err.println("ERROR: (line " + numeroLinea + ") hay un total de " + parametros.length
					+ " atributos, tiene que haber al menos 5 atributos");
			return false;
		}
		for (int i = 1; i < parametros.length - 1; i++) {
			if (!isNumber(parametros[i])) {
				System.err
						.println("ERROR: (line " + numeroLinea + ") el atributo " + parametros[i] + " no es un numero");
				return false;
			}
		}
		if (!mapaStroke.containsKey((parametros[parametros.length - 1]))) {
			System.err.println("ERROR: (line " + numeroLinea + ") el stroke " + parametros[parametros.length - 1]
					+ " no se ha definido antes");
			return false;
		}

		return true;

	}

	private static boolean comprobarAtributosPoligono(String[] parametros) {

		if (parametros.length < 4) {
			System.err.println("ERROR: (line " + numeroLinea + ") hay un total de " + parametros.length
					+ " atributos, tiene que haber al menos 4 atributos");
			return false;
		}
		for (int i = 1; i < parametros.length - 1; i++) {
			if (!isNumber(parametros[i])) {
				System.err
						.println("ERROR: (line " + numeroLinea + ") el atributo " + parametros[i] + " no es un numero");
				return false;
			}
		}
		if (!mapaStroke.containsKey(parametros[parametros.length - 1])) {
			System.err.println("ERROR: (line " + numeroLinea + ") el stroke " + parametros[parametros.length - 1]
					+ " no se ha definido antes");
			return false;
		}

		return true;

	}

	private static boolean comprobarAtributosLineaPoligonal(String[] parametros) {

		if (parametros.length < 4) {
			System.err.println("ERROR: (line " + numeroLinea + ") hay un total de " + parametros.length
					+ " atributos, tiene que haber al menos 4 atributos");
			return false;
		}
		for (int i = 1; i < parametros.length - 1; i++) {
			if (!isNumber(parametros[i])) {
				System.err
						.println("ERROR: (line " + numeroLinea + ") el atributo " + parametros[i] + " no es un numero");
				return false;
			}
		}
		if (!mapaStroke.containsKey(parametros[parametros.length - 1])) {
			System.err.println("ERROR: (line " + numeroLinea + ") el stroke " + parametros[parametros.length - 1]
					+ " no se ha definido antes");
			return false;
		}

		return true;

	}

	private static boolean comprobarAtributosLinea(String[] parametros) {

		if (parametros.length != 4) {
			System.err.println("ERROR: (line " + numeroLinea + ") hay un total de " + parametros.length
					+ " atributos, tiene que haber 4 atributos");
			return false;
		}
		for (int i = 1; i < parametros.length - 1; i++) {
			if (!isNumber(parametros[i])) {
				System.err
						.println("ERROR: (line " + numeroLinea + ") el atributo " + parametros[i] + " no es un numero");
				return false;
			}
		}
		if (!mapaStroke.containsKey(parametros[parametros.length - 1])) {
			System.err.println("ERROR: (line " + numeroLinea + ") el stroke " + parametros[parametros.length - 1]
					+ " no se ha definido antes");
			return false;
		}

		return true;

	}

	private static boolean comprobarAtributosElipse(String[] parametros) {

		if (parametros.length != 5) {
			System.err.println("ERROR: (line " + numeroLinea + ") hay un total de " + parametros.length
					+ " atributos, tiene que haber 5 atributos");
			return false;
		}
		for (int i = 1; i < parametros.length - 1; i++) {
			if (!isNumber(parametros[i])) {
				System.err
						.println("ERROR: (line " + numeroLinea + ") el atributo " + parametros[i] + " no es un numero");
				return false;
			}
		}
		if (!mapaStroke.containsKey(parametros[parametros.length - 1])) {
			System.err.println("ERROR: (line " + numeroLinea + ") el stroke " + parametros[parametros.length - 1]
					+ " no se ha definido antes");
			return false;
		}

		return true;

	}

	private static boolean comprobarAtributosCirculo(String[] parametros) {

		if (parametros.length != 4) {
			System.err.println("ERROR: (line " + numeroLinea + ") hay un total de " + parametros.length
					+ " atributos, tiene que haber 4 atributos");
			return false;
		}
		for (int i = 1; i < parametros.length - 1; i++) {
			if (!isNumber(parametros[i])) {
				System.err
						.println("ERROR: (line " + numeroLinea + ") el atributo " + parametros[i] + " no es un numero");
				return false;
			}
		}
		if (!mapaStroke.containsKey(parametros[parametros.length - 1])) {
			System.err.println("ERROR: (line " + numeroLinea + ") el stroke " + parametros[parametros.length - 1]
					+ " no se ha definido antes");
			return false;
		}

		return true;

	}

	private static boolean comprobarAtributosStroke(String[] parametros) {
		if (parametros.length != 6) {
			System.err.println("ERROR: (line " + numeroLinea + ") hay un total de " + parametros.length
					+ " atributos, tiene que haber 6 atributos");
			return false;
		}

		for (int i = 2; i < parametros.length; i++) {
			if (!isNumber(parametros[i])) {
				System.err
						.println("ERROR: (line " + numeroLinea + ") el atributo " + parametros[i] + " no es un numero");
				return false;
			}
		}
		return true;
	}

	private static boolean comprobarAtributosContenedor(String[] parametros) {
		if (parametros.length != 3) {
			System.err.println("ERROR: (line " + numeroLinea + ") hay un total de " + parametros.length
					+ " atributos, tiene que haber 3 atributos");
			return false;
		}

		for (int i = 1; i < parametros.length; i++) {
			if (!isNumber(parametros[i])) {
				System.err
						.println("ERROR: (line " + numeroLinea + ") el atributo " + parametros[i] + " no es un numero");
				return false;
			}
		}
		return true;
	}

	private static boolean isNumber(String stringInt) {
		String[] strinInts = stringInt.split(",");
		for (String numero : strinInts) {

			try {
				Integer.parseInt(numero);

			} catch (NumberFormatException e) {

				return false;
			}
		}
		return true;
	}

}
