package br.ufc.crateus.eda.hash;

public class LinearProbingHashMap <K, V > implements Map <K, V> {

	private K[] keys;
	private V[] values;
	int size;
	
	public LinearProbingHashMap() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashMap(int m) {
		this.keys = (K[]) new Object[m];
		this.values = (V[]) new Object[m];
		this.size = 0;
	}
	
	
	@SuppressWarnings("unused")
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % keys.length;
	}
	
	
	@Override
	public void put(K key, V value) {
		int p = hash(key);
		while(keys[p] != null && !key.equals(keys[p])) p =  (p+1) % keys.length;
		keys[p] = key;
		values[p] = value;
	}

	@Override
	public V get(K key) {
		int p = hash(key);
		while(keys[p] != null && !key.equals(p)) p =  (p+1) % keys.length;
		return values[p];
	}

	@Override
	public void remove(K key) {
		int p = hash(key);
		while(keys[p] != null && !key.equals(p)) p =  (p+1) % keys.length;
		values[p] = null;
	}

	public void resize(int newLength) {
		LinearProbingHashMap<K, V> tmp = new LinearProbingHashMap<K,V>();
		for(int i=0; i<keys.length; i++) {
			if(values[i] == null) continue;
			tmp.put(keys[i], values[i]);
		}
		keys = tmp.keys;
		values = tmp.values;
		size = tmp.size;
	}
	
	
	@Override
	public Iterable<K> keys() {
		return null;
	}

	@Override
	public boolean contains(K key) {
		
		
		return false;
	}

}
