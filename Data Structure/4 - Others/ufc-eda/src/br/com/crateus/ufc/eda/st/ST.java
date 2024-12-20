package br.com.crateus.ufc.eda.st;

public interface ST<K, V> {
	void put(K key, V value);
	V get(K key);
	void delete(K key);
	boolean contains(K key);
	boolean isEmpty();
	int size();
	int getIndex(K key);
	Iterable<K> keys();
}
