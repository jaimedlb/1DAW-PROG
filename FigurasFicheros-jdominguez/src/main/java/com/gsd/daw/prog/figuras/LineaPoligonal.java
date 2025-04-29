package com.gsd.daw.prog.figuras;

public class LineaPoligonal {
	private Punto[] puntos;
	private Stroke stroke;

	public LineaPoligonal(Punto[] puntos) {
		if (puntos == null || puntos.length == 0)
			throw new IllegalArgumentException();
		this.puntos = puntos;
		this.stroke = new Stroke(new Color((byte) 0, (byte) 0, (byte) 0), 1);
	}

	public void setStroke(Stroke stroke) {
		if (stroke == null)
			throw new IllegalArgumentException();
		this.stroke = stroke;
	}

	public String toSvg() {

		StringBuilder sb = new StringBuilder();

		sb.append("<polyline points=\"");
		for (Punto punto : puntos) {
			sb.append(punto.getX()).append(",").append(punto.getY()).append(" ");
		}
		if (sb.charAt(sb.length() - 1) == ' ') {
			sb.setLength(sb.length() - 1);
		}
		sb.append("\" ").append(stroke.toSvg()).append(" fill=\"none\"/>");

		return sb.toString();

	}
}
