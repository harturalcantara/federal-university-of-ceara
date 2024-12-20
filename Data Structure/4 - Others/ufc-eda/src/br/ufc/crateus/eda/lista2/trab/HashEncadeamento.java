package br.ufc.crateus.eda.lista2.trab;



public class HashEncadeamento<K, V> implements ST<K, V>{

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

	private Node[] vector;
	private int size;

	public HashEncadeamento(int m) {
		this.vector = new Node[m];
		this.size = 0;
	}

	public HashEncadeamento() {
		this(25);
	}

	private int hash(Object key) {
		return (key.hashCode() & 0x7fffffff) % vector.length;
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
			return;
		}
		Node aux = index;
		while(aux.next != null){
			if(aux.next.key.equals(key)){
				aux.next = aux.next.next;
				size--;
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
				if(min > min || (min == 0) && cont!= 0)
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
		return null;
	}

}