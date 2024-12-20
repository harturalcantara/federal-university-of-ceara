package br.com.crateus.ufc.eda.st;

import java.util.LinkedList;

public class SeparateChainingHashingST<K, V> implements ST<K, V> {

	private Node[] table;
	private int m; 
	int n;
	
	private static class Node {
		Object key;
		Object value;
		Node next;
		
		public Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public SeparateChainingHashingST() {
		this(97);
	}
	
	public SeparateChainingHashingST(int m) {
		this.m = m;
		this.n = 0;
		table = new Node[m];
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % m;  
	}

	private Node getNode(K key) {
		int i = hash(key);
		for (Node node = table[i]; node != null; node = node.next) {
			if (key.equals(node.key)) return node;
		}
		return null;
	}

	@Override
	public void put(K key, V value) {
		Node node = getNode(key);
		if (node == null) {
			int i = hash(key);
			table[i] = new Node(key, value, table[i]);
			n++;
		}
		else node.value = value;
		
		if ((double)(n / m) > 8.0) resize(2 * m);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
		Node node = getNode(key);
		return (node != null)? (V) node.value : null;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newM) {
		SeparateChainingHashingST<K, V> hash = new SeparateChainingHashingST<>(newM);
		for (int i = 0; i < m; i++) 
			for (Node node = table[i]; node != null; node = node.next)
				hash.put((K) node.key, (V) node.value);
		this.table = hash.table;
		this.m = newM;
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return n;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<K> keys() {
		LinkedList<K> ll = new LinkedList<K>();
		
		for(int i = 0; i < table.length; i++) {
			if(table[i] != null)
			ll.add((K) table[i].key);
		}
		return ll;
	}

	@Override
	public int getIndex(K key) {
		// TODO Auto-generated method stub
		return 0;
	}

}
