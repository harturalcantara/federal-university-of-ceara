package br.ufc.crateus.eda.hash;

public class SeparateChainingHashMap<K, V > implements Map<K, V> {
	
	private static class Node{
		Object key;
		Object value;
		Node next;
		
		public Node(Object key , Object value, Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	private Node[] table;
	private int size;
	
	public SeparateChainingHashMap() {
		this(97);
	}
	
	public SeparateChainingHashMap(int len) {
		this.table = new Node[len];
		this.size=0;
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % table.length;
	}
	
	private Node getNode(K key) {
		if(key == null) return null;
		int i = hash(key);
		for(Node n = table[i]; n != null; n = n.next)
			if(n.key.equals(key)) return n;
		return null;
	}
	
	@Override
	public void put(K key, V value) {
		Node n = getNode(key);
		if(n == null) {
			int i = hash(key);
			table[i] = new Node(key,value,table[i]);
			this.size++;
			
			if(this.size / table.length == 8) resize(table.length * 2);
		} 
		else {
			n.value = value;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
		Node n = getNode(key);
		return (n != null)? (V) n.value : null;
	}

	@Override
	public void remove(K key) {
		
		int i = hash(key);
		Node tmp = new Node(null,null,table[i]);
		
		for (Node n = tmp; n.next != null; n = n.next) {
			if(key.equals(n.next.key)) {
				n.next  = n.next.next;
				this.size--;
				
				if(this.size / table.length == 2) 
					resize(table.length / 2);
				
				break;
			}
		}
		table[i] = tmp.next;
	}
	
	@SuppressWarnings("unchecked")
	public void resize(int newLength) {
		
		SeparateChainingHashMap <K,V> tmp = new SeparateChainingHashMap <K,V>(newLength);
		
		for (int i = 0; i < table.length; i++)
			for (Node n = table[i]; n!=null; n = n.next)
				tmp.put((K) n.key, (V) n.value); 
		
		table = tmp.table;
		
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		return (get(key) != null)? true : false;
	}
	
	
	
	
}
