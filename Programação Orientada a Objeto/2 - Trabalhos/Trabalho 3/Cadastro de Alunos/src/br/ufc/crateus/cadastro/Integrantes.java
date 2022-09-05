package br.ufc.crateus.cadastro;

public abstract class Integrantes{
	/*ATRIBUTOS*/
	private String nome;
	private Data idade;
	private String endereco;
	private String cpf;
	private String rg;
	
	
	
	public Integrantes(String nome, Data idade, String endereco, String cpf, String rg){
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.cpf = cpf;
		this.rg = rg;
	}
	
	
	/*MÉTODOS OPERACIONAIS*/
	@Override
	public String toString() {
		return "\n\t\tNome: " + nome + "\n\t\tData de nascimento: " + idade.toString() + "\n\t\tEndereço: " + endereco + "\n\t\tCPF: " + cpf + "\n\t\tRG: "
				+ rg;
	}
	
	/*MÉTODOS SETS E GETS*/
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIdade(Data idade) {
		this.idade = idade;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public Data getIdade() {
		return idade;
	}


	public String getEndereco() {
		return endereco;
	}


	public String getCpf() {
		return cpf;
	}


	public String getRg() {
		return rg;
	}
	
	public String getData() {
		return idade.getDia() + ";" + idade.getMes() + ";" + idade.getAno(); 
	}
	
}