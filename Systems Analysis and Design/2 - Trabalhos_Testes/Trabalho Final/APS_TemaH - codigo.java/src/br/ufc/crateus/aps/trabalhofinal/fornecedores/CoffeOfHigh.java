package br.ufc.crateus.aps.trabalhofinal.fornecedores;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.aps.trabalhofinal.coffes.Coffee;
import br.ufc.crateus.aps.trabalhofinal.coffes.FrenchPressCoffee;

public class CoffeOfHigh extends CoffeOfProviders {

	private static ArrayList<Coffee> coffes;

	static {
		/* pequena lista de tipos de cafe que um fornecedor tem */
		coffes = new ArrayList<>();
		coffes.add(new FrenchPressCoffee("French Press Coffee", 10));
		coffes.add(new FrenchPressCoffee("French  Coffee", 10));
		coffes.add(new FrenchPressCoffee("French ", 10));
		coffes.add(new FrenchPressCoffee("Press Coffee", 10));

	}

	// nome do fornecedor
	public CoffeOfHigh(String nome) {
		super(nome);

	}
	public CoffeOfHigh() {
		this.nome = "Coffe Of High";
	}

	// add tipos novos de cafe
	@Override
	public void addNewCoffe(Coffee coffee) {
		coffes.add(coffee);

	}

	// Lista de cafes
	@Override
	public void ListTypeCoffe() {
		for (Coffee e : coffes) {
			System.out.println(e.getNome());
		}

	}

	public List<Coffee> getCoffee() {
	
		return coffes;
	}
	// preco total que tem em um fornecedor

	@Override
	public double total() {
		double total = 0;
		for (Coffee e : coffes) {
			total += e.totalDevendas();

		}
		return total;
	}

}
