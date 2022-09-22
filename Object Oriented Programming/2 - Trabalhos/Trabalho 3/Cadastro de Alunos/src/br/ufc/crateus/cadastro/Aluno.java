package br.ufc.crateus.cadastro;

import java.util.Arrays;

public class Aluno extends Integrantes{
	
	private int matricula;
	private boolean status;
	private double[] notas = new double[3];
	private int quantidadeDeNotas;
	
	public Aluno(String nome, Data idade, String endereco, String cpf, String rg, int matricula, boolean status){
		super(nome, idade, endereco, cpf, rg);
		this.matricula = matricula;
		this.status = status;

	}
	
	public String gravarNoArquivo() {
		
		return super.getNome() + ";" + matricula + ";" + super.getEndereco() + ";" + super.getCpf() + ";" + super.getRg() + ";" + super.getData() + ";";
		
	}
	
	@Override
	public String toString() {
		//System.out.print(super.toString());  // Não pode imprimir, solicao coloca super.(atributo) que da certo! super.getNome
		return "\n\n\t\tNome: " + super.getNome() + "\n\t\tMatricula:" + matricula + "\n\t\tStatus: " + status + "\n\t\tNotas: " + Arrays.toString(notas) + "\n\t\tMédia: " + media()+"\n";
	}

	//NAO PRECISA DESTE METODO, POIS JÁ TEM O ATUALIZAR
	
	/*ADICIONANDO NOTAS AO ALUNO*/
	public int adicionarNota(double nota){
		if(quantidadeDeNotas < 3) {
			notas[quantidadeDeNotas++] = nota;
			return 1;
		}
		return -1;
	}
	
	
	/*CALCULANDO MÉDIA DO ALUNO*/
	public double media(){
		double soma = 0;
		for(int i=0 ; i< quantidadeDeNotas; i++){
			soma += notas[i];
		}
		return soma/3;
	}
	

	/*MÉTODOS GETS E SETS*/
	
	public double getNotas(int posicao){
		return notas[posicao];
	}
	
	public void setNotas(int posicao, double nota){

		notas[posicao] = nota;
	}
		
	public void setAtivo(boolean status){
		this.status = status;
	}
	
	public boolean isAtivo(){
		return status;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}