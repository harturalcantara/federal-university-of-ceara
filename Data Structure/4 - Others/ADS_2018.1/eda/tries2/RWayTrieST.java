package br.ufc.crateus.eda.tries2;

import java.util.LinkedList;
import java.util.Queue;

public class RWayTrieST<V> implements StringST<V> {

	private static final int R = 256;
	private Node root = new Node();
	private int n;

	private static class Node {
		Object value;
		Node[] next = new Node[R];
	}

	@Override
	public void put(String key, V value) {
		if (!contains(key))
			n++;
		root = put(root, key, value, 0);
	}

	private Node put(Node r, String key, V value, int i) {
		if (r == null)
			r = new Node();
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
		return (node != null) ? (V) node.value : null;
	}

	private Node get(Node r, String key, int i) {
		if (r == null)
			return null;
		if (i == key.length()) {
			return r;
		}
		int ch = key.charAt(i);
		return get(r.next[ch], key, i + 1);
	}

	@Override
	public boolean contains(String key) {
		return (get(key) != null) ? true : false;
	}

	@Override
	public void delete(String key) {
		delete(root, key, 0);
	}

	private Node delete(Node r, String key, int i) {
		if (r == null)
			return null;
		if (i == key.length())
			r.value = null;
		else {
			char ch = key.charAt(i);
			r.next[ch] = delete(r.next[ch], key, i + 1);
		}

		if (r.value != null)
			return r;
		for (Node n : r.next)
			if (n != null)
				return r;
		return null;
	}

