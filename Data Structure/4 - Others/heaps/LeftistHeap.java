package br.ufc.crateus.eda.heaps;

public class LeftistHeap <K extends Comparable <K>>{
	
	class Node{
	    K key; 
	    int sValue; 
	    Node left, right;            

	    public Node(K key){
	        this.key = key;
	        this.right = null;
	        this.left = null;
	    }
	    public Node(K key, Node left, Node right){
	        this.key = key;
	        this.left = left;
	        this.right = right;
	        this.sValue = 0;
	    }
	}
	
    private Node root; 

    public LeftistHeap() {
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }
    
    public void insert(K key ){
        root = merge( new Node(key), root);
    }
	
    private Node merge(Node h1, Node h2){
    	if (h1 == null) return h2;
        if (h2 == null) return h1;

        if ( h1.key.compareTo(h2.key) > 0){
            Node temp = h1;
            h1 = h2;
            h2 = temp;
        }
         if(h1.left == null) {
            h1.left = h2;
        } 
        else {
        	h1.right = merge(h1.right, h2);
            if(h1.left.sValue < h1.right.sValue) {
                  Node temp = h1.left;
                  h1.left = h1.right;
                  h1.right = temp;
            }
            h1.sValue = h1.right.sValue + 1;
        }        
        return h1;
    }
    
    public void merge( LeftistHeap<K> rhs ){
        if( this == rhs ) return;
        root = merge( root, rhs.root );
        rhs.root = null;
    }
    
    public boolean contains(K key) {
    	return get(key) != null;
    }
    
	public K get(K key) {
		Node node = getNode(root, key);
		return (node != null)? node.key : null;
	}
	
	private Node getNode(Node r, K key) {
		if (r == null) return null;
		int cmp = key.compareTo(r.key);
		if (cmp < 0) return getNode(r.left, key);
		if (cmp > 0) return getNode(r.right, key);
		return r;
	}
    
    public int size() {
    	return size(root);
    }
    
    private int size(Node r) {
    	if(r == null) return 0;
    	return size(r.left) + size(r.right) + 1; 
    }
    
    public K findMin() {
        if(this.isEmpty()) return null;
        return root.key;
    }
    
    public K remove(){
        K aux = root.key;
        root = merge(root.left, root.right);
        return aux;
    }
    
    public K deleteMin( ){
    	if( isEmpty( ) ) return null;
        K minItem = root.key;
        root = merge( root.left, root.right );
        return minItem;
    }
	
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node r){
        if (r != null){
            inorder(r.left);
            System.out.print(r.key +" ");
            inorder(r.right);
        }
    }
    
	public static void main(String[] arg) {
		
		LeftistHeap<Integer> arv = new LeftistHeap<>();
		
		arv.insert(2);
		arv.insert(1);
		arv.insert(3);
		arv.inorder();
		System.out.println();
		System.out.println();
		System.out.println("Quantidade: " + arv.size());
		System.out.println();
		System.out.println("Buscar: "  + arv.get(1) );
		System.out.println();
		System.out.println("FindMin(): "+ arv.findMin());
		System.out.println();
		System.out.println("DeleteMin(): "+ arv.deleteMin());
		System.out.println();
		System.out.println("FindMin(): "+ arv.findMin());
		System.out.println();
		arv.inorder();
	}
}
