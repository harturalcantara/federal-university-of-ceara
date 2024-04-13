package br.ufc.crateus.aps.trabalhofinal.Iterator;
public interface ST <K,V>{
	void put(K k,V v);
	boolean contains(K k);
	boolean isEmpty();
	void delete(K k);
	V get(K k);
	int size();
	Iterable<K> keys();
}
	


