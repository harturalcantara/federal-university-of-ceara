class Cd extends Produto{
	private int faixas;


	public Cd(String nome, double preco, int codigoBarra,int faixas){
		super(nome,preco, codigoBarra);
		this.faixas = faixas;
	}

	

	@Override
	public String toString(){
		return "Nome:"+ nome + "Preco:"+ preco + "Faixas:" + faixas;
	}
}
