package br.ufc.crateus.eda.bag;

public abstract class AbstractListBag<E> implements Bag<E> {
	
	/** Return the first occurrence in the element */
	public abstract int indexOf(E o);
	
	/** Return the last occurrence of element */
	public abstract int lastIndexOf(E o);
	
	/** Remove the element and return */
	public abstract E remove(int index);
	
	/** Search the index, and change the element */
	public abstract E set(int index, E element);
	
	/** Return a subList of elements */
	public abstract AbstractListBag<E> subList(int fromIndex, int toIndex);
	
	/** Support */
	public abstract void imprimir();
	
	
	@Override /** Okay */
	public void addAll(Bag<E> bag) {
		for (E e : bag) {
			this.add(e);
		}
	}
	
	@Override /** Okay */
	public boolean containsAll(Bag<E> bag) {
		for (E e : bag) {
			if (!this.contains(e)) 
				return false;
		}
		return true;
	}
	
	@Override
	public void removeAll(Bag<E> bag) {
		for (E e : bag) {
			this.remove(e);
		}
	}
	
	@Override
	public void retainAll(Bag<E> bag) {
		for (E e : this) {
			if (!bag.contains(e)) this.remove(e);
		}
	}
	
	@Override
	public void clear() {
		this.removeAll(this);
	}
	
	
	
	

	
}
