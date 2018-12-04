package Exercicio_4;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(10, 20, 30, 40, 50);

		OpStatic.operacao(lst, (v1, v2) -> (v1 + v2) / 2);

		System.out.println(lst);

		OpStatic.operacao(lst, (v1, v2) -> v1 * v2);

		System.out.println(lst);

		OpStatic.operacao(lst, (v1, v2) -> {
			int aux = v1 * v2;
			if (aux > 1000)
				return 1000;
			else
				return aux;
		});

		System.out.println(lst);
	}
}
