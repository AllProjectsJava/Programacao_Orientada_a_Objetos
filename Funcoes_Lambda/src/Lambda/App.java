package Lambda;

import java.util.LinkedList;

public class App {
	public static void main(String[] args) {
		LinkedList<Funcionario> f = new LinkedList<>();
		f.add(new Funcionario(1,7));
		f.add(new Funcionario(10,70));
		
		f.stream().mapToInt(a -> a.getIdade())
		.forEach(System.out::println);
		

	}

}
