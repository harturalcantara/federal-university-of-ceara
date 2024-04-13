package br.ufc.crateus.aps.trabalhofinal.Iterator;

public interface Collection<E> {
	void add(E e);
	void remove(String e);
	void searchOfPrefix(String nome);
	void search(String nome);
	void update(E e);
	void show();
}
