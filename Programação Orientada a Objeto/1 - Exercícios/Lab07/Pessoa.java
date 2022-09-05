abstract class Pessoa implements Imprimivel{
	protected String nome;
	protected Data nascimento;


	public String getNome(){
		return this.nome;
	}

	public String getData(){
		return this.nascimento.formatar();
	}
	public Pessoa(String nome, Data nascimento){
		this.nome = nome;
		this.nascimento = nascimento;
	}
	@Override
	public void imprimeDados(){
		System.out.println("Nome:"+ nome);
		System.out.println("Data de nascimento: "+ nascimento.formatar());
	}

} 