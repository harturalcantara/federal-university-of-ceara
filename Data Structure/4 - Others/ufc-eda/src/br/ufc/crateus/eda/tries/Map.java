package br.ufc.crateus.eda.tries;

public interface Map <K, V> {
	
	void put(K key, V value);
	
	V get(K key);
	
	boolean contains(K key);
	
	void delete(K key);
	
	boolean isEmpty();
	
	int size();
	
	Iterable<K> keys();
	
}
