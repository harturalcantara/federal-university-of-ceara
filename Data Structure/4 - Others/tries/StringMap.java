package br.ufc.crateus.eda.tries;

public interface StringMap<V> extends Map<String, V> {
	
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
