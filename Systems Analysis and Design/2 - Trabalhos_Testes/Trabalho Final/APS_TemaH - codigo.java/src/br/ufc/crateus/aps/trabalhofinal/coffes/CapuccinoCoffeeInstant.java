package br.ufc.crateus.aps.trabalhofinal.coffes;

public class CapuccinoCoffeeInstant extends Coffee {
	
	//modelo prototype
	public  CapuccinoCoffeeInstant(CapuccinoCoffeeInstant capuccinocoffeinstant) {
		this.nome = capuccinocoffeinstant.getNome();
		this.preco = capuccinocoffeinstant.getPreco();
	
	}
	 public CapuccinoCoffeeInstant(String nome,double preco) {
		 super(nome, preco);
	 }

	@Override
	public void imprimir() {
		System.out.println("Nome : "+getNome()+"\npreço : "+getPreco());		
		
	}

	@Override
	public double totalDevendas() {
		return .21*getPreco();
	}

	@Override
	public Coffee clone() {
		
		return new CapuccinoCoffeeInstant(this);
	}

}