	private void collect(Node r, String prefix, Queue<String> queue) {
		if (r != null) {
			if (r.value != null)
				queue.add(prefix);
			for (char i = 0; i < R; i++)
				collect(r.next[i], prefix + i, queue);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
 
	@Override
	public int size() {
		return size(root);
		//return n;
	}
	
	public int size(Node r) {
		
		if(r==null) return 0;
		int count = 0;
		if(r.value != null) 
			count++;
		for(char c = 0; c < R; c++)
			count += size(r.next[c]);
		
		return count;
	}
	
	/*
	public int size(Node r, int cont) {
		//System.out.println("Recebi cont: "+cont);
		for (char i = 0; i < R; i++) {
			if (r.next[i] != null) {
				cont = 1+size(r.next[i], cont+1);
			}
		}
		return cont;
	}*/

	@Override
	public Iterable<String> keys() {
		Queue<String> queue = new LinkedList<>();
		collect(root, "", queue);
		return queue;
	}

	@Override
	public String longestPrefixOf(String query) {
		int size = search(root, query, 0, 0);
		return query.substring(0, size);
	}

	private int search(Node node, String query, int i, int length) {
		if (node == null)
			return length;
		if (node.value != null)
			length = i;
		if (i == query.length())
			return length;
		char ch = query.charAt(i);
		return search(node.next[ch], query, i + 1, length);
	}

	@Override
	public Iterable<String> keysWithPrefix(String prefix) {
		Node node = get(root, prefix, 0);
		Queue<String> queue = new LinkedList<>();
		collect(node, prefix, queue);
		return queue;
	}

	void collect(Node r, String pre, String pat, Queue<String> keys) {
		int d = pre.length();
		if (r == null)
			return;
		if (d == pat.length() && r.value != null)
			keys.add(pre);
		if (d == pat.length())
			return;
		char prox = pat.charAt(d);
		for (char c = 0; c < R; c++)
			if (prox == '.' || prox == c)
				collect(r.next[c], pre + c, pat, keys);

	}

	public Iterable<String> keysThatMach(String prefix) {
		Queue<String> keys = new LinkedList<>();
		collect(root, "", prefix, keys);
		return keys;
	}


	public String floor(String key) {
		if (key == null) throw new IllegalArgumentException("Key cannot be null");
		return floor(root, key, 0, new StringBuilder(), null, true);
	}

	private String floor(Node node, String key, int digit, StringBuilder prefix, String lastKeyFound, boolean mustBeEqualDigit) {
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
			currentChar = R - 1;
		}

		for (char nextChar = currentChar; true; nextChar--) {
			if (node.next[nextChar] != null) {
				if (nextChar < currentChar) {
					mustBeEqualDigit = false;
				}

				lastKeyFound = floor(node.next[nextChar], key, digit + 1, prefix.append(nextChar), lastKeyFound, mustBeEqualDigit);

				if (lastKeyFound != null) {
					return lastKeyFound;
				}
				prefix.deleteCharAt(prefix.length() - 1);
			}

			// nextChar value never becomes less than zero in the for loop, so we need this
			// extra validation
			if (nextChar == 0) {
				break;
			}
		}
		
		return lastKeyFound;
	}

	/** Método ceilling */
	public String ceiling(String key) {
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

	public String min() {
		if (isEmpty()) {
			return null;
		}

		return min(root, new StringBuilder());
	}

	private String min(Node node, StringBuilder prefix) {

		if (node.value != null) {
			return prefix.toString();
		}

		for (char nextChar = 0; nextChar < R; nextChar++) {
			if (node.next[nextChar] != null) {
				return min(node.next[nextChar], prefix.append(nextChar));
			}
		}

		return prefix.toString();
	}

	public String max() {
		if (isEmpty()) {
			return null;
		}

		return max(root, new StringBuilder());
	}

	private String max(Node node, StringBuilder prefix) {

		for (char nextChar = R - 1; true; nextChar--) {
			if (node.next[nextChar] != null) {
				return max(node.next[nextChar], prefix.append(nextChar));
			}

			// nextChar value never becomes less than zero in the for loop, so we need this
			// extra validation
			if (nextChar == 0) {
				break;
			}
		}

		return prefix.toString();
	}

	public void deleteMin() {
		if (isEmpty()) {
			return;
		}

		String minKey = min();
		delete(minKey);
	}

	public void deleteMax() {
		if (isEmpty()) {
			return;
		}

		String maxKey = max();
		delete(maxKey);
	}

	public static void main(String[] args) {
		// StringST<Integer> st = new RWayTrieST<>();
		RWayTrieST<Integer> st = new RWayTrieST<>();
		st.put("shells", 0);
		st.put("sea", 0);
		st.put("by", 5);
		st.put("bye", 6);
		st.put("shore", 0);
		st.put("the", 0);
		st.put("sells", 0);
//		
//		System.out.println("Qtde filhos: "+ st.size());
//
//		// System.out.println("FLOOR: " +st.floor("bye"));
//		//System.out.println("CEILING: " + st.ceiling("shor"));
////
////		System.out.println("Imprimindo Lista");
////		for (String str : st.keys())
////			System.out.println(str);
//
//		
//		System.out.println("Select: " + st.select(2));
//		//System.out.println("Select" + st.select(6));
//
//		// System.out.println("Metodo - keysWithPrefix()");
//		// for (String str : st.keysWithPrefix("b"))
//		// System.out.println(str);
//		//
		System.out.println("Metodo - keysThatMach()");
		for (String str : st.keysThatMach("..."))
			System.out.println(str);
//		   RWayTrieST<Integer> trieOrdered = new RWayTrieST<>();
//
//	        trieOrdered.put("Rene", 0);
//	        trieOrdered.put("Re", 1);
//	        trieOrdered.put("Algorithms", 2);
//	        trieOrdered.put("Algo", 3);
//	        trieOrdered.put("Algor", 4);
//	        trieOrdered.put("Tree", 5);
//	        trieOrdered.put("Trie", 6);
//	        trieOrdered.put("TST", 7);
//	        trieOrdered.put("Trie123", 8);
//
//	        System.out.println("\nSelect 0: " + trieOrdered.select(0) );
//	        System.out.println("Expected: Algo");
//	        System.out.println("Select 3: " + trieOrdered.select(3));
//	        System.out.println("Expected: Re");
//	        System.out.println("Select 2: " + trieOrdered.select(2));
//	        System.out.println("Expected: Algorithms");
//	        System.out.println("Select 5: " + trieOrdered.select(5));
//	        System.out.println("Expected: TST");
//	        System.out.println("Select 8: " + trieOrdered.select(8));
//	    	System.out.println("Expected: Trie123");
//	    	
//
//	        System.out.println("\nRank of R: " + trieOrdered.rank("R"));
//	        System.out.println("Expected: 3");
//	        System.out.println("Rank of Re: " + trieOrdered.rank("Re"));
//	        System.out.println("Expected: 3");
//	        System.out.println("Rank of A: " + trieOrdered.rank("A"));
//	        System.out.println("Expected: 0");
//	        System.out.println("Rank of Algo: " + trieOrdered.rank("Algo"));
//	        System.out.println("Expected: 0");
//	        System.out.println("Rank of Algori: " + trieOrdered.rank("Algori"));
//	        System.out.println("Expected: 2");
//	        System.out.println("Rank of Algorithms: " + trieOrdered.rank("Algorithms"));
//	        System.out.println("Expected: 2");
//	        System.out.println("Rank of Tarjan: " + trieOrdered.rank("Tarjan"));
//	        System.out.println("Expected: 6");
//	        System.out.println("Rank of Trie123: " + trieOrdered.rank("Trie123"));
//	        System.out.println("Expected: 8");
//	        System.out.println("Rank of Zoom: " + trieOrdered.rank("Zoom"));
//	        System.out.println("Expected: 9");
	    	
	}
}