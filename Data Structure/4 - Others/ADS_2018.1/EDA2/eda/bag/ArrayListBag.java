package br.ufc.crateus.eda.bag;

import java.util.Iterator;

public class ArrayListBag<E> extends AbstractListBag<E> {

	E []array;
	int cont = 0;
	
	
	@SuppressWarnings("unchecked")
	ArrayListBag(int count){
		this.array = (E []) new Object[count];
	}
	
	@Override /** Okay */
	public void add(E e) {
		if(e == null) return;
		array[cont++] =  e;
	}
	
	@Override /**Okay */
	public boolean contains(Object o) {
		for(int i = 0; i < cont; i++)
			if(array[i].equals(o)) 
				return true;
		return false;
	}
	
	@Override /** Okay */
	public boolean isEmpty() {
		return this.cont == 0;
	}
	
	@Override /** Okay */
	public int size() {
		return cont;
	}
	
	@Override /** Okay */
	public int indexOf(E o) {
		
		for(int i = 0; i < cont; i++)
			if(array[i].equals(o)) 
				return i;
		
		return -1;
	}
	
	@Override /** Okay */
	public int lastIndexOf(E o) {
		
		int x=0;
		for(int i = 0; i < cont; i++)
			if(array[i].equals(o)) 
				x = i;
			
		if (array[x].equals(o))
			return x;
		
		return -1;
	}
	
	@Override /** Okay */ 
	public E set(int index, E element) {
		array[index-1] = element;
		return null;
	}

	private int searchIndex(E elem) { /**Support*/
		
		for(int i=0; i < cont; i++) 
			if( array[i].equals(elem) )	
				return i;
		
		return -1;
	}
	
	@Override /** Okay */
	public void remove(E elem) {
		
		int index = searchIndex(elem);
		
		if(index >= 0) {
			int i=0;
			for ( i = index; i < size(); i++) {
				array[i] = array[i+1];
			}
			array[i] = null;
			this.cont--;
		} 
		
		return;
	}

	@Override /** Okay */
	public E remove(int index) {
		
		if( (index) > cont) return null;
		
		E aux = array[index];
		int i;
		
		for( i = index; i < cont; i++) 
			array[i] = array[i+1];
		
		array[i] = null;
		cont--;
		return aux;
	}
	
	@Override /** Okay */
	public Iterator<E> iterator() {
		
		return new Iterator<E>() {
			//private int i = cont;
			private int i = 0;
			@Override
			public boolean hasNext() {
				return i < size();
				//return i > cont;
			}

			@Override
			public E next() {
				return (E) array[i++];
			}
			
		};
	}
	
	@Override /** Okay */
	public void imprimir() {
		for(int i=0; i<cont ; i++)
			System.out.println("Ind["+ i +"] "+ array[i]);
	}
	
	
	
	@Override /** Okay */
	public AbstractListBag <E> subList(int fromIndex, int toIndex) {
		
		AbstractListBag <E> arrayAux =  new ArrayListBag <>( toIndex - fromIndex);
		
		for(int i = fromIndex; i < toIndex; i++)
			arrayAux.add(array[i]);
		
		return arrayAux;
		
	}	

}/**  */
