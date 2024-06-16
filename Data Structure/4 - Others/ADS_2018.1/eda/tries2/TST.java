package br.ufc.crateus.eda.tries2;

import java.util.LinkedList;
import java.util.Queue;

public class TST<V> implements StringST<V> {
	
	private Node root;
	
	private class Node {
		V value;
		char ch;
		Node left, mid, right;
		
		public Node(char ch) {
			this.ch = ch;
		}
	}
	
	public TST() {
	}
	
	private Node put(Node r, String key, V value, int i) {
		char ch = key.charAt(i);
		if (r == null) 
			r = new Node(ch);
		
		if (ch < r.ch) r.left = put(r.left, key, value, i);
		else if (ch > r.ch) r.right = put(r.right, key, value, i);
		else if (i == key.length() - 1) r.value = value;
		else r.mid = put(r.mid, key, value, i + 1);
		return r;
	}

	@Override
	public void put(String key, V value) {
		if (key == null) 
			return;
		
		if (!contains(key)) return;
		root = put(root, key, value, 0);
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
		if(key == null) return false;
		return get(key) != null;
	}

	@Override
	public void delete(String key) {
		delete(root, key, 0);
	}
	
    private Node delete(Node node, String key, int digit) {
        if (node == null) {
            return null;
        }

        if (digit == key.length() - 1) {
            //node.size() = node.size - 1;
            node.value = null;
        } else {
            char nextChar = key.charAt(digit);

            if (nextChar < node.ch) {
                node.left = delete(node.left, key, digit);
            } else if (nextChar > node.ch) {
                node.right = delete(node.right, key, digit);
            } else {
                //node.size = node.size - 1;
                node.mid = delete(node.mid, key, digit + 1);
            }
        }

        if (getSizeTree(node) == 0) {
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

	@Override
	public boolean isEmpty() {
		return root == null;
	}
	
	@Override
	public Iterable<String> keys() {
        Queue<String> queue = new LinkedList<>();
        collect(root, new StringBuilder(), queue);
        return queue;
	}
	
	private void collect(Node x, StringBuilder prefix, Queue<String> queue) {
	        if (x == null) return;
	        collect(x.left,  prefix, queue);
	        if (x.value != null) queue.add(prefix.toString() + x.ch);
	        collect(x.mid,   prefix.append(x.ch), queue);
	        prefix.deleteCharAt(prefix.length() - 1);
	        collect(x.right, prefix, queue);
	}
	
	@Override
	public Iterable<String> keysWithPrefix(String prefix) {
		if (prefix == null) {
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }
        Queue<String> queue = new LinkedList<>();
        Node x = get(root, prefix, 0);
        if (x == null) return queue;
        if (x.value != null) queue.add(prefix);
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
	}
	
	@Override
	public String longestPrefixOf(String query) {
        if (query == null) {
            throw new IllegalArgumentException("calls longestPrefixOf() with null argument");
        }
        if (query.length() == 0) return null;
        int length = 0;
        Node x = root;
        int i = 0;
        while (x != null && i < query.length()) {
            char c = query.charAt(i);
            if      (c < x.ch) x = x.left;
            else if (c > x.ch) x = x.right;
            else {
                i++;
                if (x.value != null) length = i;
                x = x.mid;
            }
        }
        return query.substring(0, length);
    }
	
    public Iterable<String> keysThatMatch(String pattern) {
        Queue <String>queue = new LinkedList<>(); //OBS
        collect(root, new StringBuilder(), 0, pattern, queue);
        return queue;
    }
 
    private void collect(Node x, StringBuilder prefix, int i, String pattern, Queue<String> queue) {
        if (x == null) 
        	return;
        char c = pattern.charAt(i);
        if (c == '.' || c < x.ch) 
        	collect(x.left, prefix, i, pattern, queue);
        if (c == '.' || c == x.ch) {
            if (i == pattern.length() - 1 && x.value != null) 
            	queue.add(prefix.toString() + x.ch);
            if (i < pattern.length() - 1) {
                collect(x.mid, prefix.append(x.ch), i+1, pattern, queue);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        if (c == '.' || c > x.ch) 
        	collect(x.right, prefix, i, pattern, queue);
    }
	
    
    

	
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

        if (contains(key)) {
            return key;
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
	
    
	@Override
	public int size() {
		return getSizeTree(root);
	}
	
	private int getSizeTree(Node r) {
		
		if(r == null) return 0;
		
		int cont= 0;	
		if(r.value != null) 
				cont++;
		
		cont += getSizeTree(r.left) +getSizeTree(r.mid)+  getSizeTree(r.right) ;
		return cont;
	}
	
	private int getSizeNode(Node r) {
		int nodeValor = 0;
		if(r.value != null) {
			nodeValor = 1;
		}
		return getSizeTree(r.mid) + nodeValor;
	}
    
    public String select(int index) {
        if (index < 0 || index >= size()) throw new IllegalArgumentException("Index cannot be negative and must be lower than TST size");
        return select(root, index, new StringBuilder());
    }

    private String select(Node node, int index, StringBuilder prefix) {
       
    	if (node == null)
            return null;

        int leftSubtreeSize = getSizeTree(node.left);
        int tstSize = leftSubtreeSize + getSizeNode(node);
        
        if (index < leftSubtreeSize) {
            return select(node.left, index, prefix);
        } else if (index >= tstSize) {
            return select(node.right, index - tstSize, prefix);
        } else {
            index = index - leftSubtreeSize;

            if (node.value != null) {
                if (index == 0) {
                    return prefix.append(node.ch).toString();
                }
                index--;
            }

            prefix.append(node.ch);
            return select(node.mid, index, prefix);
        }
    }
    
    /*
    public int rank(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        return rank(root, key, 0, 0);
    }

    private int rank(Node node, String key, int digit, int size) {
        if (node == null) {
            return size;
        }

        char currentChar = key.charAt(digit);

        if (currentChar < node.ch) {
            return rank(node.left, key, digit, size);
        } else {
            if (currentChar > node.ch) {
                if (node.value != null) {
                    size++;
                }

                return getTreeSize(node.left) + getTreeSize(node.mid) + rank(node.right, key, digit, size);
            } else if (digit < key.length() - 1) {
                // Is current key a prefix of the search key?
                if (digit < key.length() - 1 && node.value != null) {
                    size++;
                }

                return getTreeSize(node.left) + rank(node.mid, key, digit + 1, size);
            } else {
                return getTreeSize(node.left) + size;
            }
        }
    }
	*/

    
    public String min() {
        if (isEmpty()) {
            return null;
        }

        Node minNode = min(root);

        StringBuilder minKey = new StringBuilder();
        minKey.append(minNode.ch);

        while (minNode.value == null) {
            minNode = minNode.mid;

            while (minNode.left != null) {
                minNode = minNode.left;
            }
            minKey.append(minNode.ch);
        }

        return minKey.toString();
    }
    
    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }

        return min(node.left);
    }
    
    public void deleteMin() {
        if (isEmpty()) {
            return;
        }

        String minKey = min();
        delete(minKey);
    }
    
    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        return node;
    }
    
    
	public static void main(String[] args) {

		TST<Integer> st = new TST<>();
		st.put("shells", 0);
		st.put("sea", 0);
		st.put("by", 5);
		st.put("bye", 6);
		st.put("shore", 0);
		st.put("the", 0);
		st.put("sells", 0);
		
//		System.out.println("Metodo - keys()");
//		for (String str : st.keys())
//			System.out.println(str);
//		
//		System.out.println("Metodo - keysPrefixOf()");
//		for (String str : st.keysWithPrefix("shor"))
//			System.out.println(str);
//		
//		System.out.println("Metodo - keysThatMatch()");
//		for (String str : st.keysThatMatch("s.or."))
//			System.out.println(str);
		
		
		
//		System.out.println("Imprimindo Lista");
//		for (String str : st.keys())
//			System.out.println(str);
//		
//		st.delete("sea");
		//System.out.println("Oi: " +st.floor("bye"));
		
		st.put("Rene", 0);
        st.put("Re", 1);
        st.put("Algorithms", 2);
        st.put("Algo", 3);
        st.put("Algor", 4);
        st.put("Tree", 5);
        st.put("Trie", 6);
        st.put("TST", 7);
        st.put("Trie123", 8);
        
        
        
//        System.out.println("Floor of Re: " + st.floor("Re"));
//        System.out.println("Expected: Re");
//        System.out.println("Floor of Algori: " + st.floor("Algori"));
//        System.out.println("Expected: Algor");
//        System.out.println("Floor of Ball: " + st.floor("Ball"));
//        System.out.println("Expected: Algorithms");
//        System.out.println("Floor of Tarjan: " + st.floor("Tarjan"));
//        System.out.println("Expected: TST");
//        System.out.println("Floor of AA: " + st.floor("AA"));
//        System.out.println("Expected: null");
//        System.out.println("Floor of Zoom: " + st.floor("Zoom"));
//        System.out.println("Expected: Trie123");
//        System.out.println("Floor of TAB: " + st.floor("TAB"));
//        System.out.println("Expected: Rene");
//
//        System.out.println("\nCeiling of Re: " + st.ceiling("Re"));
//        System.out.println("Expected: Re");
//        System.out.println("Ceiling of Algori: " + st.ceiling("Algori"));
//        System.out.println("Expected: Algorithms");
//        System.out.println("Ceiling of Ball: " + st.ceiling("Ball"));
//        System.out.println("Expected: Re");
//        System.out.println("Ceiling of Tarjan: " + st.ceiling("Tarjan"));
//        System.out.println("Expected: Tree");
//        System.out.println("Ceiling of AA: " + st.ceiling("AA"));
//        System.out.println("Expected: Algo");
//        System.out.println("Ceiling of Zoom: " + st.ceiling("Zoom"));
//        System.out.println("Expected: null");
//        System.out.println("Ceiling of Ruby: " + st.ceiling("Ruby"));
//        System.out.println("Expected: TST");

        System.out.println("\nSelect 0: " + st.select(0));
        System.out.println("Expected: Algo");
        System.out.println("Select 3: " + st.select(3));
        System.out.println("Expected: Re");
        System.out.println("Select 2: " + st.select(2));
        System.out.println("Expected: Algorithms");
        System.out.println("Select 5: " + st.select(5));
        System.out.println("Expected: TST");
        System.out.println("Select 8: " + st.select(8));
        System.out.println("Expected: Trie123");
        /*
        System.out.println("\nRank of R: " + st.rank("R"));
        System.out.println("Expected: 3");
        System.out.println("Rank of Re: " + st.rank("Re"));
        System.out.println("Expected: 3");
        System.out.println("Rank of A: " + st.rank("A"));
        System.out.println("Expected: 0");
        System.out.println("Rank of Algo: " + st.rank("Algo"));
        System.out.println("Expected: 0");
        System.out.println("Rank of Algori: " + st.rank("Algori"));
        System.out.println("Expected: 2");
        System.out.println("Rank of Algorithms: " + st.rank("Algorithms"));
        System.out.println("Expected: 2");
        System.out.println("Rank of Tarjan: " + st.rank("Tarjan"));
        System.out.println("Expected: 6");
        System.out.println("Rank of Trie123: " + st.rank("Trie123"));
        System.out.println("Expected: 8");
        System.out.println("Rank of Zoom: " + st.rank("Zoom"));
        System.out.println("Expected: 9");
		*/

	}
	
	

}