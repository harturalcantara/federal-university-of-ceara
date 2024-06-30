package br.ufc.crateus.eda.st;

import java.util.Iterator;

public class BinarySearchTreeST<K extends Comparable <K>,  V> implements OrderedST<K, V> {
	
	protected class Node{
		K key;
		V value;
		int count;
		Node left;
		Node right;
		
		Node(K key, V valor){
			this.key = key;
			this.value = valor;
			this.count = 1;
		}
	}
	
	protected Node root;
	
	@Override /** Okay */
	public void put(K key, V value) {
		if (value != null) root = put(root, key, value);
		else this.delete(key);
	}	
	
	private Node put(Node r, K key, V value) { /** Okay */
		if (r == null) return new Node(key, value); 
		
		int cmp = key.compareTo(r.key);
		if (cmp < 0) r.left = put(r.left, key, value);
		else if (cmp > 0) r.right = put(r.right, key, value);
		else r.value = value;
		
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}
	
	@Override /** Okay */
	public V get(K key) {
		Node node = getNode(root, key);
		return (node != null)? node.value : null;
	}
	
	private Node getNode(Node r, K key) { /** Okay */
		if (r == null) return null;
		
		int cmp = key.compareTo(r.key);
		if (cmp < 0) return getNode(r.left, key);
		if (cmp > 0) return getNode(r.right, key);
		return r;
	}

	@Override /** Okay */
	public boolean contains(K key) {
		return get(key) != null;
	}
	
	@Override  /** Okay */
	public void delete(K key) {
		if(key == null) return;
		root = deleteNode(root, key);
	}
	
	private Node deleteNode(Node r, K  key) { /** Support delete()*/
		if (r == null) return null;
		
		int cmp = key.compareTo(r.key); 
		if (cmp < 0) r.left = deleteNode(r.left, key);
		else if (cmp > 0) r.right = deleteNode(r.right, key);
		else {
			if (r.left == null) return r.right;
			if (r.right == null) return r.left;
			Node t = r;
			r = maxNode(r.left);
			r.right = t.right;
			r.left = deleteMax(t.left);
		}
		
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}
	
	@Override /** Okay */
	public boolean isEmpty() {
		return root == null;
	}
	
	public int size(Node r) { /** Support size() */
		if (r == null) return 0;
		else return r.count; 
	}
	
	@Override
	public int size() { /** Okay */
		return size(root);
	}
	
	private Node minNode(Node r) { /*  */ 
		if(r.left == null) return r;
		while (r.left != null) r = r.left;
		return r;
	}
	
	@Override
	public K min() { /* Okay */
		Node m = minNode(root);
		return (m != null)? m.key : null;
	}
	
	private Node maxNode(Node r) { /* Okay */
		if (r == null) return null;
		while (r.right != null) r = r.right;
		return r;
	}
	
	@Override /* Okay */
	public K max() {
		Node m = maxNode(root);
		return (m != null)? m.key : null;
	}
	
	private K floorNode(Node r, K key) { /* Okay */
		if (r == null) return null;
		int cmp = key.compareTo(r.key);
		if (cmp < 0) return floorNode(r.left, key);
		if (cmp > 0) {
			K tmp = floorNode(r.right, key);
			return (tmp != null)? tmp : r.key;
		}
		return r.key;
	}
	
	@Override /*  Okay*/
	public K floor(K key) {
		return floorNode(root, key);
	}
	
	private K ceiling(Node r, K e) { /* Okay */
		if (r == null) return null;
		int cmp = e.compareTo(r.key);
		if (cmp > 0) return ceiling(r.right, e);
		if (cmp < 0) {
			K tmp = ceiling(r.left, e);
			return (tmp != null)? tmp : r.key;
		}
		return r.key;
	}

	@Override /* Okay */
	public K ceiling(K e) {
		return ceiling(root, e);
	}
	
	
	private Node selectNode(Node r, int index) { /* Okay */
		if(r==null) return null;
		
		int tam = size(r.left);
		if(tam > index) return selectNode(r.left, index);
		else if(tam < index) return selectNode(r.right, index-tam-1);
		else return r;
	}
	
	
	public K select(int index) { /* OK - Recupera a key do índice 'index' */
		return selectNode(root, index).key;
	}
	
	private int rank(Node r, K e) { /* Okay */
		if (r == null) return 0;
		
		int cmp = e.compareTo(r.key);
		if (cmp < 0)  return rank(r.left, e);
		if (cmp > 0) return count(r.left) + rank(r.right, e) + 1;
		return count(r.left) + 1;
	}
	
	@Override /* Okay */
	public int rank(K e) {
		return rank(root, e);
	}
	
	private Node deleteMin(Node r) { /* Okay */
		if (r.left == null) return r.right;
		r.left = deleteMin(r.left);
		
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}

	@Override /* Okay */
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMax(Node r) { /* Okay */
		if (r.right == null) return r.left;
		r.right = deleteMax(r.right);
		
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}

	@Override /* Okay - Delete max key of tree */
	public void deleteMax() {
		root = deleteMax(root);
	}

	private int count(Node node) { /* Okay */
		return (node != null)? node.count : 0;
	}
	
	///atualizando...............................................
	@Override /* --- - Retorna o tamanho dentro de um intervalo*/
	public int size(K lo, K hi) {
		return 0;
	}
	
	@Override /* ---- */
	public Iterable<K> keys(K lo, K hi) {
		return () -> new Iterator<K>() {

			@Override
			public boolean hasNext() {
				
				return false;
			}

			@Override
			public K next() {
				
				return null;
			}
			
		};
	}
	
	
	void erd (Node r) {
		   if (r != null) {
		      erd (r.left);
		      System.out.println(r.key);
		      erd (r.right); 
		   }
	}
	
	@Override
	public Iterable <K> keys() {
		
		this.erd(root);
		return null;
	}
		
		
	/*@Override
	public Iterable <K> keys() {
		return () -> new Iterator<K>() {
			
			Node aux = root;

			@Override
			public boolean hasNext() {
				return aux != null;
			}

			@Override
			public K next() {
				
				if(aux != null) {
					K key = (K) aux.key;
					aux = aux.left
					return key; //(K) key;
				}
				
				return null;
			}
		};
	}*/
		
}