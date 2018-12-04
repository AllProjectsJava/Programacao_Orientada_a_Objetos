package Exercicio_4;

import java.util.List;

public class OpStatic {
	public static void operacao(List<Integer> lst, ClassFunctionalInterface<Integer> op) {
		for (int i = 0; i < lst.size() - 1; i++) {
			Integer aux = op.operacao(lst.get(i), lst.get(i + 1));
			lst.set(i, aux);
		}
	}
}
