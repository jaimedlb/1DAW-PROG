package com.gsd.daw.prog.figuras;

public class Contenedor {
	private Integer ancho;
	private Integer alto;

	private Circulo circulo;
	private Elipse elipse;
	private Linea linea;
	private LineaPoligonal lineaPoligonal;
	private Poligono poligono;
	private Rectangulo rectangulo;

	public Contenedor(Integer ancho, Integer alto) {
		if (ancho == null || alto == null)
			throw new IllegalArgumentException();
		this.ancho=ancho;
		this.alto=alto;
	}

	public void addCirculo(Circulo figura) {
		if (figura == null)
			throw new IllegalArgumentException();
		circulo = figura;
	}

	public void addElipse(Elipse figura) {
		if (figura == null)
			throw new IllegalArgumentException();
		elipse = figura;
	}

	public void addLinea(Linea figura) {
		if (figura == null)
			throw new IllegalArgumentException();
		linea = figura;

	}

	public void addLineaPoligonal(LineaPoligonal figura) {
		if (figura == null)
			throw new IllegalArgumentException();
		lineaPoligonal = figura;

	}

	public void addPoligono(Poligono figura) {
		if (figura == null)
			throw new IllegalArgumentException();
		poligono = figura;

	}

	public void addRectangulo(Rectangulo figura) {
		if (figura == null)
			throw new IllegalArgumentException();
		rectangulo = figura;

	}

	public String toSvg() {
		
	
		StringBuilder sb =new StringBuilder();
	sb.append("<svg viewBox\"0 0 ").append(ancho).append(" ").append(alto).append("\" xmlns=\"http://www.w3.org/2000/svg\">\n");
	sb.append("       ").append(elipse.toSvg()).append("\n");
	sb.append("       ").append(circulo.toSvg()).append("\n");
	sb.append("       ").append(linea.toSvg()).append("\n");
	sb.append("       ").append(lineaPoligonal.toSvg()).append("\n");
	sb.append("       ").append(poligono.toSvg()).append("\n");
	sb.append("       ").append(rectangulo.toSvg()).append("\n");
	sb.append("</svg>");
		
		
		return sb.toString();
	}
}
