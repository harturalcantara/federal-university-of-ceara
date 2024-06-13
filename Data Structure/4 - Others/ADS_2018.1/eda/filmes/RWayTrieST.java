package br.ufc.crateus.eda.filmes;

import java.util.LinkedList;
import java.util.Queue;

public class RWayTrieST<V> implements StringST<V> {
	
	private static final int R = 256;
	private Node root = new Node();
	
	private static class Node {
		Object value;
		Node[] next = new Node[R];
	}

	@Override /** Okay */
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}
	
	private Node put(Node r, String key, V value, int i) {
		if (r == null) r = new Node();
		if (i == key.length()) {
			r.value = value;
			return r;
		}
		int ch = key.charAt(i);
		r.next[ch] = put(r.next[ch], key, value, i + 1);
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(String key) {
		Node node = get(root, key, 0);
		return (node != null)? (V) node.value : null;
	}
	
	private Node get(Node r, String key, int i) {
		if (r == null) return null;
		if (i == key.length()) {
			return (r.value != null)? r : null;
		}
		int ch = key.charAt(i);
		return get(r.next[ch], key, i + 1);
	}

	@Override
	public boolean contains(String key) {
		return (root == null) ? true : false;
	}

	private Node delete( Node r, String key, int i) {
		
		if(r == null) return null;
		if(i == key.length()) r.value = null;
		else {
			int ch = key.charAt(i);
			r.next[ch] = delete(r.next[ch], key, i+1);
		}
		
		if(r.value != null) return r;
		for(Node p : r.next)  if(p != null) return r;
		return null;
		
	}
	
	@Override
	public void delete(String key) {
		if(key == null) return;
		root = delete(root, key , 0);
	}

	@Override
	public boolean isEmpty() {
		return (root == null) ? true : false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void collect(Node r, String prefix, Queue<String> queue) {
		if (r != null) {
			if (r.value != null) 
				queue.add(prefix);
			for (char ch = 0; ch < R; ch++) 
				collect(r.next[ch], prefix + ch, queue);
		}
	}
	
	@Override
	public Iterable<String> keys() {
		Queue<String> queue = new LinkedList<>();
		collect(root, "", queue);
		return queue;
	}
		
	@Override
	public Iterable<String> keysWithPrefix(String prefix) {
			Node node = get(root, prefix, 0);
			Queue<String> keys = new LinkedList<>();
			collect(node, prefix, keys);
			return keys;
	}
	
	
	void collect(Node r, String pre, String pat, Queue<String> keys) {
		int d = pre.length();
		if(r == null) return;
		if(d == pat.length() && r.value != null)
			keys.add(pre);
		if(d == pat.length()) return;
		char prox = pat.charAt(d);
		for(char c = 0; c < R; c++) 
			if(prox == '.' || prox == c) 
				collect(r.next[c], pre+c, pat, keys);
			
		}
		

	
	public Iterable<String> keysThatMach(String prefix) {
			Queue<String> keys = new LinkedList<>();
			collect(root, "", prefix, keys);
			return keys;
	}
	
	
	@Override
	public String longestPrefixOf(String query) {
		int size = search(root, query, 0, 0);
		return query.substring(0, size);
	}
	
	private int search(Node node, String query, int i, int length) {
		if (node == null) return length;
		if (node.value != null) length = i;
		if (i == query.length()) return length;
		char ch = query.charAt(i);
		return search(node.next[ch], query, i + 1, length);
	}
	
	
	
	/*Questao 12*/
	
	private Node floor( Node r, Node aux, String key, int i) { /*Questao 12 lista 2 EDA-2018.1*/
		
		/*
			if(r == null) return null;
			if(i == key.length()) {
				if(r.value != null)
					return r; //retornando o nó
			}
			
			int ch = key.charAt(i);
			return get(r.next[ch], key, i + 1);*/
		if (r == null) { 
			//return null;
			return aux;
		}
		if(r.value != null) {
			aux.value = r.value;
			//System.out.println("Aux value: "+aux.value);
		} 
			
		
		if (i == key.length()) {
			//System.out.println("OIIIIII" + aux.value);
			return (r.value != null)? aux : null;
		}
		int ch = key.charAt(i);
		return floor(r.next[ch], aux ,key,i + 1);

	}
	
	public V floor(String key) { 
		Node aux = new Node();
		Node assist = floor(root, aux, key, 0);
		return (assist == null) ? null : (V) assist.value;
	}
	
	
	public Node ceiling(Node r, String key, int i) {
		
		if (r == null) {
			return null;
		}
		
		if (i == key.length()) {
			if(r.value != null) return r;
			
			int count = 0;
			for(Node p = r.next[count]; p != null; p = r.next[count]) {
				if(p.value != null) 
					return r;
				count++;
			}
			
			//for(Node p : r.next)  
			
			//System.out.println("ESTOY");
			//int ch = i;
			//return ceiling(r.next[ch], key, i + 1);
		}
		
		//if (i > key.length()) {
			//System.out.println( r.value);
			//if(r.value != null) return r;
			
			//int ch = i;
			
			//if(r.value != null) return r;
			//for(Node p : r.next)  if(p != null) return r;
			
			//return ceiling(r.next[i], key, i + 1);
		//}
		
		int ch = key.charAt(i);
		return ceiling(r.next[ch], key, i + 1);
	}
	
	public V ceiling(String e) {
		Node aux = ceiling(root, e, 0);
		return (aux == null)? null : (V) aux.value;
	}
	
	
	V select(int index) {
		return null;
	}
	
	//	public static void main(String[] args) {
	//	StringST<Integer> st = new RWayTrieST<>();
	//	st.put("shells", 0);
	//	st.put("sea", 0);
	//	st.put("by", 0);
	//	st.put("shore", 0);
	//	st.put("the", 0);
	//	st.put("sells", 0);
	//	System.out.println("a");
	//	for (String str : st.keysWithPrefix(""))
	//		System.out.println(str);
	//   
	//}
}
