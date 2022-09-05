package br.ufc.crateus.cadastro;

class Professor extends Integrantes{

	private double salario;
	
	public Professor(String nome, Data idade, String endereco, String cpf, String rg, double salario){
		super(nome, idade, endereco, cpf, rg);
		this.salario = salario;
	}

	public double getSalario(){
		return salario;
	}

}