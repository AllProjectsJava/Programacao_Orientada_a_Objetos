package Exercicio_P9_11;

import java.awt.Rectangle;

public class App {
	public static void main(String args[]) {
		Rectangle b = new BatterRectangle(1,2);
		System.out.println("Perimetro: " + BatterRectangle.perimetro(b));
		System.out.println("Area: " + BatterRectangle.area(b));
	}
}