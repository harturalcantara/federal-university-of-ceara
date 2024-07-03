package br.ufc.crateus.eda.st;

public interface ST<K, V> {
	
	/** Add a Key and value. */
	void put(K key, V value);
	
	/** Return the value. */
	V get(K key);
	
	/** */
	boolean contains(K key);
	
	void delete(K key);
	
	boolean isEmpty();
	
	int size();
	
	Iterable<K> keys();
	
}
