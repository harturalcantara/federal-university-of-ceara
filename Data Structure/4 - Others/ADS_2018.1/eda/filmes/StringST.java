package br.ufc.crateus.eda.filmes;

import br.ufc.crateus.eda.st.ST;

public interface StringST<V> extends ST<String, V> {
	
	String longestPrefixOf(String str);
	
	Iterable<String> keysWithPrefix(String str);
}
