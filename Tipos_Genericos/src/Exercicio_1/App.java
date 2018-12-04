package Exercicio_1;

public class App {
	public static void main(String[] args) {
		Box<String> box1 = new Box<>();
		
		System.out.println(box1);
		
		box1.guardar("Diamante");
		
		System.out.println(box1);
		
		box1.retirar();
		
		System.out.println(box1);
		
		Box<Integer> box2 = new Box<>();
		
		System.out.println(box2);
		
		box2.guardar(150);
		
		System.out.println(box2);
		
		box2.retirar();
		
		System.out.println(box2);
	}
}
