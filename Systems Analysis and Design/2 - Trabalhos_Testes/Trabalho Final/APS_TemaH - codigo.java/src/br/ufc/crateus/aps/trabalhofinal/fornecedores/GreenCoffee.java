package br.ufc.crateus.aps.trabalhofinal.fornecedores;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.aps.trabalhofinal.coffes.Coffee;
import br.ufc.crateus.aps.trabalhofinal.coffes.FrenchPressCoffee;

public class GreenCoffee extends CoffeOfProviders {
	private static ArrayList<Coffee> coffes;

	static {
		coffes = new ArrayList<>(20);
		coffes.add(new FrenchPressCoffee("French Press Coffee", 10));
		coffes.add(new FrenchPressCoffee("French  Coffee", 10));
		coffes.add(new FrenchPressCoffee("French ", 10));
		coffes.add(new FrenchPressCoffee("Press Coffee", 10));

	}

	public GreenCoffee(String nome) {
		super(nome);
	}
	public GreenCoffee() {
		this.nome = "Green Coffee";
	}

	@Override
	public void addNewCoffe(Coffee cafe) {
		coffes.add(cafe);
				
	}

	@Override
	public void ListTypeCoffe() {
		for (Coffee e : coffes) {
			System.out.println(e.getNome());
		}

		
		
	}

	@Override
	public double total() {
		
		double total = 0;
		for (Coffee e : coffes) {
			total += e.totalDevendas();

		}
		return total;
	}

	@Override
	public List<Coffee> getCoffee() {

			return coffes;
		
	
	}

}
