package Stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.Arrays;

public class App {
	
	public static void filtro(List<String> lista, Predicate<String> condicao) {
		for(String s : lista) 
			if(condicao.test(s))
				System.out.println(s);
	}
	
	public static void main(String[] args) {
		
		List<String> lista1 = Arrays.asList(
									"Santa Catarina", "Parana",
									"São Paulo", "Rio de Janeiro",
									"Brasilia", "Ceará");
		// 1							
		//for(String s: lista1) {
		//	System.out.println(s);
		//}
		
		// 2
		//lista1.forEach(x -> System.out.println(x));
	    
		// 3
		//lista1.forEach( System.out::println);
		
		// 4
		System.out.println("Estados que iniciam com a letra S");
		filtro(lista1, (s) -> s.startsWith("S"));
		
		
		System.out.println("\nEstados que terminam com a letra a");
		filtro(lista1, (s) -> s.endsWith("a"));
		
		System.out.println("\nTodos");
		filtro(lista1, (s) -> true);
		
		System.out.println("\nNenhum");
		filtro(lista1, (s) -> false);
		
		System.out.println("\nMais que 10 caracteres");
		filtro(lista1, (s) -> s.length() > 10);
	
	}
}
