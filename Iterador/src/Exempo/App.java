package Exempo;
import java.util.Iterator;
import java.util.Random;

public class App {
    public static final int MAX = 100;
	public static void main(String[] args) {
		ListaLigada ll = new ListaLigada();
		
		Random r = new Random();
		for(int i=0;i<MAX;i++) {
			ll.add(r.nextInt(500));
		}
		
		for(int i=0;i<MAX;i++) {
			System.out.print(ll.get(i)+", ");
			if (i%10 == 0) System.out.println("");
		}
		System.out.println("");
		
		/*
		Iterator<Integer> it = ll.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		*/
		for(Integer i:ll) {
			System.out.print(i+",");
		}
		
	}

}
