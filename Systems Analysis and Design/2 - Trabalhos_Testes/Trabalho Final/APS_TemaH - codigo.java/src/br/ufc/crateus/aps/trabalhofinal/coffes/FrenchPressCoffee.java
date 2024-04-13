package br.ufc.crateus.aps.trabalhofinal.coffes;



public class FrenchPressCoffee extends Coffee {
	public FrenchPressCoffee(FrenchPressCoffee frenchPressCoffe) {
		this.nome = frenchPressCoffe.getNome();
		this.preco =  frenchPressCoffe.getPreco();
	}

	public FrenchPressCoffee(String nome, double preco) {
		super(nome, preco);
	}

	@Override
	public void imprimir() {
		System.out.println("Tipo de Café : "+getNome()+"\npreço : "+getPreco());		
	}

	@Override
	public String toString() {
		return "FrenchPressCoffee preco : " + preco + ",\n nome : " + nome + "\n";
	}

	@Override
	public double totalDevendas() {
		return getPreco();
	}

	@Override
	public Coffee clone() {
		return new FrenchPressCoffee(this);
	}
	

}
