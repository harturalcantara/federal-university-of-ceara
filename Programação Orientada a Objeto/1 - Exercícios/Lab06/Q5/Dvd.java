class Dvd extends Produto{
	private int duracao;

	public Dvd(String nome, double preco, int duracao){
		super(nome,preco);
		this.duracao = duracao;
	}

	@Override
	public String toString(){
		return "Nome:"+ nome + "Preco:"+ preco + "Duracao:" + duracao;
	}



}