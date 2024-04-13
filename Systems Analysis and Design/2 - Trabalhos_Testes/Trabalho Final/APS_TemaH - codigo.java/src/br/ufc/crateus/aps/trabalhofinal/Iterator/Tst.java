package br.ufc.crateus.aps.trabalhofinal.Iterator;



import java.util.LinkedList;
import java.util.Queue;



public class Tst<V> implements ST<String, V> {
	
	private static class Node{
		Object value;
		Node left,mid,right;
		char c;
		@SuppressWarnings("unused")
		int size;
	}
	
	private Node root = new Node();
	private int n;
	
	@Override
	public void put(String k, V v) {
		root  = put(root,k,v,0,true);n++;
		
		
	}
	
	private Node put(Node r,String key,V value,int d,boolean ts) {
		char c = key.charAt(d);
		if(r == null) {
			r = new Node();
			r.c = c;
			
		}
		if(c < r.c)  r.left = put(r.left,key,value,d,ts);
		else if(c > r.c) r.right = put(r.right,key,value,d,ts);
		else if(d < key.length() - 1) r.mid = put(r.mid,key,value,d+1,ts);
		else r.value =  value;
		
		
		return r;
	}

	@Override
	public boolean contains(String k) {
		// TODO Auto-generated method stub
		return get(k) != null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public void delete(String k) {
		root = delete(root,k,0);
		
	}
    

private int search(Node node, String query, int digit, int length) {
    if (node == null)return length;
    

    if (node.value != null && node.c == query.charAt(digit)) length = digit + 1;
    
    
    if(digit == query.length() - 1)return length;

    char nextChar = query.charAt(digit);

    if (nextChar < node.c)  return search(node.left, query, digit, length);
    if (nextChar > node.c)  return search(node.right, query, digit, length);
   	 return search(node.mid, query, digit + 1, length);
     
        
    

}

	private Node delete(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length() -1) {
			if (x.value != null)
				n--;
			x.value = null;
			return x;
		} else {
			char c = key.charAt(d);
			if (c < x.c)
				x.left = delete(x.left, key, d);
			else if (c > x.c)
				x.right = delete(x.right, key, d);
			else
				x.mid = delete(x.mid, key, d + 1);
		}

		if (x.value != null)
			return x;
		if (x.left == null && x.mid == null && x.right == null)
			return null;
		return x;
}


	@SuppressWarnings("unchecked")
	@Override
	public V get(String k) {
		Node n = get(root,k,0);
		return (n == null)? null :(V)n.value;
	}
	private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (key.length() == 0) throw new IllegalArgumentException("length >= 1");
        char c = key.charAt(d);
        if      (c < x.c)              return get(x.left,  key, d);
        else if (c > x.c)              return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid,   key, d+1);
        else                           return x;
}

	@Override
	public int size() {
		
		return n;
	}

	@Override
	public Iterable<String> keys() {
		Queue<String> queue = new LinkedList<>();
        collect(root, new StringBuilder(), queue);
        return queue;

	}
	
	 public String longestPrefixOf(String query) {
	       /* if (query == null) {
	            throw new IllegalArgumentException("calls longestPrefixOf() with null argument");
	        }*/
	       /* if (query.length() == 0) return null;
	        int length = 0;
	        Node x = root;
	        int i = 0;
	        while (x != null && i < query.length()) {
	            char c = query.charAt(i);
	            if      (c < x.c) x = x.left;
	            else if (c > x.c) x = x.right;
	            else {
	                i++;
	                if (x.value != null) length = i;
	                x = x.mid;
	            }
	        }*/
	        int length = search(root, query, 0, 0);
	        return query.substring(0, length);
	    
 }

	public Iterable<String> keysWithPrefix(String prefix) {
		if (prefix == null) {
			throw new IllegalArgumentException(" :( ");
		}
		Queue<String> queue = new LinkedList<>();
		Node x = get(root, prefix, 0);
		if (x == null) return queue;
		if (x.value != null) queue.add(prefix);
		collect(x.mid, new StringBuilder(prefix), queue);
		return queue;
	}
	
	
	private void collect(Node x, StringBuilder prefix, Queue<String> queue) {
		if (x == null) return;
		collect(x.left,  prefix, queue);
		if (x.value != null) queue.add(prefix.toString() + x.c);
		collect(x.mid,   prefix.append(x.c), queue);
		prefix.deleteCharAt(prefix.length() - 1);
		collect(x.right, prefix, queue);
	}
	 public Iterable<String> keysThatMatch(String pattern) {
	        Queue<String> queue = new LinkedList<String>();
	        collect(root, new StringBuilder(), 0, pattern, queue);
	        return queue;
	    }
	 
	    private void collect(Node x, StringBuilder prefix, int i, String pattern, Queue<String> queue) {
	        if (x == null) return;
	        char c = pattern.charAt(i);
	        if (c == '.' || c < x.c) collect(x.left, prefix, i, pattern, queue);
	        if (c == '.' || c == x.c) {
	            if (i == pattern.length() - 1 && x.value != null) queue.add(prefix.toString() + x.c);
	            if (i < pattern.length() - 1) {
	                collect(x.mid, prefix.append(x.c), i+1, pattern, queue);
	                prefix.deleteCharAt(prefix.length() - 1);
	            }
	        }
	        if (c == '.' || c > x.c) collect(x.right, prefix, i, pattern, queue);
	    }



	
	/*public Iterable<String> keysThatMatch(String pattern) {
		Queue<String> queue = new LinkedList<>();
		collect(root, pattern, 0,"", queue);
		return queue;
	}
	
	private void collect(Node x, String prefix, int i, String pattern, Queue queue) {
		if (x == null) return;
		if(i <= prefix.length()-1) {
		char c = pattern.charAt(i);
		if (c < x.c||c == '.'  ) collect(x.left, prefix, i, pattern, queue);
		if (c > x.c||c == '.'  )collect(x.right,prefix,i,pattern,queue); 
		if( c == x.c|| c == '.') collect(x.mid,prefix,i + 1,pattern,queue );
		
		if(c !=x.c && c != '.')return;
		
		if(x.value != null && i == prefix.length() - 1)queue.add(pattern+x.c);
			
			
	    }
		return;
	}*/
	

}
