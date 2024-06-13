package br.ufc.crateus.eda.exercicios;

import java.util.LinkedList;

public class TST<V> implements StringST<V> {

	private Node root;

	private class Node<V> {
		V value;
		char ch;
		Node left, mid, right;

		public Node(char ch) {
			this.ch = ch;
		}
	}

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
            return lastKeyFound;
        }

        StringBuilder prefixWithCharacter = new StringBuilder(prefix).append(node.ch);

        char currentChar;
        if (digit < key.length() && mustBeEqualDigit) {
            currentChar = key.charAt(digit);
        } else {
            currentChar = Character.MAX_VALUE;
            mustBeEqualDigit = false;
        }

        if (currentChar < node.ch && mustBeEqualDigit) {
            return floor(node.left, key, digit, prefix, lastKeyFound, true);
        } else if (!mustBeEqualDigit || currentChar >= node.ch) {
            // Optimization: if current prefix is higher than the search key, left is the only way to go
            if (prefixWithCharacter.toString().compareTo(key) > 0) {

                if (node.left != null) {
                    return floor(node.left, key, digit, prefix, lastKeyFound, mustBeEqualDigit);
                }
                return lastKeyFound;
            }

            if (mustBeEqualDigit && currentChar > node.ch) {
                mustBeEqualDigit = false;
            }

            // Check child nodes in the order: right, middle, current, left
            String rightKey = floor(node.right, key, digit, prefix, lastKeyFound, mustBeEqualDigit);
            if (rightKey != null) {
                return rightKey;
            }

            String middleKey = floor(node.mid, key, digit + 1, prefixWithCharacter, null, mustBeEqualDigit);
            if (middleKey != null) {
                return middleKey;
            }

            if (node.value != null && prefixWithCharacter.toString().compareTo(key) <= 0) {
                return prefixWithCharacter.toString();
            }

            String leftKey = floor(node.left, key, digit, prefix, lastKeyFound, mustBeEqualDigit);
            if (leftKey != null) {
                return leftKey;
            }
        }

        return null;
    }

    // Returns the smallest key in the symbol table greater than or equal to key.
    public String ceiling(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        return ceiling(root, key, 0, new StringBuilder(), null, true);
    }

    private String ceiling(Node node, String key, int digit, StringBuilder prefix, String lastKeyFound,
                           boolean mustBeEqualDigit) {
        if (node == null) {
            return lastKeyFound;
        }

        StringBuilder prefixWithCharacter = new StringBuilder(prefix).append(node.ch);

        char currentChar;
        if (digit < key.length() && mustBeEqualDigit) {
            currentChar = key.charAt(digit);
        } else {
            currentChar = 0;
            mustBeEqualDigit = false;
        }

        if (currentChar > node.ch && mustBeEqualDigit) {
            return ceiling(node.right, key, digit, prefix, lastKeyFound, true);
        } else if (!mustBeEqualDigit || currentChar <= node.ch) {
            if (mustBeEqualDigit && currentChar < node.ch) {
                mustBeEqualDigit = false;
            }

            // Check child nodes in the order: left, current, middle, right
            if (!mustBeEqualDigit) {
                lastKeyFound = ceiling(node.left, key, digit, prefix, null, false);
                if (lastKeyFound != null) {
                    return lastKeyFound;
                }
            }

            if (node.value != null && prefixWithCharacter.toString().compareTo(key) >= 0) {
                return prefixWithCharacter.toString();
            }

            String middleKey = ceiling(node.mid, key, digit + 1, prefixWithCharacter, null, mustBeEqualDigit);
            if (middleKey != null) {
                return middleKey;
            }

            String rightKey = ceiling(node.right, key, digit, prefix, null, mustBeEqualDigit);
            if (rightKey != null) {
                return rightKey;
            }
        }

        return null;
    }
	
	public static void main(String[] args) {
		TST<Integer> arvore = new TST<>();

		arvore.put("Rene", 0);
		arvore.put("Re", 1);
		arvore.put("Algorithms", 2);
		arvore.put("Algo", 3);
		arvore.put("Algor", 4);
		arvore.put("Tree", 5);
		arvore.put("Trie", 6);
		arvore.put("TST", 7);
		arvore.put("Trie123", 8);

		for (String str : arvore.keys())
			System.out.println(str);

		System.out.println("\nSelect 0: " + arvore.select(0));
		System.out.println("Expected: Algo");
		System.out.println("Select 3: " + arvore.select(3));
		System.out.println("Expected: Re");
		System.out.println("Select 2: " + arvore.select(2));
		System.out.println("Expected: Algorithms");
		System.out.println("Select 5: " + arvore.select(5));
		System.out.println("Expected: TST");
		System.out.println("Select 8: " + arvore.select(8));
		System.out.println("Expected: Trie123");
		
		System.out.println("\nFloor of Re: " + arvore.floor("Re"));
		System.out.println("Expected: Re");
		System.out.println("Floor of Algori: " + arvore.floor("Algori"));
		System.out.println("Expected: Algor");
		System.out.println("Floor of Ball: " + arvore.floor("Ball"));
		System.out.println("Expected: Algorithms");
		System.out.println("Floor of Tarjan: " + arvore.floor("Tarjan"));
		System.out.println("Expected: TST");
		System.out.println("Floor of AA: " + arvore.floor("AA"));
		System.out.println("Expected: null");
		System.out.println("Floor of Zoom: " + arvore.floor("Zoom"));
		System.out.println("Expected: Trie123");
		System.out.println("Floor of TAB: " + arvore.floor("TAB"));
		System.out.println("Expected: Rene");

		System.out.println("\nCeiling of Re: " + arvore.ceiling("Re"));
		System.out.println("Expected: Re");
		System.out.println("Ceiling of Algori: " + arvore.ceiling("Algori"));
		System.out.println("Expected: Algorithms");
		System.out.println("Ceiling of Ball: " + arvore.ceiling("Ball"));
		System.out.println("Expected: Re");
		System.out.println("Ceiling of Tarjan: " + arvore.ceiling("Tarjan"));
		System.out.println("Expected: Tree");
		System.out.println("Ceiling of AA: " + arvore.ceiling("AA"));
		System.out.println("Expected: Algo");
		System.out.println("Ceiling of Zoom: " + arvore.ceiling("Zoom"));
		System.out.println("Expected: null");
		System.out.println("Ceiling of Ruby: " + arvore.ceiling("Ruby"));
		System.out.println("Expected: TST");

	}

}
