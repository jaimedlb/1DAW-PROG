package com.gsd.daw.prog.figuras;

public class TrianguloEquilatero {
	private Punto origen;
	private Integer tamanoLado;
	private Stroke stroke;

	public TrianguloEquilatero(Punto origen, Integer tamanoLado) {
		if (origen == null || tamanoLado == null)
			throw new IllegalArgumentException();
		this.origen = origen;
		this.tamanoLado = tamanoLado;
		this.stroke = new Stroke(new Color((byte) 0, (byte) 0, (byte) 0), 1);
	}

	public void setStroke(Stroke stroke) {
		if (stroke == null)
			throw new IllegalArgumentException();
		this.stroke = stroke;
	}

	public String toSvg() {




		return "";

	}
}
