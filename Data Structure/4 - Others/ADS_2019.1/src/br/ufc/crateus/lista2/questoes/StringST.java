package br.ufc.crateus.lista2.questoes;

import br.ufc.crateus.eda.st.ST;

public interface StringST<V> extends ST<String, V> {
	
	void put(String key, V value);
	
	V get(String key);
	
	void delete(String key);
	
	boolean contains(String key);
	
	boolean isEmpty();
	
	String longestPrefixOf(String str);
	
	Iterable<String> keysWithPrefix(String str);
	
	Iterable<String> keysThatMatch(String str); // utiliza caractere coringa (.)
	
	int size();
	
	Iterable<String> keys();
}
