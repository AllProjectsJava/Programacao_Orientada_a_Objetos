package Demo;

import java.awt.Color;

public class App {
	public static void main(String[] args) {
		Caneta<String,String> c1 = new Caneta<>("Bic","Azul");
		Caneta<Integer,Color> c2 = new Caneta<>(10,Color.BLUE);
			
		System.out.println(c1);
		System.out.println(c2);

	}
}
