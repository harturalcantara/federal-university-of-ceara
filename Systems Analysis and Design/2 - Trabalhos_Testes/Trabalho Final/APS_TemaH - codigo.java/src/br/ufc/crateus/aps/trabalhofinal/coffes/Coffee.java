package br.ufc.crateus.aps.trabalhofinal.coffes;
/*cafe implementa a interface cafeMethods
 *  la onde esta os metodos que vao ser usados*/

public abstract class Coffee implements CoffeeMethods {


	protected double preco;
	protected String nome;

	public Coffee() {

	}

	public Coffee(String nome, double preco) {
		this.preco = preco;
		this.nome = nome;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public String getNome() {
		return nome;
	}

	public abstract Coffee clone();

	@Override
	public String toString() {
		return "Café preco : " + preco + ", nome :" + nome + "]";
	}

}
