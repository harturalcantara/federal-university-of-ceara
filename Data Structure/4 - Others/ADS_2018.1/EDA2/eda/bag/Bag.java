package br.ufc.crateus.eda.bag;

public interface Bag<E> extends Iterable<E>{
	
	/** Add a element */
	void add(E e);
	
	/** Add all the elements in the collection specific */
	void addAll(Bag<E> c);
	
	/** Apaga all the elements in the collection */
	void clear();
	
	/** Return true, if contains the element, else false*/
	boolean contains(E o);
	
	/**VER SE A COLECAOO CONTEM TODOS OS ELEMENTOS*/
	boolean containsAll(Bag<E> c);
	
	/** VERIFICA SE ESTÁ VAZIO*/
	boolean isEmpty();
	
	/**Dado o element, Remove the element in the collection.*/
	void remove(E e);
	
	/** Remove the all elements */ 
	void removeAll(Bag<E> c);
	
	/** Return the all elements */ 
	void retainAll(Bag<E> c);
	
	/**Return the length*/
	int size();
	
}
