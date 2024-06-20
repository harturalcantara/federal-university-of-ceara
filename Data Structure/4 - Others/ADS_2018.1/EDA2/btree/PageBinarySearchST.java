package br.ufc.creteus.eda.btree;

import br.ufc.crateus.eda.st.BinarySearchST;
import br.ufc.crateus.eda.st.ST;

public class PageBinarySearchST <K extends Comparable<K>> implements Page<K>{

	private ST<K, Object> st = new BinarySearchST<>();
	private boolean botton;
	private int m;
	
	public PageBinarySearchST(int m, boolean botton) {
		this.botton = botton;
		this.m = m;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(Page<K> p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExternal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean holds(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<K> next(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasOverflowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<K> split() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	









}