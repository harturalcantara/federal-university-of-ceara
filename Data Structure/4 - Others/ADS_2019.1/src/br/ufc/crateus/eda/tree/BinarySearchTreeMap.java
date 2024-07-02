package br.ufc.crateus.eda.tree;

public class BinarySearchTreeMap<K extends Comparable<K>, V> implements OrderedMap<K, V> {

	protected class Node {
		K key;
		V value;
		Node left;
		Node right;
		int count;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.count = 1;
		}
	}
	
	Node root;
	
	@Override
	public void put(K key, V value) {
		root = put(root, key, value);
	}
	
	private Node put(Node r, K key, V value) {
		if (r == null) return new Node(key, value);
		
		if (key.compareTo(r.key) < 0) r.left = put(r.left, key, value);
		else if (key.compareTo(r.key) > 0) r.right = put(r.right, key, value);
		else r.value = value;
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}
	
	protected int count(Node r) {
		return (r!=null)? r.count : 0;
	}

	@Override
	public V get(K key) {
		return getNode(root, key).value;
	}
	
	private Node getNode(Node r, K key) {
		if (r == null) return null;
		if (key.compareTo(r.key) < 0) return getNode(r.left, key);
		else if (key.compareTo(r.key) > 0) return getNode(r.right, key);
		return r;
	}

	@Override
	public void remove(K key) {
		root = remove(root, key);
	}
	
	private Node remove(Node r, K key) {
		if(r==null) return null;
		
		int cmp = key.compareTo(key);
		if(cmp < 0) r.left = remove(r.left, key);
		if(cmp > 0) r.right = remove(r.right, key);
		else {
			if(r.left == null) return r.right;
			if(r.right == null) return r.left;
			Node tmp = r;
			r = minNode(r.right);
			r.left = tmp.left;
			r.right = removeMin(tmp.right);
		}
		return r;
	}

	@Override
	public Iterable<K> keys() {
		
		return null;
	}
	
	
	private Node minNode(Node r) {
		if(r==null) return null;
		if(r.left == null) return r;
		return minNode(r.left);
	}
	
	private Node removeMin(Node r) {
		if(r==null) return null;
		if(r.left == null) return r.right;
		r.left = removeMin(r.left);
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}
	
	public void removeMin() {
		root = removeMin(root);
	}
	
	@Override
	public K min() {
		return minNode(root).key;
	}

	private Node maxNode(Node r) {
		if(r==null) return null;
		if(r.right == null) return r;
		return maxNode(r.right);
	}
	
	private Node removeMax(Node r) {
		if(r==null) return null;
		if(r.right == null) return r.left;
		r.right = removeMax(r.right);
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}
	
	public void removeMax() {
		root = removeMax(root);
	}
	
	@Override
	public K max() {
		return maxNode(root).key;
	}

	
	private K ceiling(Node r, K val) {
		if(r == null) return null;
		int cmp = val.compareTo(r.key);
		
		if(cmp > 0) return floor(r.right, val);
		if(cmp < 0) {
			K tmp = floor(r.left, val);
			return (tmp != null)? tmp : r.key;
		}
		return r.key;
	
	}
	
	@Override
	public K ceiling(K val) {
		return ceiling(root, val);
	}
	
	private K floor(Node r, K val) {
		if(r == null) return null;
		int cmp = val.compareTo(r.key);
		
		if(cmp < 0) return floor(r.left, val);
		if(cmp > 0) {
			K tmp = floor(r.right, val);
			return (tmp != null)? tmp : r.key;
		}
		return r.key;
	
	}
	
	@Override
	public K floor(K val) {
		return floor(root, val);
	}
	
	@Override
	public int rank(K val) {
		return rank(root, val);
	}
	
	private int rank(Node r, K val) {
		if (r == null) return 0;

		int cmp = val.compareTo(r.key);
		if (cmp < 0) return rank(r.left, val);
		if(cmp > 0) return count(r.left) + rank(r.right, val) + 1;
		return count(r.left) + 1;
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node r) {
		if (r == null) return -1;
		int hLeft = height(r.left);
		int hRight = height(r.right);
        if (hLeft > hRight) return (hLeft + 1); 
        return (hRight + 1); 
	}

	@Override
	public int size() {
		return count(root);
	}

	@Override
	public int size(K lo, K hi) {
		// TODO Auto-generated method stub
		return 0;
	}
}
