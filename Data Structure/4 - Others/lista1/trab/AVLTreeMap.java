package br.ufc.crateus.eda.lista1.trab;

public class AVLTreeMap <K extends Comparable <K>, V> extends BinarySearchTreeMap<K, V> implements OrderedMap  <K, V> {
	
	public class NodeAvl extends Node {
		int height;
 		NodeAvl(K key, V value)  {
			super( key, value );
			height = 0;
		}
    }
	
    @Override
    public void put(K key, V value) {
    	this.root = insert(this.root, key, value);
    }
    
    @SuppressWarnings("unchecked")
	private Node insert (Node r, K key , V value) {
        
    	if( r == null ) return new NodeAvl(key,value);
    	
    	int cmp = key.compareTo(r.key);
        if( cmp < 0 ) r.left = insert( r.left, key, value);
        if( cmp > 0 ) r.right = insert( r.right, key ,value);
        else r.value = value;
            
        ((NodeAvl)r).height = max(height(r.left),height(r.right))+ 1;
        
        return  balance(r);
    }
    
 
    
    @SuppressWarnings("unchecked")
	private int height( Node r ) { /*Okay*/
        return (r == null)? -1 : ((NodeAvl)r).height;
    }
   
    private int getFactor (Node r) {
        return(r == null)? 0 :  height(r.left ) - height(r.right );
    }
    
    @SuppressWarnings("unchecked")
    public Node balance (Node t) {
    	
    	if (getFactor(t) > 1 ) {	
    		if (getFactor(t.left) < 0) {
                	t.left = leftRotation(t.left);
             } 
             t = rightRotation( t );
    	} 
        if ( getFactor(t) < -1) {
           if ( getFactor(t.right)  > 0 ) { 
        	   t.right = rightRotation( t.right);
           }
           t = leftRotation( t );
        }
    	
        ((NodeAvl)t).height = max(height ( t.left ), height( t.right )) + 1;
        return t;
    }
	
    private int max( int esq, int dir ) {
        return esq > dir ? esq : dir;
    }
    
    @SuppressWarnings("unchecked")
    private Node rightRotation( Node r ) {
    	Node t = r.left;
        r.left = t.right;
        t.right = r;
        ((NodeAvl)r).height = Math.max( height( r.left) , height( r.right ) ) + 1;
        ((NodeAvl)t).height = Math.max( height( t.left) , height( t.right ) ) + 1;
        return t;
    }
    
    /** Rotação simples à esquerda */
    @SuppressWarnings("unchecked")
    private Node leftRotation(Node t) {
    	Node r = t.right;
        t.right = r.left;
        r.left = t;
        ((NodeAvl)r).height = max( height(r.left) , height( r.right) ) + 1;
        ((NodeAvl)t).height = max( height(t.left) , height( t.right) ) + 1;
        
        return r;
    }
    
    @SuppressWarnings("unchecked")
	private Node deleteNode(Node r, K  key) {
		
		if (r == null) return null;
		int cmp = key.compareTo(r.key); 
		
		if (cmp < 0) r.left = deleteNode(r.left, key);
		else if (cmp > 0) r.right = deleteNode(r.right, key);
		else {
			if (r.left == null) return r.right;
			if (r.right == null) return r.left;
			
			Node t = r;
			r = maxNode(r.left);
			r.left = deleteMax(t.left);
			r.right = t.right;
			
		}
		((NodeAvl)r).height = Math.max( height ( r.left ), height( r.right ))  + 1;
		return balance(r);
	}
	
    /**Deleta um nó, buscando pela key de entrada.*/
	//@Override
	public void delete(K key) {
			this.root = deleteNode(this.root, key);
	}
	
	/**Me trás o maior nó da árvore.*/
	private Node maxNode(Node r) { /* Okay */
		if (r == null) return null;
		
		while (r.right != null) r = r.right;
		return r;
	}
	
	private Node deleteMin(Node r) {
		
		if (r == null) return null;
		if (r.left == null) return  r.right;
		r.left = deleteMin(r.left);
		
		return balance(r);
	}
	
	//@Override
	public void deleteMin() {
		this.root = deleteMin(this.root);
	}
	
	
	private Node deleteMax(Node r) { /* Okay */
		if (r == null) return null;
		if (r.right == null) return r.left;
		r.right = deleteMax(r.right);
		
		return balance(r);
	}
	
	/** Deleta o maior elemento da tree.*/
	//@Override 
	public void deleteMax() {
		this.root = deleteMax(this.root);
	}
	
	/**Me auxilia a enxergar muito melhor minha estrutura da árvore.*/
	public void imprimirArv() {
		imprimirArv(this.root);
	}
	
	
	private void imprimirArv (Node r) {
		if (r == null) {
		} else {
				System.out.print(r.key);
				System.out.print("(");
				imprimirArv( r.left);
				imprimirArv( r.right);
				System.out.print(") ");
		   }
	}
	
	/**Relatorio da classe AVLTreeMap*/
	/* Como a arvore AVL herda de da BST, basta implementarmos os metodos put(), delete() (max e min), pois
	 * os outros metodos se aplicam a AVL, o metodo put() e delete() precisam do metodo de balance,
	 * esse metodo ira manter as propriedades da AVL, atraves de devidas rotacoes ira manter seu balanceamento.
	 */
}