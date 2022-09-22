package br.ufc.crateus.cadastro;

import java.util.ArrayList;

public class Curso implements Servidor{

	private String nome;
	private ArrayList<Turma> arrayTurma = new ArrayList<Turma>();


	public Curso(String nome){
		this.nome = nome;
	}

	/*MÉTODOS OPERACIONAIS*/
	
	public void adicionarTurma(Turma newTurma){
		this.arrayTurma.add(newTurma);
	}
	
	public String gravarNoArquivo() {
		String print = "";
		for(int i = 0; i<arrayTurma.size(); i++) {
			print += arrayTurma.get(i).gravarNoArquivo();
		}
		return print;
	}
	
	public void inserirNaTurma(Aluno alu, String numeroDaTurma) {
		
		for(int i = 0; i<arrayTurma.size(); i++) {
			if(arrayTurma.get(i).getNumeroDaTurma().equals(numeroDaTurma)) {
				arrayTurma.get(i).adicionarAluno(alu);
			}
		}
	}

	public void buscaPorCurso() {
		for(int i = 0; i<arrayTurma.size(); i++) {
			arrayTurma.get(i).buscaPorCurso();
		}
	}
	
	public String retornaTexto() {
		String print = "";
		for(int i=0; i< arrayTurma.size(); i++){
			print+= arrayTurma.get(i).getDisciplina().getNome() + ";" + "\r\n";
		}
		return print;
	}
	@Override
	public int remover(String nome){
			int result = 0;
			for(int i = 0;i < arrayTurma.size(); i++) {
				result = arrayTurma.get(i).remover(nome);
			}
			return result;
	}
	
	@Override
	public double media(){
		double soma = 0;
		
		int totalTurmas = arrayTurma.size();
		
		for (int i = 0; i < arrayTurma.size(); i++ ){
				soma +=arrayTurma.get(i).media();
				
		}
		return soma/totalTurmas;
	}
	
	@Override
	public Aluno busca(String nome){
		for(int i=0; i<arrayTurma.size();i++){
			if(arrayTurma.get(i).busca(nome)!=null){
				return arrayTurma.get(i).busca(nome);
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "\n\t\t" + nome + "\n"+ "\n\t\t\tTurmas:\n" + arrayTurma + "\n";
	}
	
	/*MÉTODOS GETS E SETS*/
	
	public int getTamanhoVetorTurma() {
		int result = arrayTurma.size();
		return result;
	}
	public String getNome(){
		return this.nome;
	}
	
	public Turma getTurma(int i) {
		return arrayTurma.get(i);
	}

}