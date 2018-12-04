package Demo_Figuras;

import java.awt.Color;

public class Retangulo extends Figura {

	public Retangulo(Color c, int x1, int y1, int x2, int y2) {
		super(c, x1, y1, x2, y2);
	}

	public double area() {
		double l1 = Math.abs(getX1()-getX2());
		double l2 = Math.abs(getY1()-getY2());
		return(l1*l2);
	}
	
	public void desenha() {
		System.out.println("Desenho de um quadrado de cor:"+getCor());
	}
}
