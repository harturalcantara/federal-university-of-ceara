package br.ufc.creteus.eda.btree;

public interface Page <K extends Comparable<K>>{
	
	void close();
	
	void insert(K key);
	
	void enter(Page<K> p);
	
	boolean isExternal();
	
	boolean holds(K key);
	
	Page<K> next(K key);
	
	boolean hasOverflowed();
	
	Page<K> split();
	
	Iterable<K> keys();
	
}
