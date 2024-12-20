package br.ufc.crateus.lista2.questoes;

import java.util.LinkedList;

@SuppressWarnings("rawtypes")
public class TST<V> implements StringST<V> {
	
	private class Node<V> {
		V value;
		char ch;
		Node left, mid, right;

		public Node(char ch) {
			this.ch = ch;
		}
	}
	
	private Node root;

	private Node put(Node r, String key, V value, int i) {
		char ch = key.charAt(i);
		if (r == null)
			r = new Node(ch);
		if (ch < r.ch)
			r.left = put(r.left, key, value, i);
		else if (ch > r.ch)
			r.right = put(r.right, key, value, i);
		else if (i == key.length() - 1)
			r.value = value;
		else
			r.mid = put(r.mid, key, value, i + 1);
		return r;
	}

	@Override
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}

	@Override
	public V get(String key) {
		Node node = get(root, key, 0);
		return ((node != null) ? (V) node.value : null);
	}

	private Node get(Node r, String key, int i) {
		if (r == null)
			return null;
		char ch = key.charAt(i);
		if (ch < r.ch)
			return get(r.left, key, i);
		if (ch > r.ch)
			return get(r.right, key, i);
		if (i == key.length() - 1)
			return r;
		return get(r.mid, key, i + 1);
	}

	@Override
	public boolean contains(String key) {
		return (key != null) && get(key) != null;
	}

	private void collect(Node x, StringBuilder prefix, LinkedList<String> lista) {
		if (x == null)
			return;
		collect(x.left, prefix, lista);
		if (x.value != null)
			lista.add(prefix.toString() + x.ch);
		collect(x.mid, prefix.append(x.ch), lista);
		prefix.deleteCharAt(prefix.length() - 1);
		collect(x.right, prefix, lista);
	}

	@Override
	public void delete(String key) {
		if (key == null)
			return;
		if (!contains(key))
			return;
		root = delete(root, key, 0);
	}

	private Node delete(Node node, String key, int digit) {
		
		if (node == null)
			return null;
		
		if (digit == key.length() - 1)
			node.value = null;
		else {
			char nextChar = key.charAt(digit);
			if (nextChar < node.ch)
				node.left = delete(node.left, key, digit);
			else if (nextChar > node.ch)
				node.right = delete(node.right, key, digit);
			else
				node.mid = delete(node.mid, key, digit + 1);
		}
		
		if (getSizeNode(node) == 0) {
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				Node aux = node;
				node = min(aux.right);
				node.right = deleteMin(aux.right);
				node.left = aux.left;
			}
		}
		return node;
	}

	private Node min(Node node) {
		if (node.left == null)
			return node;
		return min(node.left);
	}

	private Node deleteMin(Node node) {
		if (node.left == null)
			return node.right;
		node.left = deleteMin(node.left);
		return node;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		return getSizeTree(root);
	}

	@Override
	public Iterable<String> keys() {
		LinkedList<String> keys = new LinkedList<>();
		collect(root, new StringBuilder(), keys);
		return keys;
	}

	@Override
	public String longestPrefixOf(String str) {
		if (str == null)
			return null;
		int length = search(root, str, 0, 0);
		return str.substring(0, length);
	}

	private int search(Node node, String query, int digit, int length) {
		if (node == null)
			return length;
		if (node.value != null)
			length = digit + 1;
		char nextChar = query.charAt(digit);
		if (nextChar < node.ch)
			return search(node.left, query, digit, length);
		else if (nextChar > node.ch)
			return search(node.right, query, digit, length);
		else if (digit < query.length() - 1)
			return search(node.mid, query, digit + 1, length);
		else
			return length;
	}

	@Override
	public Iterable<String> keysWithPrefix(String prefix) {
		if (prefix == null)
			return null;
		LinkedList<String> lista = new LinkedList<String>();
		Node x = get(root, prefix, 0);
		if (x == null)
			return lista;
		if (x.value != null)
			lista.add(prefix);
		collect(x.mid, new StringBuilder(prefix), lista);
		return lista;
	}

	@Override
	public Iterable<String> keysThatMatch(String str) {
		if (str == null)
			return null;
		LinkedList<String> keysThatMatch = new LinkedList<>();
		collect(root, new StringBuilder(), str, keysThatMatch);
		return keysThatMatch;
	}

	private void collect(Node node, StringBuilder prefix, String pattern, LinkedList<String> lista) {
		if (node == null)
			return;
		int digit = prefix.length();
		char nextCharInPattern = pattern.charAt(digit);
		if (nextCharInPattern == '.' || nextCharInPattern < node.ch)
			collect(node.left, prefix, pattern, lista);
		if (nextCharInPattern == '.' || nextCharInPattern == node.ch) {
			if (digit == pattern.length() - 1 && node.value != null) {
				lista.add(prefix.toString() + node.ch);
			} else if (digit < pattern.length() - 1) {
				collect(node.mid, prefix.append(node.ch), pattern, lista);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		}
		if (nextCharInPattern == '.' || nextCharInPattern > node.ch)
			collect(node.right, prefix, pattern, lista);
	}

	private int getSizeTree(Node x) {
		if (x == null)
			return 0;
		int cont = 0;
		if (x.value != null)
			cont++;
		cont += getSizeTree(x.left) + getSizeTree(x.right) + getSizeTree(x.mid);
		return cont;
	}

	private int getSizeNode(Node node) {
		int nodeValor = 0;
		if (node.value != null)
			nodeValor = 1;
		return getSizeTree(node.mid) + nodeValor;
	}

	public String select(int index) {
		if (index < 0 || index >= size())
			return null;
		return select(root, index, new StringBuilder());
	}

	private String select(Node node, int index, StringBuilder prefix) {
		if (node == null)
			return null;
		int leftSubtreeSize = getSizeTree(node.left);
		int tstSize = leftSubtreeSize + getSizeNode(node);
		if (index < leftSubtreeSize)
			return select(node.left, index, prefix);
		else if (index >= tstSize)
			return select(node.right, index - tstSize, prefix);
		else {
			index = index - leftSubtreeSize;
			if (node.value != null) {
				if (index == 0)
					return prefix.append(node.ch).toString();
				index--;
			}
			prefix.append(node.ch);
			return select(node.mid, index, prefix);
		}
	}

   
}
