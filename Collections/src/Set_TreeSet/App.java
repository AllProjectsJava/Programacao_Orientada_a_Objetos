package Set_TreeSet;

import java.util.Set;
import java.util.TreeSet;

import Map_TreeMap.Pessoa;

public class App {
	public static void main(String[] args) {
		
		System.out.println("TreeSet");
		Set<String> treeSet = new TreeSet<String>();
		treeSet.add("D");
		treeSet.add("C");
		treeSet.add("B");
		treeSet.add("A");
		System.out.println(treeSet);
		
		System.out.println("");
		
		System.out.println("TreeSet");
		Pessoa p1 = new Pessoa("Doria", 18);
		Pessoa p2 = new Pessoa("Carlos", 17);
		Pessoa p3 = new Pessoa("Bia", 20);
		Pessoa p4 = new Pessoa("Ana", 16); 
		Set<Pessoa> treeSet2 = new TreeSet<>();
		treeSet2.add(p4);
		treeSet2.add(p3);
		treeSet2.add(p2);
		treeSet2.add(p1);
		System.out.println(treeSet2);
		
	}
}
