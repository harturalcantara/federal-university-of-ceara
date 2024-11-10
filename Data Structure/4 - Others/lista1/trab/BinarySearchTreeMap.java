package br.ufc.crateus.eda.lista1.trab;

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
	
    public boolean contains(K key) {
        return get(key) != null;
    }
	
	@Override
	public int size(K lo, K hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null"); 
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null"); 

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
	}
	
	//QUESTOES DA LISTA 1
	/* Questao 1 a 4. - Papel.*/
	/* Questao 5. - Implementado acima.*/
	
	
	/* Questao 6.*/
    private Node sortedArrayToBSTMap(K arr[], int start, int end) { 
        if (start > end) return null; 
        int mid = (start + end) / 2; 
        Node node = new Node(arr[mid], null); 
        node.left = sortedArrayToBSTMap(arr, start, mid - 1); 
        node.right = sortedArrayToBSTMap(arr, mid + 1, end); 
        return node; 
    }
    
    public Node sortedArrayToBSTMap(K arr[]) {
    	return sortedArrayToBSTMap(arr, 0, arr.length);
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /* Questao 7.*/
	private K[] inOrder(Node r, K arr[], int count) {
		if (r == null) return null;
		inOrder(r.left, arr, count);
		arr[count++] = r.key;
		inOrder(r.right, arr, count);
		return arr;
	} 
		
	public Node forcaBruta(Node r, K arr[]) {
		return sortedArrayToBSTMap( inOrder(root, arr, 0) ); //Retorna uma arvore balanceada
	}
	
	@SuppressWarnings("unused")
	private Node putModificad(Node r, K key, V value, K []arr) {
		if (r == null) return new Node(key, value);
		if (key.compareTo(r.key) < 0) r.left = putModificad(r.left, key, value, arr);
		else if (key.compareTo(r.key) > 0) r.right = putModificad(r.right, key, value, arr);
		else r.value = value;
		
		r = forcaBruta(r, arr);
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}
	
	
	/* Questao 8.*/
	
	public K select(int index) {
		return select(root, index).key;
	}
	private Node select(Node r, int index) {
		if(r==null) return null;
		
		int tam = count(r.left);
		if(tam < index) return select(r.left, index);
		if(tam > index) return select(r.right, index-tam-1);
		return r;
	}
	
	/* Questao 9. Custa O(n), pois precisa-se verificar todos os nos.*/
	public int depth(K key) { 
		return depth(root, 0, key);
	}
	
	private int depth(Node r, int count, K key) {
		if(r == null) return -1;
		int cmp = key.compareTo(key);
		if(cmp < 0) return depth(r.left, count, key) +1;
		if(cmp > 0) return depth(r.right, count, key) +1;
		return count;
	}
	
	
	
	
	
}
