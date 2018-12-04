package Demo;

import java.util.Comparator;

public class ComparadorDeCidadaoV2 implements Comparator {
	@Override
	public int compare(Object arg0, Object arg1) {
		CidadaoV2 este = (CidadaoV2)arg0;
		CidadaoV2 aquele = (CidadaoV2)arg1;
		
		return este.getIdade() - aquele.getIdade();
	}
}
