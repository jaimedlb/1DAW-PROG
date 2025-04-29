package com.gsd.daw.prog.figuras;

public class Color {

	private final int red;
	private final int green;
	private final int blue;

	public Color(Byte red, Byte green, Byte blue) {

		if (red == null || green == null || blue == null)
			throw new IllegalArgumentException();
		this.red = red & 0xFF;
		this.green = green & 0xFF;
		this.blue = blue & 0xFF;

	}

	public String toSvg() {
		StringBuilder sb = new StringBuilder();

		sb.append("stroke=\"(").append(red).append(",").append(green).append(",").append(blue).append(")\"");

		return sb.toString();
	}

}
