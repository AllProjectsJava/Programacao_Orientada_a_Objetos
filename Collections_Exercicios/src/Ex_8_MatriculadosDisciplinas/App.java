package Ex_8_MatriculadosDisciplinas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		List<String> d1 = Arrays.asList("Ze","Antonio","Silvia","Joao");
		List<String> d2 = Arrays.asList("Carlos","Ze","Neymar","Silvia");
		List<String> d3 = Arrays.asList("Ze","Amanda","Neymar","Luiza");
		
		Set<String> todos = new TreeSet<>(d1);
		todos.addAll(d2);
		todos.addAll(d3);
		
		Set<String> soNaTurmaUm = new TreeSet<>(d1);
		soNaTurmaUm.removeAll(d2);
		soNaTurmaUm.removeAll(d3);
		
		Set<String> simultaneamenteD1D2 = new TreeSet<>(d1);
		simultaneamenteD1D2.retainAll(d2);
		
		System.out.println(todos);
		System.out.println(soNaTurmaUm);
		System.out.println(simultaneamenteD1D2);
	}

}
