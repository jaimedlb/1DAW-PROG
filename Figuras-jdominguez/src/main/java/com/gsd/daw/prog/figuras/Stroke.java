package com.gsd.daw.prog.figuras;

public class Stroke {

	private Color color;
	private Integer width;

	public Stroke(Color color, Integer width) {
		if (color == null || width == null) {
			throw new IllegalArgumentException();
		}

		this.color = color;
		this.width = width;
	}

	public String toSvg() {
		StringBuilder sb = new StringBuilder();
		sb.append(color.toSvg()).append(" stroke-width=\"").append(width).append("\"");

		return sb.toString();
	}
}
