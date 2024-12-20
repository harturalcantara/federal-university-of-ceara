package br.ufc.crateus.eda.lista1.trab;

public interface OrderedMap<K extends Comparable<K>, V> extends Map<K, V> {
	K min();
	
	K max();
	
	K ceiling(K val);
	
	K floor(K val);
	
	int rank(K val);
	
	int size(K lo, K hi);
}