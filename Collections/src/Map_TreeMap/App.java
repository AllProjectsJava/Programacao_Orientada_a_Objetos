package Map_TreeMap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;


public class App {
	public static void main(String[] args) {
		/*
		NavigableMap<String, String> mapTreeMap = new TreeMap<>();
		mapTreeMap.put("Da", "Letra D");
		mapTreeMap.put("Cc", "Letra C");
		mapTreeMap.put("de", "Letra de");
		mapTreeMap.put("A", "Letra A");
		
		System.out.println("mapTreeMap");
		for(Map.Entry<String, String> entry : mapTreeMap.entrySet())
			System.out.println("key: " + entry.getKey() + " Value: " + entry.getValue());
		*/
		Pessoa p1 = new Pessoa("Doria", 18);
		Pessoa p2 = new Pessoa("Carlos", 17);
		Pessoa p3 = new Pessoa("Bia", 20);
		Pessoa p4 = new Pessoa("Ana", 16);
		NavigableMap<Pessoa, String> navigableMapTreeMap = new TreeMap<>();
		navigableMapTreeMap.put(p4, "Fila");
		navigableMapTreeMap.put(p3, "Fila");
		navigableMapTreeMap.put(p2, "Fila");
		navigableMapTreeMap.put(p1, "Fila");

		System.out.println("mapTreeMap");
		for(Map.Entry<Pessoa, String> entry : navigableMapTreeMap.entrySet())
			System.out.println("key: " + entry.getKey() + " Value:" + entry.getValue());
	}
}
