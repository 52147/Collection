package collectionapi;

import java.io.Serializable;


/**
 * 
 *  = Maps = 
 *  
 *  - A Map is used to store a collection of entries that consists of keys and their values.
 *  - The Map maps keys to values.
 *  - Key must be unique, but several keys can map to the same value.
 *  - Thus, values need not be unique.
 *  - There is a SortedMap interface that maintains the map logically in key-sorted order.
 *  
 *  - Not suprisingly, there are 2 implementations:
 *  
 *    - 1. the HashMap and
 *      2. TreeMap.
 *    
 *    - The HashMap does not keep keys in sorted order, whereas the TreeMap does.
 *    - For simplicity, we do not implement the SortedMap interface but we do implement HashMap and TreeMap.
 *   
 *   
 *    - The Map can be implemented as a Set instantiated with a pair,
 *      whose comparator or equals/hashCode implementation refers only to the key.
 *    - The Map interface does not extend Collection;
 *      instead it exists on its own.
 *      - The sample interface that contains the most important method is shown below.
 *    
 *    
 *      - Most of the methods have intuitive semantics:
 *      
 *      put()
 *      - put is used to add a key/value pair,
 *      
 *      remove()
 *      - remove is used to remove a key/value pair (only the key is specified), and
 *      
 *      get()
 *      - get returns the value associated with a key.
 *        - null values are allowed, which complicates issues for get,
 *          because the return value from get will not distinguish between a failed search and a successsful search
 *          that returns null for the value.
 *     
 *      containsKey()     
 *      - containsKey can be used if null values are known to be in the map.
 *      
 *  
 * - The Map interface does not provide an iterator method or class.
 * - Instead it returns a Collection that can be used to view the contents of the map.
 *       
 *      keySet()
 *      - The keySet method gives a Collection that contains all the keys.
 *      - Since duplicate keys are not allowed, the result of ksySet is a Set,
 *        for which we can obtain an iterator.
 *      - If the Map is a SortedMap, the Set is a SortedSet.
 *      
 *      value()
 *      - Similarly, the values method returns a Collection that contains all the values.
 *      - This really is a Collection, since duplicate values are allowed.
 *      
 *      entrySet()
 *      - Finally, the entrySet method returns a collection of key/value pairs.
 *      - Again, this a Set, because the pairs must have different keys.
 *      - The objects in the Set returned by the entrySet are pairs;
 *        there must be a type that represents key/value pairs.
 *      - This is specified by the Entry interface that is nested in the Map interface.
 *      - Thus the type of object that is in the entrySet is Map.Entry.
 *      
 *      
 *      
 *      
 *      
 *                
 *     
 *
 */

/**
 * 
 * Map interface.
 * A map stores key/value pairs.
 * In our implementations, duplicate keys are not allowed.
 *
 */
public interface Map<KeyType, ValueType> extends Serializable{
	
	/**
	 * Returns the number of keys in this map.
	 * @return the number of keys in this collection.
	 */
	int size();
	
	/**
	 * Test if this map is empty.
	 * @return true if the size of this map is zero.
	 */
	boolean isEmpty();
	
	/**
	 * Test if this map contains a given key.
	 * @param key the key to search for.
	 * @return true if the map contains the key.
	 */
	boolean containsKey(KeyType key);
	
	/**
	 * Returns the value in the map associated with the key.
	 * @param key the key to search for.
	 * @return the value that matches the key or null.
	 * if the key is not found.
	 * Since null values are allowed, checking if the return value is null may not be a safe way to
	 * ascertain if the key is present in the map.
	 */
	ValueType get(KeyType key);
	
	/**
	 * Adds the key value pair to the map, overriding the original value if the key was already present.
	 * @param key the key to insert
	 * @param value the value to insert.
	 * @return the old value associated with the key,
	 *         or null if the key was not present prior to this call.
	 */
	 ValueType put(KeyType key, ValueType value);
	 
	 
	 /**
	  * Remove the key and its value from the map.
	  * @param key the key to remove
	  * @return the previous value associated with the key,
	  *         or null if the key was not present prior to this call.
	  */
	 ValueType remove(KeyType key);
	 
	 /**
	  * Removes all key value pairs from the map.
	  */
	 void calear();
	 
	 /**
	  * Returns the keys in the map.
	  * @return the keys in the map.
	  */
	 Set<KeyType> keySet();
	 
	 /**
	  * Return the values in the map. There may be duplicates.
	  * @return the values in the map.
	  */
	 Collection<ValueType> values();
	 
	 /**
	  * Return a set of Map. Entry objects corresponding to the key/value pairs in the map.
	  * @return the key/value pairs in the map.
	  */
	 Set<Entry<KeyType, ValueType>> entrySet();
	 
	 
	
	
	

}
