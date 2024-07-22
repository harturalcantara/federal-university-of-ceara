package br.ufc.crateus.eda.tries;

public class RWayTries<V> {
	public static final int R = 256;

	private static class Node {
		Object value;
		Node[] next = new Node[R];
	}

	private Node root = new Node();

	@SuppressWarnings("unchecked")
	private V getValue(Node r) {
		if (r == null)
			return null;
		return (V) r.value;
	}

	private Node put(Node r, String key, int i, V value) {
		if (r == null)
			r = new Node();
		if (key.length() == i) {
			r.value = value;
		} else {
			char ch = key.charAt(i);
			r.next[ch] = put(r.next[ch], key, i + 1, value);
		}
		return r;
	}

	public void put(String key, V value) {
		root = put(root, key, 0, value);
	}

	private Node getNode(Node r, String key, int i) {
		if (r == null)
			return null;
		if (i == key.length()) {
			return r;
		} else {
			char ch = key.charAt(i);
			return getNode(r.next[ch], key, i+1);
		}
	}
	
	public V get(String key) {
		Node r = getNode(root, key, 0);
		return r == null ? null : getValue(r);
	}
}
