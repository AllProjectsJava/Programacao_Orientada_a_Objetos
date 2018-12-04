package Map_HashMap;

import java.util.HashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {
		Map<String, String> mapHashMap = new HashMap<>();
		mapHashMap.put("Da", "Letra D");
		mapHashMap.put("Cc", "Letra C");
		mapHashMap.put("de", "Letra de");
		mapHashMap.put("A", "Letra A");

		System.out.println("HashMap");
		for (Map.Entry<String, String> entry : mapHashMap.entrySet())
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		
		
	
	}
}
