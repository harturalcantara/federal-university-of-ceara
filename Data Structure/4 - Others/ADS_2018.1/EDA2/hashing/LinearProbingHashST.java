package br.ufc.crateus.hashing;

import java.util.Iterator;

import br.ufc.crateus.eda.st.ST;

public class LinearProbingHashST <K,V> implements ST<K,V>{
	
	private K[] keys;
	private V[] values;
	private int M;
	private int N;
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashST(int m) {
		this.keys = (K[]) new Object[m];
		this.values = (V[]) new Object[m];
		this.M = m;
		
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	@Override
	public void put(K key, V value) {
		
		if(key == null) return;
		if(value == null) {
			delete(key);
			return;
		}
		
		if(N >= M/2) resize(2*M);
		
		int i;
		for(i = hash(key); keys[i] != null; i = (i+1) % M) {
			if(keys[i].equals(key) )
				values[i] = value;
		}
		
		keys[i] = key;
		values[i] = value;
		this.N++;
	}

	@Override /** Okay */
	public V get(K key) {

		for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (key.equals(keys[i])) 
				return values[i];
		
		return null;
	}

	@Override
	public boolean contains(K key) {
		
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (key.equals(keys[i])) 
				return true;
		
		return false;
	}

	@Override
	public void delete(K key) {
		
		if(!contains(key))
			return;
		
		int i = hash(key);
		
		while(! key.equals(keys[i]) )
			i = (i +1) % M;
		
		keys[i] = null;
		values[i] = null;
		i = (i + 1) % M;

		while(keys[i] != null) {
			
			K keyAnt = keys[i];
			V valueAnt = values[i];
			keys[i] = null;
			values[i] = null;
			N--;
			
			put(keyAnt, valueAnt);
			i = (i +1) % M;
		}
		
		N--;
		
		if(N > 0 && N == M/8)
			resize(M/2);
			//resize(M/8);
	}
	
	public void resize(int m) {
		
		LinearProbingHashST<K, V>	aux;
		aux = new LinearProbingHashST<>(m);
			
		int oldSize = M;
		
		for(int i = 0; i < oldSize; i++){
			if(keys[i] != null) {
				aux.put(keys[i], values[i]);
			}
		} 
		
	   this.keys = aux.keys;
	   this.values = aux.values;
	   this.M = aux.M;
	   this.N= aux.N;
	
	}
	
	@Override
	public boolean isEmpty() {
		return keys == null;
	}

	@Override
	public int size() {
		return this.N;
	}
	
	public Iterable<K> keys() {
		return new Iterable<K>(){
			int count=0;
			
			@Override
			public Iterator<K> iterator() {
				return new Iterator<K>() {
					
					@Override
					public boolean hasNext() {
						return count < keys.length;
					}

					@Override
					public K next() {
						K aux = keys[count++];
						return aux;
					}
					
				};
			}
		};
	}
	
	public static void main(String[] args) {
		LinearProbingHashST <Integer, String> list = new LinearProbingHashST<>(9);
		
		list.put(5, "a");
		list.put(28, "b");
		list.put(19, "c");
		list.put(15, "d");
		list.put(20, "e");
		list.put(33, "f");
		list.put(12, "g");
		list.put(17, "h");
		list.put(10, "i");
		
		//list.imp(5);
		
		System.out.println("Meu Iterator!!");
		for(Object ob : list.keys()) {
			System.out.println(ob);
		}
	}

}
