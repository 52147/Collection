package collectionapi;
/**
 * - illustrates another use of the map, in a method that returns items in a list that appear more than once.
 * - In this code, a map is being used internally to group the duplicates together:
 * 
 *   - the key of the map is an item, and the value is the number of times the item has occured.
 *   - If the item has never been placed in the map, we do so with a count of 1.
 *   - Otherwise, we update the count.
 *   
 *   - Note the judicious use of autoboxing and unboxing.
 * 
 * - Then we use an iterator to traverse through the entry set,
 *   obtaining keys that appear with a count of 2 or more in the map.
 *  
 */
public class DuplicateFinder {
	
	   
		public static void listDuplicates(List<String> coll){
			
			Map<String, Integer> count = new TreeMap<String, Integer>();
			List<String> resule = new ArrayList<String>();
			
			for(String word : coll) {
				Integer occurs = count.get(word);
				if(occurs == null)
					count.put(word, 1);
				else
					count.put(word, occurs + 1);
				
			}
			
			for(Map.Entry<String, Integer> e : count.entrySet())
				if(e.getValue() >= 2)
					System.out.println(e.getKey() + "(" + e.getValue() + ")");
			
		}

	public static void main(String[] args) {
		
		String [] arr = {"hello", "world", "hello", "if", "world"};
		List<String> lst = Arrays.asList(arr);
		
		listDuplicates(lst);

	}

}
