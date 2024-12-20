package eda.lista2;

import java.util.LinkedList;

import br.ufc.crateus.eda.st.ST;

public class SeparateChainingHashST<K, V> implements ST<K, V> {

	private Node[] vector;
	private int size;
	
	private static class Node {
		private Object key;
		private Object value;
		private Node next;

		public Node(Object key, Object value) {
			super();
			this.key = key;
			this.value = value;
			this.next = null;
		}
		
	}

	public SeparateChainingHashST(int m) {
		this.vector = new Node[m];
		this.size = 0;
	}

	public SeparateChainingHashST() {
		this(10);
	}

	private int hash(Object key) {
		return (key.hashCode() & 0x7fffffff) % vector.length;
	}

	private void resize(int newSize){
		SeparateChainingHashST<K, V> hashAux = new SeparateChainingHashST<K, V>(newSize);
        for (int i = 0; i < vector.length; i++) {
            if(vector[i] != null){
            	Node aux = vector[i];
            	while(aux != null){
            		hashAux.put(aux.key, aux.value);
            		aux = aux.next;
            	}
            }
        }
        this.vector = hashAux.vector;
	}
	
	private void put(Node n) {
		Node index = vector[hash(n.key)];
		if (index == null)
			vector[hash(n.key)] = n;
		else {
			Node aux = index;
			while(aux.next != null){
				if(aux.key.equals(n.key)){
					aux.value = n.value;
					return;
				}
				aux = aux.next;
			}
			aux.next = n;
		}
		size++;
		if (size() / vector.length >= 8.0) resize(vector.length*2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void put(Object key, Object value) {
		Node node = new Node(key,value);
		if(value != null)
			put(node);
		else delete((K) key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		Node index = vector[hash(key)];
		Node aux = index;
		while(aux != null){
			if(aux.key.equals(key)){
				return (V) aux.value;
			}
			aux = aux.next;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		return (get(key) != null);
	}

	@Override
	public void delete(K key) {
		Node index = vector[hash(key)];
		if(index == null)
			return;
		if(index.key.equals(key)){
			Node aux = index.next;
			vector[hash(key)] = aux;
			size--;
			if (size() / vector.length <= 2.0) resize(vector.length/2);
			return;
		}
		Node aux = index;
		while(aux.next != null){
			if(aux.next.key.equals(key)){
				aux.next = aux.next.next;
				size--;
				if (size() / vector.length <= 2.0) resize(vector.length/2);
				return;
			}
			aux = aux.next;
		}
	}

	public int maxSizeList(){
		int max = 0, cont=0;
		for(Node i : vector){
			cont = 0;
			if(i != null){
				Node aux = i;
				while(aux != null){
					cont++;
					aux = aux.next;
				}
				if(cont > max)
					max = cont;
			}
		}
		return max;
	}
	
	public int minSizeList(){
		int min = 0, cont=0;
		for(Node i : vector){
			cont = 0;
			if(i != null){
				Node aux = i;
				while(aux != null){
					cont++;
					aux = aux.next;
				}
				if(min > cont)
					min = cont;
			}
		}
		return min;
	}
	
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Iterable<K> keys() {
		LinkedList<K> lista = new LinkedList<K>();
        for (int i = 0; i < vector.length; i++) {
        	Node aux = vector[i];
        	while(aux != null){
        		lista.add((K) aux.key);
        		aux = aux.next;
        	}
        }
        return lista;
	}
	
	public static void main(String[] args) {
		SeparateChainingHashST<String, Integer> hash = new SeparateChainingHashST<>(1);
		hash.put("Mardonio", 20);
		hash.put("Deijane",22);
		hash.put("Artur",19);
		hash.put("Maria",18);
		hash.put("Diones", 24);
		hash.put("Karine", 24);
		hash.put("Cipriano", 24);
		hash.put("Marlen", 24);
		
		for(String s : hash.keys())
			System.out.println(s);		
		System.out.println();
		
		hash.delete("Cipriano");
		hash.delete("Diones");
		hash.delete("Artur");
		hash.delete("Maria");
		
		for(String s : hash.keys())
			System.out.println(s);		
		System.out.println();
		
	}

}
