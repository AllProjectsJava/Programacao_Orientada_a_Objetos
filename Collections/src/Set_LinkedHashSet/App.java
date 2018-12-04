package Set_LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class App {
	public static void main(String[] args) {
		System.out.println("LinkedHashSet");
		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("D");
		linkedHashSet.add("C");
		linkedHashSet.add("B");
		linkedHashSet.add("A");
		System.out.println(linkedHashSet);
	}
}
