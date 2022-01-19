package collectionapi;

import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Collection;

/**
 * 
 * - This program illustrates the use of the Map with a TreeMap,
 * 
 * - An empty map is created and then populated with a series of put calls.
 * - The last call to put simply replaces a value with "unlisted".
 * - print the result of a call to get, which is used to obtain the value for the key "Joe Doe".
 * 
 * printMap()
 * - More interesting is the printMap routine.
 * - In printMap, we obtain a Set containing Map.Entry pairs.
 * - From the Set, we can use an enhanced for loop to view the Map.Entrys,
 *   and we can obtain the key and value information using getKey and geyValue.
 *   
 * - Returning to main, we see that KeySey returns a set of keys that can be printed by calling printCollection;
 *   similarly, values returns a collection of values that can be printed.   
 * - More interesting, the key set and value collection are views of the map,
 *   so changes to the map are immediately reflected in the key set and value collection,
 *   and removals from the key set or value set become removals from the underlying map.
 * - Thus removes not only the key from the key set but also the associated entry from the map.
 * - Similarly, removes an entry from the map.
 * - Thus the printing reflects a map with 2 entries removed.
 * 
 * 
 * 
 *
 */

// An illustration using the Map interface
public class MapDemo {
	
	public static <AnyType> void printCollection(Collection<AnyType> c) {
		for(AnyType val: c)
			System.out.println(val + "");
		System.out.println();
	}
	
	public static<KeyType, ValueType> void printMap(String msg, Map<KeyType, ValueType> m) {
		
		System.out.println(msg + ":");
		Set<Map.Entry<KeyType, ValueType>> entries = m.entrySet();
		
		for(Map.Entry<KeyType, ValueType> thisPair : entries) {
			System.out.println(thisPair.getKey() + ": ");
			System.out.println(thisPair.getValue());
		}
		
	}
	
	public static void demo(Map<String, String> phone1) {
		
		phone1.put("John Doe", "212-555-1212");
		phone1.put("Jane Doe", "312-555-1212");
		phone1.put("Holly Doe", "213-555-1212");
		phone1.put("Susan Doe", "617-555-1212");
		phone1.put("Jane Doe", "unlisted");
		
		System.out.println("phone1.get(\"Jane Doe\")" + phone1.get("Jane Doe"));
		System.out.println();
		
		System.out.println("The " + phone1.getClass().getName() + ": ");
		printMap("phone1", phone1);
		
		System.out.println("\nThe keys are: ");
		Set<String> keys = phone1.keySet();
		printCollection(keys);
		
		System.out.println("\nThe values are: ");
		Collection<String> values = phone1.values();
		printCollection(values);
		
		keys.remove("John Doe");
		values.remove("unlisted");
		System.out.println("After John Doe and 1 unlisted are removes, the map is");
		printMap("phone", phone1);
		
		System.out.println(phone1);
		
 		
	}
	
	// Do some inserts and printing(done in printMap).
	public static void main(String[] args) {
		
		Map<String, String> phone1 = new TreeMap<String, String>();
		phone1.put("John Doe", "212-555-1212");
		phone1.put("Jane Doe", "312-555-1212");
		phone1.put("Holly Doe", "213-555-1212");
		phone1.put("Susan Doe", "617-555-1212");
		phone1.put("Jane Doe", "unlisted");
		
		System.out.println("phone1.get(\"Jane Doe\")" + phone1.get("Jane Doe"));
		System.out.println();
		
		System.out.println("The " + phone1.getClass().getName() + ": ");
		printMap("phone1", phone1);
		
		System.out.println("\nThe keys are: ");
		Set<String> keys = phone1.keySet();
		printCollection(keys);
		
		System.out.println("\nThe values are: ");
		Collection<String> values = phone1.values();
		printCollection(values);
		
		keys.remove("John Doe");
		values.remove("unlisted");
		System.out.println("After John Doe and 1 unlisted are removes, the map is");
		printMap("phone", phone1);
		
		System.out.println(phone1);
		//demo(new TreeMap<String, String> (Collections.reverseOrder()));
		//demo(new HashMap<String, String>());
		

	}
	
	
	
	
	

}
