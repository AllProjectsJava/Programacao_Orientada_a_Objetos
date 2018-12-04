package Interacao_Interna_II;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class App {

	public static void filtro(List<String> lista, Predicate<String> condicao) {
		//for(String s : lista) 
		//	if(condicao.test(s))
		//		System.out.println(s);
		
		//lista.stream().filter(s -> condicao.test(s)).forEach(s -> System.out.println(s));
		lista.stream().filter(condicao::test).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		List<String> lista1 = Arrays.asList(
											"Santa Catarina", "Parana",
											"São Paulo", "Rio de Janeiro",
											"Brasilia", "Ceará");
							
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
