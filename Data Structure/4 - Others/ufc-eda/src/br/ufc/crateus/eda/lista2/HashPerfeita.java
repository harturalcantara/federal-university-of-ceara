package br.ufc.crateus.eda.lista2;

import java.util.Scanner;

// a = 3, M = 20 -> HASH PERFEITA
// a = 7, M = 20 -> HASH PERFEITA
// a = 9, M = 20 -> HASH PERFEITA
// a = 11,13,17,19,21,23,27, M = 20 -> HASH PERFEITA
public class HashPerfeita <K, V> implements ST<K, V> {

	public static void main(String[] args) {
		int a=1, M=10;
		Scanner scan = new Scanner(System.in);
		while (true) {
			HashPerfeita<Character, Character> table = new HashPerfeita<>(a,M);
			System.out.println(a);
			table.put("S", "S");
			table.put("E", "E");
			table.put("A", "A");
			table.put("R", "R");
			table.put("C", "C");
			table.put("H", "H");
			table.put("X", "X");
			table.put("M", "M");
			table.put("P", "P");
			table.put("L", "L");
			if(table.colisao == 0){
				System.out.println("A="+a+" M="+M);
				//String s = scan.nextLine();
				break;
			}
			if(a == (Integer.MAX_VALUE-1) / 256){
				a = 1;
				M++;
			}
			a++;
		}
	}

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
	private int a = 1, M = 10, colisao = 0;

	public HashPerfeita(int m,int a, int M) {
		this.vector = new Node[m];
		this.size = 0;
		this.a = a;
		this.M = M;
	}

	public HashPerfeita(int a, int M) {
		this(M,a,M);
	}

	private int hash(Object key) {
		return (key.hashCode() * a) % M;
	}

	/*
	 * private void resize() { float factor = size() / vector.length; if (factor
	 * >= 8) { int newSize = vector.length * 2; HashPerfeita newHash = new
	 * HashPerfeita<K, V>(newSize); for (Node obj : vector) if (obj != null)
	 * newHash.put(obj); this.vector = newHash.vector; } else if (factor <= 2) {
	 * int newSize = vector.length / 2; HashPerfeita newHash = new
	 * HashPerfeita<K, V>(newSize); for (Node obj : vector) if (obj != null)
	 * newHash.put(obj); this.vector = newHash.vector; } }
	 */
	private void put(Node n) {
		Node index = vector[hash(n.key)];
		if (index == null)
			vector[hash(n.key)] = n;
		else {
			colisao++;
		}
		size++;
		// resize();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void put(Object key, Object value) {
		Node node = new Node(key, value);
		if (value != null)
			put(node);
		else
			delete((K) key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		Node index = vector[hash(key)];
		Node aux = index;
		while (aux != null) {
			if (aux.key.equals(key)) {
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
		if (index == null)
			return;
		if (index.key.equals(key)) {
			Node aux = index.next;
			vector[hash(key)] = aux;
			size--;
			// resize();
			return;
		}
		Node aux = index;
		while (aux.next != null) {
			if (aux.next.key.equals(key)) {
				aux.next = aux.next.next;
				size--;
				// resize();
				return;
			}
			aux = aux.next;
		}
	}

	public int maxSizeList() {
		int max = 0, cont = 0;
		for (Node i : vector) {
			cont = 0;
			if (i != null) {
				Node aux = i;
				while (aux != null) {
					cont++;
					aux = aux.next;
				}
				if (cont > max)
					max = cont;
			}
		}
		return max;
	}

	public int minSizeList() {
		int min = 0, cont = 0;
		for (Node i : vector) {
			cont = 0;
			if (i != null) {
				Node aux = i;
				while (aux != null) {
					cont++;
					aux = aux.next;
				}
				if (min > cont)
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
