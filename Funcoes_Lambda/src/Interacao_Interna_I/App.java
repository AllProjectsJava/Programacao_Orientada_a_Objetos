package Interacao_Interna_I;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<String> itens = Arrays.asList("item1", "item2", "item3");
		
		// 1
		//for(int i=0; i<itens.size(); i++)
		//	System.out.println(itens.get(i));
		
		// 2
		//for(String s : itens)
		//	System.out.println(s);
		
		// 3
		//itens.forEach(s -> System.out.println(s));
		
		// 4
		itens.forEach(System.out::println);

	}
}
