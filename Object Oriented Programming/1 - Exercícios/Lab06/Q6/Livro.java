class Livro extends Produto {
	private String autor;

	public Livro(String nome, double preco, int codigoBarra, String autor){
		super(nome, preco, codigoBarra);
		this.autor = autor;
	}
	
	@Override
	public String toString(){
		return "Nome:\n"+ nome + "Preco:"+ preco +"\n"+ "Autor:" + autor+"\n";
	}
}