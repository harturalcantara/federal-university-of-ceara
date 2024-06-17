package br.ufc.creteus.eda.btree;

public class BTree <K extends Comparable<K>>{
	
	private Page<K> root;
	int m;
	
	public BTree(int m, K sentinel) {
		this.m = m;
		root = new PageBinarySearchST<>(m, true);
		root.insert(sentinel);
	}
}
