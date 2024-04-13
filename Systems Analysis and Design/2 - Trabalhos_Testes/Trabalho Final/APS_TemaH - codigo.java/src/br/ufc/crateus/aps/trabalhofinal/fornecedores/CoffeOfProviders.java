package br.ufc.crateus.aps.trabalhofinal.fornecedores;

import java.util.List;

import br.ufc.crateus.aps.trabalhofinal.coffes.Coffee;



/*essa classe implementa fornecedores pq la onde 
 * fica alguns metodos e todos os tipos de forneceodres extends ela*/

public abstract class CoffeOfProviders implements Providers {

	protected String nome = "UNKNOW";

	public CoffeOfProviders(String nome) {
		this.nome = nome;
	}

	public CoffeOfProviders() {
		
	}

	public String getNome() {
		return nome;
	}

	public abstract double total();
	public abstract List<Coffee> getCoffee();

}
