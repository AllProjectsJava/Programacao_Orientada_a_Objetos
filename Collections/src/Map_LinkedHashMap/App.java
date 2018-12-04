package Map_LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {
		Map<String, String> mapLinkedHashMap = new LinkedHashMap<>();
		mapLinkedHashMap.put("Da", "Letra D");
		mapLinkedHashMap.put("Cc", "Letra C");
		mapLinkedHashMap.put("de", "Letra de");
		mapLinkedHashMap.put("A", "Letra A");
		
		System.out.println("LinkedHashMap");
		for (Map.Entry<String, String> entry : mapLinkedHashMap.entrySet())
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());

	}
}
