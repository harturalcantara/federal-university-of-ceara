package br.ufc.crateus.eda.lista2.trab;



public interface StringST<V> extends ST<String, V> {
	
	void put(String key, V value);
	
	V get(String key);
	
	void delete(String key);
	
	boolean contains(String key);
	
	boolean isEmpty();
	
	String longestPrefixOf(String str);
	
	Iterable<String> keysWithPrefix(String str);
	
	Iterable<String> keysThatMatch(String str);
	
	int size();
	
	Iterable<String> keys();
}
