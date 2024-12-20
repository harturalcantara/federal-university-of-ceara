package br.com.crateus.ufc.eda.st;

import java.util.LinkedList;

public class LinearProbingHashST<K, V> implements ST<K, V> {

	int m;

	private K[] keys;
	private V[] values;

	public LinearProbingHashST() {
		this(97);
	}

	@SuppressWarnings("unchecked")
	public LinearProbingHashST(int m) {
		this.m = m;
		this.keys = (K[]) new Object[m];
		this.values = (V[]) new Object[m];
	}

	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}

	@Override
	public void put(K key, V value) {
		int i = hash(key);
		while (keys[i] != null && !key.equals(keys[i]))
			i = (i + 1) % m;
		keys[i] = key;
		values[i] = value;
	}

	@Override
	public V get(K key) {
		int i = hash(key);
		while (keys[i] != null && !key.equals(keys[i]))
			i = (i + 1) % m;
		return values[i];
	}

	@Override
	public void delete(K key) {
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return keys.length == 0;
	}

	@Override
	public int size() {
		for(int i = 0; i < keys.length; i++) {
			if(keys[i] == null)
				return i;
		}
		return 0;
	}

	@Override
	public Iterable<K> keys() {
		LinkedList<K> ll = new LinkedList<K>();
		for (int i = 0; i < keys.length; i++)
			ll.add(keys[i]);
		return ll;
	}

	@Override
	public int getIndex(K key) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] == key)
				return i;
		}
		return 0;
	}

}
