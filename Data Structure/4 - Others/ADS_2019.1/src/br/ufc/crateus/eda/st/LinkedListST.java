package br.ufc.crateus.eda.st;

import java.util.Iterator;

public class LinkedListST<K,V> implements ST<K,V> {
	
	private class Node {
		K key;
		V value;
		Node next;
		
		Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	private Node list;
	private int count = 0;
	
	
	@Override /* OK */
	public void put(K key, V value) {
		if (value == null) {
			delete(key);
			return;
		}
		
		Node node = getNode(key);
		if (node == null) {
			list = new Node(key, value, list);
			count++;
		}
		else {
			node.value = value;
		}
	}
	
	
	private Node getNode(K key) { /* Okay */
		for (Node p = list; p != null; p = p.next) {
			if (p.key.equals(key)) return p;
		}
		return null;
	}
	
	@Override /* Okay */
	public V get(K key) {
		Node node = getNode(key);
		return (node != null)? node.value : null;
	}
	
	
	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public void delete(K key) {
		
		Node h = new Node(null, null, list);
		
		for (Node p = h; p.next != null; p = p.next) {
			if (p.next.key.equals(key)) {
				p.next = p.next.next;
				count--;
				break;
			}
		}
		list = h.next;
	}
	
	
	@Override
	public boolean isEmpty() {
		return list == null;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Iterable<K> keys() {
		return () -> new Iterator<K>() {

			Node current = list;
			@Override
			public boolean hasNext() {
				return current.next != null;
			}

			@Override
			public K next() {

				current = current.next;
				return current.key;
			}
		};
	}
	
}
