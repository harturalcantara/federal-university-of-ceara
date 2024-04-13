package br.ufc.crateus.aps.trabalhofinal.fornecedores;

import java.util.List;

import br.ufc.crateus.aps.trabalhofinal.coffes.Coffee;

public class DecoratorTypeCoffeOfHigh extends DecoratorProvidersCoffee{

	private CoffeOfProviders providers;
	//decorator
	public DecoratorTypeCoffeOfHigh(CoffeOfProviders providers) {
			this.providers = providers;
	}
	@Override
	public void addNewCoffe(Coffee coffee) {
		providers.addNewCoffe(coffee);
			
	}

	@Override
	public void ListTypeCoffe() {
		providers.ListTypeCoffe();
		
	}

	@Override
	public double total() {
		
		return .70+providers.total();
	}

	@Override
	public String getNome() {
		return providers.getNome()+" , Decorator Coffe of High";
	}
	@Override
	public List<Coffee> getCoffee() {
		// TODO Auto-generated method stub
		return providers.getCoffee();
	}

}
