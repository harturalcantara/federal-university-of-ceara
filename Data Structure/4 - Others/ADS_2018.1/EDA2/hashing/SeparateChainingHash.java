package br.ufc.crateus.hashing;

import java.util.Iterator;

import br.ufc.crateus.eda.st.ST;

public class SeparateChainingHash <K, V > implements ST<K, V> {
	
	private static class  Node{
		Object key;
		Object value;
		Node next;
		
		public Node(Object key , Object value, Node next){
			this.key = key;
			this.value = value;
			this.next = next;
			
		}
		
	}
	
	private int M = 10;
	private Node[] array;
	private int count;
	

	public SeparateChainingHash(int m) {
		this.array = new Node[m];
		this.count = 0;
	}
	
	private int hash(K key) {
		return ( key.hashCode() &  0x7fffffff % M );
	}
	
	@Override
	public void put(K key, V value) {
		
		if(value == null) delete(key);
		if(key == null) return;
		
		int k = hash(key);
		
		for (Node aux= array[k]; aux != null; aux = aux.next) {
				if(key.equals(aux.key)) {
					aux.value = value;
					return;
				}
		}
		
		 array[k] =  new Node(key , value , array[k] );
		 this.count++;
		 //if(count/array.length >= 8.0) resize(array.length*2); //OBS
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
				
		if(key == null) return null;
		
		int k = hash(key);
		
		for (Node aux= array[k]; aux != null; aux = aux.next) {
			if(key.equals(aux.key)) {
				return (V) aux.value;
			}
		}
		
		return null;
	}

	@Override /** Okay */
	public boolean contains(K key) {
		
		if(key == null) return false;
		
		int k = hash(key);
		for (Node aux= array[k]; aux != null; aux = aux.next) {
			if( key.equals(aux.key) ) {
				return true;
			}
		}
		
		return false;
	}
	
	private Node delete(Node r, K key) {
		
		if(r == null) return null;
		
		if(key.equals(r.key)) {
			r = r.next;
			count--;
			//if(count/array.length <= 2.0) resize(array.length/2); //OBS
		}
		else 
			r.next = delete(r.next,key);		
		
		return r;
	}
	
	/*public void  deleteKey(K k) {
		int i = hash(k);
		Node h = new Node(null,null,array[i]);
		for(Node x = h; x.next != null; x = x.next) {
			if(k.equals(x.key)) {
				x.next = x.next.next;
				count--;
				break;
			}
		}
		array[i] = h.next;
	}*/

	@Override
	public void delete(K key) {
		if(key == null) return;	
		int k = hash(key);
		array[k] = delete(array[k], key);
	}

	@Override
	public boolean isEmpty() {
		return array == null;
	}

	@Override
	public int size() {
		return count;
	}
	
	public void imp(K key) {

		int i = 0;
		int k = hash(key);
		
		Node aux = array[k];
		while(i < 19) {
			if( aux != null ) {
				System.out.println(aux.key);
			}
			else
				System.out.println("Vazio!");
			
			aux = array[i+1];
			
			i++;
		}
	}
	/*
    private void resize(int chains) {
        
    	SeparateChainingHash<K, V> temp = new SeparateChainingHash<K,V>(chains);
        
    	
    	for (int i = 0; i < M; i++) {
            if(array[i] != null) {
            	
            	Node aux = array[i];
            	
            	while(aux != null) {
            		temp.put((K) aux.key, (V) aux.value);
            		aux = aux.next;
            	}
            }
    		
        }
        
    	this.array = temp.array;
    }*/

	public Iterable<K> keys() {
		return new Iterable<K>(){
			
			@Override
			public Iterator<K> iterator() {
				return new Iterator<K>() {
					Node aux;
					int count = 0;
					
					@Override
					public boolean hasNext() {
						return count < array.length;
					}

					@Override
					public K next() {
						
						if(aux != null) {
							do {
								@SuppressWarnings("unchecked")
								K key = (K) aux.key;
								aux = aux.next;
								return key;
								
							} while (aux != null);
							
						}else {
							aux = array[count++];
						}
						return null;
					}
				};
			}
			
		}; 

	}
	
	public Node[] getArray(){
		return this.array;
	}
	
//	public int maiorList( Node[] array) {
//		int []vetor = new int[100];
//		
//		int count = 0;
//		for ( Node aux= array[count]; aux != null && count < 100; aux = array[count+1] ) {
//			int i =1;
//			while(aux.next != null) {
//				vetor[count] = i;
//				i++;
//				System.out.println("Estou aqui!");
//				aux = aux.next;
//			}
//		}
//		
//		//pesquise o maior no vetor[
//		int x=0;
//		for(int i = 0; i < 100; i++) {
//			//System.out.println(vetor[i]);
//			if(x< vetor[i]) 
//				x = vetor[i];
//		}
//		
//		System.out.println("QUEM é x = " + x);
//		return x;
//	}
	
	public static void main(String[] args) {
		
		SeparateChainingHash list = new SeparateChainingHash<>(10);
		
		list.put(1,0);
		list.put(1,2);
		list.put(2,0);
		list.put(3,0);
		list.put(4,0);
		list.put(5,0);
		list.put(5,4);
		list.put(6,0);
		list.put(7,0);
		list.put(8,0);
		
		
		list.delete(5);
		
		for(Object aux : list.keys() )
			System.out.println(aux);
				
		
		
	}
	
	
	
}
