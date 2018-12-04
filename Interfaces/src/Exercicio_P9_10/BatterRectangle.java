package Exercicio_P9_10;

import java.awt.Rectangle;

public class BatterRectangle extends Rectangle {
	
	public BatterRectangle(int x, int y) {
		setLocation(0, 0);
		setSize(x, y);
	}
	
	public static double perimetro(Rectangle rectangle) {
		return (rectangle.getWidth()*2) + (rectangle.getHeight()*2);
	}
	
	public static double area(Rectangle rectangle) {
		return rectangle.getHeight() * rectangle.getWidth();
	}
}
