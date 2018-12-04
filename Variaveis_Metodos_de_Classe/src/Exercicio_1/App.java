package Exercicio_1;

public class App {
	public static void main(String[] args) {
		Ponto p1 = new Ponto();
		Ponto p2 = new Ponto(2, 5);
		Ponto p3 = new Ponto(p2);
		Ponto p4 = new Ponto(new Ponto(4,7));

		System.out.println(p1);
	    System.out.println(p2);
	    System.out.println(p3);
	    System.out.println(p4);
	}
}
