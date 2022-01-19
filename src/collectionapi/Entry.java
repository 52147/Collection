package collectionapi;

import java.io.Serializable;

/**
 * The interface used to access the key/value pairs in a map.
 * From a map, use entrySet().iterator to obtain a iterator over a Set of pairs.
 * The next() method of this iterator yields objects of type Map.Entry.
 */

public interface Entry<KeyType, ValueType> extends Serializable {
	
	/**
	 * Obtains the pair's key.
	 * @return the key associated with this pair.
	 */
	KeyType getKey();
	
	/**
	 * Obtains this pair's value.
	 * @return the value associated with this pair.
	 */
	ValueType getValue();
	
	/**
	 * Change this pair's value.
	 * @return the old value associated with this pair.
	 */
	ValueType setValue(ValueType newValue);
	
	
	

}
