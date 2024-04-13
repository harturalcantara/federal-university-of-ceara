package br.crateus.ufc.testePadroes1;

public abstract class Pessoa {
	private String nome;
	
	Pessoa(String nome){
		this.nome = nome;
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String toString(){
		return " " + this.nome;
	}
	
	public abstract boolean validarDocumento();
	public abstract int calcularIdade();
}
