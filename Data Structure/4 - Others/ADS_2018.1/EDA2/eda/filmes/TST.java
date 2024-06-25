package br.ufc.crateus.eda.filmes;

public class TST <V> implements StringST<V>{
	
	private Node root;
	
	private class Node {
		char ch;
		V value;
		Node left, mid , right;
		
		public Node(char ch) {
			this.ch = ch;
		}
	}
	
	@Override
	public void put(String key, V value) {
		root = put(root, key, value, 0);	
	}
	
	private Node put(Node r, String key, V value, int i) {
		
		char ch = key.charAt(i);
		if (r == null) r = new Node(ch);
		
		if (ch < r.ch) r.left = put(r.left, key, value, i);
		else if (ch > r.ch) r.right = put(r.right, key, value, i);
		else if (i == key.length() - 1) r.value = value;
		else r.mid = put(r.mid, key, value, i + 1);
		
		return r;
	}
	
	@Override
	public V get(String key) {
		Node node = get(root, key, 0);
		return (node != null)? node.value : null;
	}
	
	private Node get(Node r, String key, int i) {
		
		if (r == null) return null;
		char ch = key.charAt(i);
		
		if (ch < r.ch) return get(r.left, key, i);
		if (ch > r.ch) return get(r.right, key, i);
		if (i == key.length() - 1) return r;
		
		return get(r.mid, key, i + 1);
	}
	
	
	@Override
	public boolean contains(String key) {
		Node node = contains(root, key, 0);
		return (node == null)? false : true;
	}
	
	private Node contains(Node r, String key, int i) {
		
		if (r == null) return null;
		char ch = key.charAt(i);
		
		if (ch < r.ch) return get(r.left, key, i);
		if (ch > r.ch) return get(r.right, key, i);
		if (i == key.length() - 1) return r;
		
		return contains(r.mid, key , i+1);
	}	
	
	@Override
	public void delete(String key) {
		this.root = delete(root, key, 0);
	}
	
	private Node delete(Node r, String key, int i) {
		
		if(r == null) return null;
		
		if(i == key.length() - 1) r.value = null;
		else {
			char ch = key.charAt(i);
	
			if(ch < r.ch) r.left =  delete(r.left, key, i);
			if(ch > r.ch) r.right = delete(r.right, key, i);	
		}
		
		if(r.value != null) return r;
		
		
		if(r.right != null) return r;
		if(r.mid != null) return r;
		if(r.left != null) return r;
		
		return null;
		
	}
	
	@Override
	public boolean isEmpty() {
		return (root == null)? true : false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<String> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String longestPrefixOf(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Iterable<String> keysWithPrefix(String prefix) {
		return null;
	}
	
}
