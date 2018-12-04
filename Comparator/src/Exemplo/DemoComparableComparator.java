package Exemplo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DemoComparableComparator {
	
	public class ComparaPessoaPorNomeEIdade implements Comparator<Pessoa> {
		@Override
		public int compare(Pessoa este, Pessoa aquele) {
			if (este.getNome().equals(aquele.getNome())) {
				return este.getIdade() - aquele.getIdade();
			} else
				return este.getNome().compareTo(aquele.getNome());
		}
	}

	public void exec() {
		List<Pessoa> lst = new ArrayList<>();

		lst.add(new Pessoa("Ze", 34));
		lst.add(new Pessoa("Ana", 42));
		lst.add(new Pessoa("Ana", 12));
		lst.add(new Pessoa("Jorge", 39));
		lst.add(new Pessoa("Luisa", 24));

		//Collections.sort(lst);

		for (Pessoa p : lst) {
			System.out.println(p);
		}

		// ComparadorPessoas cp = new ComparadorPessoas();

		// Collections.sort(lst,new ComparadorPessoas());
		// Collections.sort(lst, new ComparaPessoaPorNomeEIdade());
		Collections.sort(lst, new Comparator<Pessoa>() {
			@Override
			public int compare(Pessoa este, Pessoa aquele) {
				if (este.getNome().equals(aquele.getNome())) {
					return este.getIdade() - aquele.getIdade();
				} else
					return este.getNome().compareTo(aquele.getNome());
			}
		});

		System.out.println("----");
		for (Pessoa p : lst) {
			System.out.println(p);
		}
	}
}
