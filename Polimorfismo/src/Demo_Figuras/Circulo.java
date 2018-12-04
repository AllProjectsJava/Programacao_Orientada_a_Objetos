package Demo_Figuras;

import java.awt.Color;

public class Circulo extends Figura {

	public Circulo(Color c, int x1, int y1, int x2, int y2) {
		super(c, x1, y1, x2, y2);
	}
	
	public double area() {
		double xc = getX1() + Math.abs(getX1()-getX2())/2;
		double raio = Math.abs(xc - getX2());
		return(Math.PI*(raio*raio));
	}
	
	public double perimetro() {
		double xc = getX1() + Math.abs(getX1()-getX2())/2;
		double raio = Math.abs(xc - getX2());
        return(2*Math.PI*raio);
	}

	public void desenha() {
		System.out.println("Desenho de um cirulo de cor:"+getCor());
	}
}
