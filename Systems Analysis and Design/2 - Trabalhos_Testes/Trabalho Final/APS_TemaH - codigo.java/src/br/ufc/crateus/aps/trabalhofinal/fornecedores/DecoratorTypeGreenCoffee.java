package br.ufc.crateus.aps.trabalhofinal.fornecedores;

import java.util.List;

import br.ufc.crateus.aps.trabalhofinal.coffes.Coffee;

public class DecoratorTypeGreenCoffee extends DecoratorProvidersCoffee {

	private CoffeOfProviders fornecedor;
	public DecoratorTypeGreenCoffee(CoffeOfProviders fornecedor) {
		this.fornecedor = fornecedor;
		
	}
	
	@Override
	public void addNewCoffe(Coffee coffee) {
				fornecedor.addNewCoffe(coffee);
	}

	@Override
	public void ListTypeCoffe() {
		fornecedor.ListTypeCoffe();		
	}

	
	@Override
	public double total() {
		
		return .30+fornecedor.total();
	}

	@Override
	public String getNome() {
			return fornecedor.getNome()+" , Green Coffe";
	}

	@Override
	public List<Coffee> getCoffee() {
		// TODO Auto-generated method stub
		return fornecedor.getCoffee();
	}

}
