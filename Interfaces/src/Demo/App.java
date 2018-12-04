package Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class App {
	public static final int MAX = 5;
/*		
	List<Pessoa> lst = new ArrayList<>();
	List<Pessoa> lst2 = new LinkedList<>();
*/		

	public static void impPessoa(Pessoa p) {
		System.out.println(p.getNome()+", "+
	                       p.getIdade()+", "+
				           p.getAltura()+", "+
	                       p.getPeso()+", imc: "+
				           p.getIMC());
	}
	
	public static void main(String[] args) {
		Pessoa p1 = new Cidadao("Ze",40,170,75);
		Pessoa p2 = new CidadaoV2("Silvia",35,165,55);
	
		//impPessoa(p1);
		//impPessoa(p2);
		
		Pessoa lst[] = new Pessoa[MAX];
        lst[0] = new CidadaoV2("Pedro",22,172,67);
        lst[1] = new CidadaoV2("Maria",12,163,72);
        lst[2] = new CidadaoV2("Silvia",45,184,77);
        lst[3] = new CidadaoV2("Paulo",37,191,99);
        lst[4] = new CidadaoV2("Fabio",18,157,60);
		
        //Arrays.sort(lst);
        //Arrays.sort(lst, new ComparadorDeCidadaoV2());
        
        Arrays.sort(lst, new Comparator(){
        	public int compare(Object arg0, Object arg1) {
        		CidadaoV2 este = (CidadaoV2)arg0;
        		CidadaoV2 aquele = (CidadaoV2)arg1;
        		
        		return este.getIdade() - aquele.getIdade();
        	}
        });
        
        for(int i=0;i<MAX;i++) {
        	impPessoa(lst[i]);
        }
		
		

	}

}
