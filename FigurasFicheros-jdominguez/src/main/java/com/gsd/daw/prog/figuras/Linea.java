package com.gsd.daw.prog.figuras;

public class Linea {
private Punto punto1;
private Punto punto2;
private Stroke stroke;
public Linea(Punto punto1, Punto punto2) {	
	if(punto1==null||punto2==null)
		throw new IllegalAccessError();
	
	this.punto1=punto1;
	this.punto2=punto2;
	this.stroke=new Stroke(new Color((byte) 0, (byte) 0, (byte) 0), 1);
}

public void setStroke(Stroke stroke) {
	if (stroke == null)
		throw new IllegalArgumentException();
	this.stroke=stroke;
}

public String toSvg() {
	StringBuilder sb= new StringBuilder();	
	sb.append("<line x1=\"").append(punto1.getX()).append("\" y1=\"").append(punto1.getY())
	.append("\" x2=\"").append(punto2.getX()).append("\" y2=\"").append(punto2.getY()).append("\" ").append(stroke.toSvg()).append(" fill=\"none\"/>");
	
	return sb.toString();
}
}
