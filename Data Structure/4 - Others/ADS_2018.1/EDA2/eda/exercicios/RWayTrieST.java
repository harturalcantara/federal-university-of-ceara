package br.ufc.crateus.eda.exercicios;

import java.util.LinkedList;

import br.ufc.crateus.eda.tries.StringST;

public class RWayTrieST<V> implements StringST<V> {

	private static int R = 256;
	private Node root = new Node();

	private static class Node {
		private Object value;
		private Node[] next = new Node[R];
	}

	@Override
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}

	private Node put(Node x, String key, V value, int d) {
		if (x == null)
			x = new Node();
		if (d == key.length()) {
			x.value = value;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, value, d + 1);
		return x;
	}

	@Override
	public V get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (V) x.value;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);
	}

	@Override
	public void delete(String key) {
		root = delete(root, key, 0);
	}

	private Node delete(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			x.value = null;
		else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		if (x.value != null)
			return x;
		for (char c = 0; c < R; c++)
			if (x.next[c] != null)
				return x;
		return null;
	}

	@Override
	public boolean contains(String key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}

	@Override
	public String longestPrefixOf(String str) {
		int length = search(root, str, 0, 0);
		return str.substring(0, length);
	}

	private int search(Node x, String s, int d, int length) {
		if (x == null)
			return length;
		if (x.value != null)
			length = d;
		char c = s.charAt(d);
		return search(x.next[c], s, d + 1, length);
	}

	@Override
	public Iterable<String> keysWithPrefix(String pre) {
		LinkedList<String> lista = new LinkedList<String>();
		collect(get(root, pre, 0), pre, lista);
		return lista;
	}

	private void collect(Node x, String pre, LinkedList<String> lista) {
		if (x == null)
			return;
		if (x.value != null)
			lista.add(pre);
		for (char c = 0; c < R; c++)
			collect(x.next[c], pre + c, lista);
	}

	@Override
	public Iterable<String> keysThatMatch(String pat) {
		LinkedList<String> lista = new LinkedList<String>();
		collect(root, "", pat, lista);
		return null;
	}

	private void collect(Node x, String pre, String pat, LinkedList<String> lista) {
		int d = pre.length();
		if (x == null)
			return;
		if (d == pat.length() && x.value != null)
			lista.add(pre);
		if (d == pat.length())
			return;
		char next = pat.charAt(d);
		for (char c = 0; c < R; c++)
			if (next == '.' || next == c)
				collect(x.next[c], pre + x, pat, lista);
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		int cont = 0;
		if (x.value != null)
			cont++;
		for (char c = 0; c < R; c++) {
			cont += size(x.next[c]);
		}
		return cont;
	}

	@Override
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	public String select(int index) {
		if (index < 0 || index >= size()) {
			throw new IllegalArgumentException("Index cannot be negative and must be lower than trie size");
		}

		return select(root, index, new StringBuilder());
	}

	private String select(Node node, int index, StringBuilder prefix) {
		if (node == null) {
			return null;
		}

		if (node.value != null) {
			index--;

			// Found the key with the target index
			if (index == -1) {
				return prefix.toString();
			}
		}

		for (char nextChar = 0; nextChar < R; nextChar++) {
			if (node.next[nextChar] != null) {
				if (index - size(node.next[nextChar]) < 0) {
					return select(node.next[nextChar], index, prefix.append(nextChar));
				} else {
					index = index - size(node.next[nextChar]);
				}
			}
		}

		return null;
	}

	public int rank(String key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		return rank(root, key, 0, 0);
	}

	private int rank(Node node, String key, int digit, int size) {
		if (node == null || digit == key.length()) {
			return size;
		}

		// If a prefix key was found, add 1 to rank
		if (node.value != null) {
			if (digit < key.length()) {
				size++;
			} else {
				return size;
			}
		}

		char currentChar = key.charAt(digit);

		for (char nextChar = 0; nextChar < currentChar; nextChar++) {
			size += size(node.next[nextChar]);
		}

		return rank(node.next[currentChar], key, digit + 1, size);
	}

	// Returns the highest key in the symbol table smaller than or equal to key.
	public String floor(String key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		return floor(root, key, 0, new StringBuilder(), null, true);
	}

	private String floor(Node node, String key, int digit, StringBuilder prefix, String lastKeyFound,
			boolean mustBeEqualDigit) {
		if (node == null) {
			return null;
		}

		if (prefix.toString().compareTo(key) > 0) {
			return lastKeyFound;
		}

		if (node.value != null) {
			lastKeyFound = prefix.toString();
		}

		char currentChar;

		if (mustBeEqualDigit && digit < key.length()) {
			currentChar = key.charAt(digit);
		} else {
			currentChar = (char) (R - 1);
		}

		for (char nextChar = currentChar; true; nextChar--) {
			if (node.next[nextChar] != null) {
				if (nextChar < currentChar) {
					mustBeEqualDigit = false;
				}

				lastKeyFound = floor(node.next[nextChar], key, digit + 1, prefix.append(nextChar), lastKeyFound,
						mustBeEqualDigit);

				if (lastKeyFound != null) {
					return lastKeyFound;
				}
				prefix.deleteCharAt(prefix.length() - 1);
			}

			// nextChar value never becomes less than zero in the for loop, so
			// we need this extra validation
			if (nextChar == 0) {
				break;
			}
		}

		return lastKeyFound;
	}

	// Returns the smallest key in the symbol table greater than or equal to
	// key.
	public String ceiling(String key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}

		return ceiling(root, key, 0, new StringBuilder(), true);
	}

	private String ceiling(Node node, String key, int digit, StringBuilder prefix, boolean mustBeEqualDigit) {
		if (node == null) {
			return null;
		}

		if (node.value != null && prefix.toString().compareTo(key) >= 0) {
			return prefix.toString();
		}

		char currentChar;

		if (mustBeEqualDigit && digit < key.length()) {
			currentChar = key.charAt(digit);
		} else {
			currentChar = 0;
		}

		for (char nextChar = currentChar; nextChar < R; nextChar++) {
			if (node.next[nextChar] != null) {
				if (nextChar > currentChar) {
					mustBeEqualDigit = false;
				}

				String keyFound = ceiling(node.next[nextChar], key, digit + 1, prefix.append(nextChar),
						mustBeEqualDigit);

				if (keyFound != null) {
					return keyFound;
				}
				prefix.deleteCharAt(prefix.length() - 1);
			}
		}

		return null;
	}

	public static void main(String[] args) {
		RWayTrieST<String> arvore = new RWayTrieST<String>();
		arvore.put("casa", "casa");
		arvore.put("casamento", "casamento");
		arvore.put("da", "da");
		arvore.put("de", "de");
		arvore.put("espanha", "espanha");
		arvore.put("espeto", "espeto");
		arvore.put("mardonio", "mardonio");
		arvore.put("moeda", "moeda");

		for (String k : arvore.keys())
			System.out.println(k);

		//System.out.println("Select 3: "+arvore.select(3));

		//System.out.println("Rank espada: " + arvore.rank("espada"));
		
		//System.out.println("Floor espalhar: "+arvore.floor("espalhar"));
		
		//System.out.println("Ceiling espalhar: "+arvore.ceiling("espalhar"));
	}

}
