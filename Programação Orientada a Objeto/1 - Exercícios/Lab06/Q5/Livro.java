class Livro extends Produto {
	private String autor;

	public Livro(String nome, double preco, String autor){
		super(noime,preco);
		this.autor = autor;
	}
	
	@Override
	public String toString(){
		return "Nome:\n"+ nome + "Preco:"+ preco +"\n"+ "Autor:" + autor+"\n";
	}
}