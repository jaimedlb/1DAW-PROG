package com.gsd.daw.prog.figuras;

public class Color {

	private Byte red;
	private Byte green;
	private Byte blue;

	public Color(Byte red, Byte green, Byte blue) {

		if (red == null || green == null || blue == null)
			throw new IllegalArgumentException();
		this.red = red;
		this.green = green;
		this.blue = blue;

	}

	public String toSvg() {
		StringBuilder sb = new StringBuilder();

		sb.append("stroke=\"(").append(red).append(",").append(green).append(",").append(blue).append(")\"");

		return sb.toString();
	}

}
