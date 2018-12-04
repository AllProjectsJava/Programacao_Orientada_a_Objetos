package Demo_Figuras;

import java.awt.Color;

public class App {

	public static void main(String[] args) {
		/*
		Retangulo lstret[] = new Retangulo[3];
		Circulo lstcirc[] = new Circulo[3];
		
		lstret[0] = new Retangulo(Color.BLACK,10,10,20,20);
		lstcirc[0] = new Circulo(Color.BLUE,100,100,200,200);
		lstret[1] = new Retangulo(Color.CYAN,30,30,40,40);
		lstcirc[1] = new Circulo(Color.GREEN,200,200,300,300);
		lstret[2] = new Retangulo(Color.ORANGE,50,50,60,60);
		lstcirc[2] = new Circulo(Color.PINK,400,400,800,800);

		for(int i=0;i<3;i++) {
			lstret[i].desenha();
			lstcirc[i].desenha();
		}
		*/
		
		Figura lstfig[] = new Figura[6];
		lstfig[0] = new Retangulo(Color.BLACK,10,10,20,20);
		lstfig[1] = new Circulo(Color.BLUE,100,100,200,200);
		lstfig[2] = new Retangulo(Color.CYAN,30,30,40,40);
		lstfig[3] = new Circulo(Color.GREEN,200,200,300,300);
		lstfig[4] = new Retangulo(Color.ORANGE,50,50,60,60);
		lstfig[5] = new Circulo(Color.PINK,400,400,800,800);
		
		for(int i=0;i<6;i++) {
			lstfig[i].desenha();
			System.out.println("Area: "+lstfig[i].area());
			if (lstfig[i] instanceof Circulo) {
				Circulo aux = (Circulo)lstfig[i];
			    System.out.println("Perimetro: "+aux.perimetro());
			}
		}
	}
}
