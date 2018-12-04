package Exemplo;
import java.util.Comparator;

public class ComparadorPessoas implements Comparator<Pessoa> {
	@Override
	public int compare(Pessoa este, Pessoa aquele) {
		return este.getIdade() - aquele.getIdade();
	}
}
