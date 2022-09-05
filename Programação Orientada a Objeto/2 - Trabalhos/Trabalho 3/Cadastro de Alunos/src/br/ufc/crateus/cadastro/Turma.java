package br.ufc.crateus.cadastro;

import java.util.ArrayList;

public class Turma implements Servidor{
	
	/*ATRIBUTOS*/
	private String numeroDaTurma;
	private ArrayList<Aluno> arrayAluno = new ArrayList<Aluno>();
	private ArrayList<Professor> arrayProf = new ArrayList<Professor>();
	private Disciplina disciplina;
	
	
	public Turma(String numeroDaTurma, Disciplina newDisciplina){
		this.numeroDaTurma = numeroDaTurma;
		this.setDisciplina(newDisciplina);
	}

	/*MÉTODOS OPERACIONAIS*/
	public void adicionarAluno(Aluno aluno){
		this.arrayAluno.add(aluno);
	}
	
	public void adicionarProfessor(Professor prof){
		this.arrayProf.add(prof);
	}
	
	public String gravarNoArquivo() {
		String print = "";
		for(int i = 0; i<arrayAluno.size(); i++) {
			print += numeroDaTurma + ";" + arrayAluno.get(i).gravarNoArquivo() + "\r\n";
		}
		return print;
	}
	
	@Override
	public Aluno busca(String nome){
		for (int i=0;i<arrayAluno.size();i++) {
			if(arrayAluno.get(i).getNome().equals(nome)){
				return arrayAluno.get(i);
			}
		}
		return null;
	}
	
	@Override
	public double media(){
		double soma = 0;
		if( arrayAluno.size() != 0) {
			for (int i = 0; i < arrayAluno.size(); i++ ){
				soma += arrayAluno.get(i).media();
			}
			return soma/arrayAluno.size();
		}
		else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "\n\t\t " + numeroDaTurma + " - Alunos:" +  arrayAluno + "\n\n" ;
	}

	@Override 
	public int remover(String nome) {
		
		for(int i = 0; i<arrayAluno.size(); i++) {
			
			if(arrayAluno.get(i).getNome().equals(nome)) {
				arrayAluno.remove(arrayAluno.get(i));
				return 1;
			}
		}
		return -1;
	}
		
	public void buscaPorCurso() {
		for(int i =0; i<arrayAluno.size(); i++) {
			arrayAluno.get(i).toString();
		}
	}
	
	/*MÉTODOS GETS E SETS*/
	public String getNumeroDaTurma() {
		return numeroDaTurma;
	}
	
	public int getTamanhoAluno() {
		return arrayAluno.size();
	}

	public void setNumeroDaTurma(String numeroDaTurma) {
		this.numeroDaTurma = numeroDaTurma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
	///TESTEs
	public double teste(int k) {
		System.out.println("Recebi no metodo:"+arrayAluno.get(k).media());
		
		return arrayAluno.get(k).media();
	}
	
	
}	