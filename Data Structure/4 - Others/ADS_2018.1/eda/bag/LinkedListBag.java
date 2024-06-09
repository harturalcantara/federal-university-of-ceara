package br.ufc.crateus.eda.bag;

import java.util.Iterator;

public class LinkedListBag<E> extends AbstractListBag<E> {
	
	private class Node {
		E element;
		Node next;
		
		Node(E elem, Node next){
			this.element = elem;
			this.next = next;
		}
	}
	
	private Node list;
	
	@Override /** Okay */
	public void add(E e) {
		if(e == null) return;
		list = new Node(e, list);
	}
	
	@Override /** Okay */
	public boolean contains(E o) {
		
		if(o == null) return false;
		
		Node aux = list;
		while(aux != null) {
			if(aux.element.equals(o)) return true;
			aux = aux.next;
		}
		return false;
	}
	
	@Override /** Okay */
	public int indexOf(E elem) {
		 
		if(elem == null) return -1;
		
		int count = 0;
		if( list.element.equals(elem) )
			return count;
		
		Node aux = list;
		while(aux.next  != null) {
			if(aux.element.equals(elem))
				return count;
			
			count++;
			aux = aux.next;
		}
		return -1;
	}
	
	@Override /** Okay */ 
	public int lastIndexOf(E o) {	
		Node aux = list;
		int i=0, x = -1;
		
		while(aux != null) {
			if(aux.element.equals(o)) 
				x = i;
			
			i++;
			aux = aux.next;
		}
		return x;
	}
	
	@Override /** Okay */
	public boolean isEmpty() {
		return list == null;
	}

	@Override /** Okay */ 
	public int size() {
		int cont = 0;
		Node aux = list;
		while(aux != null) {
			cont++;
			aux = aux.next;
		}
		return cont;
	}

	@Override /** Okay */
	public E set(int index, E element) {
		
		if(element == null) return null;
		
		int i=0;
		for(Node p = list; p != null; p = p.next) {			
			if(i == index) {
				p.element = element;
				return p.element;
			}
			i++;
		}
		return null;
	}
	
	@Override /** Okay */
	public void remove(E elem) {
		
		if(elem == null) return;
		
		if(list.element.equals(elem)) {
			list = list.next;
			return;
		}
	
		Node aux;
		for( aux = list; aux != null ; aux = aux.next) {
			if(aux.next.element.equals(elem) ) {
				aux.next = aux.next.next;
				break;
			}
		}
		
	}
	
	public void imprimir() { /** Support */
		Node aux = list;
		int cont=0;
		while(aux != null) {
			System.out.println("Ind["+cont+"]" + " - " +  aux.element);
			cont++;
			
			aux = aux.next;
		}
	}
	
	@Override /** Okay */
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			
			Node aux = list;

			@Override
			public boolean hasNext() {
				return aux != null;
			}

			@Override
			public E next() {
				E element = aux.element;
				aux = aux.next;
				return element;
			}
		};
	}

	@Override /** Okay */
	public E remove(int index) {
		
		if(index >= size() ) return null;
		
		if(index == 0) {
			E value = list.element;
			list = list.next;
			return value;
		}
		
		Node aux = list;
		E value;
		int acc = 1;
		while (aux.next != null) {
			if(acc == index) {
				value = aux.next.element;
				aux.next = aux.next.next;
				return value;
			}
			acc++;
		}
		
		return null;
	}
	
	
	
	
	
	/*
	public void elements() { //this ?
		for(E e: this) {
			System.out.println(e);
		}
	}*/
	
	@Override /** Okay */ 
	public AbstractListBag<E> subList(int fromIndex, int toIndex) {
		
		AbstractListBag <E> arrayAux =  new ArrayListBag <>( toIndex - fromIndex);
		
		Node aux = list;
		while(aux != null) {
			arrayAux.add(aux.element);
			aux = aux.next;
		}
		return arrayAux;
	}

}
