package br.ufc.crateus.aps.trabalhofinal;

import java.util.Arrays;
import br.ufc.crateus.aps.trabalhofinal.Iterator.Collection;
import br.ufc.crateus.aps.trabalhofinal.Iterator.Iterator;
import br.ufc.crateus.aps.trabalhofinal.Iterator.Tst;

import br.ufc.crateus.aps.trabalhofinal.coffes.Coffee;

/*essa classe implementa um iterator e uma colecao generica com os metodos add,search,update,remove e show*/
public class ColecaoDeFraquias<E> implements Iterator<E>, Collection<E> {

	public FranquiaDeCafe[] franquia;
	private int cont = 0;

	public ColecaoDeFraquias(int tam) {
		cont = 0;
		franquia = new FranquiaDeCafe[tam];
	}

	@Override
	public void add(E e) {
		franquia[cont++] = (FranquiaDeCafe) e;
	}

	@Override
	public void remove(String e) {
			int j = getSearch(e);
			if(j == cont) {
				franquia[cont] = null;
				cont--;
			}
			else if (j >= 0) {
				
				for (int i = j; i <cont-1; i++) {
					 
						franquia[i] = franquia[i + 1];
	
				}
				franquia[cont] = null;
				cont--;
				System.out.println("FRANQUIA REMOVIDA COM SUCESSO!");
			}
			else if(j == -1)
				System.out.println("NAO EXISTE ESSE FRANQUIA EM NOSSA COLECAO!");
	}

	public int getSearch(String nome) {
		for (int i = 0; i < cont; i++) {
			if (franquia[i].getNomeFantasia().equals(nome)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void searchOfPrefix(String nome) {
		System.out.println("****Busca por prefixo de cafes*****");
		for (int i = 0; i < cont; i++) {
			for (Coffee e : franquia[i].getTiposDeCafe()) {
				Tst<Coffee> cafe = new Tst<Coffee>();
				cafe.put(e.getNome(), e);

				for (String key : cafe.keysWithPrefix(nome)) {
					System.out.println(key);
				}
				System.out.println("-----------------------------");

			}
		}

	}

	@Override
	public void search(String nome) {
		for (int i = 0; i < cont; i++) {
			for (Coffee e : franquia[i].getTiposDeCafe()) {
				System.out.println(e.getNome().equals(nome));
				if (e.getNome().equals(nome)) {
					System.out.println(e.getNome());
					break;
				}
			}
		}
	}

	@Override
	public void update(E e) {
		
		
		
		
	}

	@Override
	public void show() {
		for (int i = 0; i < cont; i++) {
			franquia[i].imprimir();
			for (Coffee e : franquia[i].getTiposDeCafe()) {
				e.imprimir();
			}
			System.out.println("Fornecedor : " + franquia[i].getFornecedores().getNome());
			franquia[i].getDonos().imprimir();
			if(franquia[i].getFidelizacao() != null) {
			franquia[i].getFidelizacao().funcionariosEClientes();
			franquia[i].getFidelizacao().Acao();
			break;
			}
			

		}

	}

	@Override
	public String toString() {
		return "ColecaoDeFraquias [franquia=" + Arrays.toString(franquia) + ", cont=" + cont + "]";
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		return ((E) franquia[--cont]);
	}

	@Override
	public boolean hasNext() {
		return cont > 0;
	}

}
