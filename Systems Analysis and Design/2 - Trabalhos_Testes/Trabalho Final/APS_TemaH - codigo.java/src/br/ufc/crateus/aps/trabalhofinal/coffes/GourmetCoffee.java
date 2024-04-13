package br.ufc.crateus.aps.trabalhofinal.coffes;

public class GourmetCoffee extends Coffee {
	

	public GourmetCoffee(GourmetCoffee gourmetCoffee) {
		this.nome = gourmetCoffee.getNome();
		this.preco = gourmetCoffee.getPreco();
		
	}

	public GourmetCoffee(String nome, double preco) {
		super(nome, preco);
	}

	@Override
	public void imprimir() {
		System.out.println("Tipo de Café : "+getNome()+"\npreço : "+getPreco());		
				
	}

	@Override
	public String toString() {
		return "GourmetCoffee preco :" + preco + ",\n nome : " + nome + "\n";
	}

	@Override
	public double totalDevendas() {
				return .34*getPreco();
	}

	@Override
	public Coffee clone() {
		
		return new GourmetCoffee(this);
	}

}
