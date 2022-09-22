package br.ufc.crateus.cadastro;

import java.util.ArrayList;

public class Instituicao implements Servidor{
	/*ATRIBUTOS*/
	private String nome;
	private ArrayList<Curso> arrayCurso = new ArrayList<Curso>();
	
	
	public Instituicao(String nome){
		this.setNome(nome);
	}
	/*MÉTODOS OPERACIONAIS*/
	
	public void adicionarCurso(Curso newCurso){
		this.arrayCurso.add(newCurso);
	}
	
	public void gravarNoArquivo(String arq, int cont) {
		String print = "" + cont + ";" + "\r\n";
		for (int i=0; i<arrayCurso.size(); i++){
			print += arrayCurso.get(i).gravarNoArquivo();
		}
		Arquivo.Write(arq, print);
	}
	
	public void instanciarAluno(String dados) {
		
		String numeroDaTurma = dados.split(";")[0];
		/*String  nome = dados.split(";")[1];
		int matricula = Integer.parseInt(dados.split(";")[2]);
		String  endereco = dados.split(";")[3];
		String cpf = dados.split(";")[4];
		String  rg = dados.split(";")[5];
		int dia = Integer.parseInt(dados.split(";")[6]);
		int mes = Integer.parseInt(dados.split(";")[7]);
		int ano = Integer.parseInt(dados.split(";")[8]);
		
		Data dataAluno = new Data(dia,mes, ano);
		Aluno alu = new Aluno(nome, dataAluno, endereco, cpf, rg, matricula, true);
		
		for(int i=0; i<arrayCurso.size(); i++) {
			arrayCurso.get(i).inserirNaTurma(alu, numeroDaTurma);
		}*/
	}
	
	public void lerDoArquivo(String dadosDoArquivo) {
		
		int qtdAlunos = Integer.parseInt(dadosDoArquivo.split(";")[0]);
		int cont = 0;
		
		String print = "";
		
		String cc1 = "2015.1", cc2 = "2015.2", si1 = "2016.1", si2 = "2016.2", cp1 = "2017.1",cp2 = "2017.2",ec1 = "2018.1", ec2 = "2018.2";
		System.out.println(qtdAlunos);
		
		for(int i = 1; i <= qtdAlunos; i++) {

			if( cc1.equals(dadosDoArquivo.split(";")[i]) || cc2.equals(dadosDoArquivo.split(";")[i]) || si1.equals(dadosDoArquivo.split(";")[i]) || si2.equals(dadosDoArquivo.split(";")[i])) {
				
				
				for(int j = 2; j < 9; i++) {
					cont++;
					print +=  dadosDoArquivo.split(";")[j];
					System.out.println(print);
					if(cont == 9) {
						instanciarAluno(print);
						cont = 0;
						print = "";
					}
				}	
			}
		}
	}
	
	@Override
	public Aluno busca(String nome){
		
		for (int i=0; i<arrayCurso.size(); i++){
			
			if(arrayCurso.get(i).busca(nome) != null) {
					return arrayCurso.get(i).busca(nome);
				}
			}
		return null;
	}
	
	@Override
	public double media(){
		double soma = 0;
		for (int i = 0; i < arrayCurso.size() ; i++ ){
				soma += arrayCurso.get(i).media();
				
		}
		return soma/arrayCurso.size();
	}
	
	@Override
	public int remover(String nome) {
		int result = 0;
		for(int i = 0; i< arrayCurso.size(); i++) {
			result = arrayCurso.get(i).remover(nome);
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "\tInstituição " + nome + " -  Cursos da Universidade:" + arrayCurso +":\n";
	}
	
	public int buscaPorCurso(String nome) {
		for(int i = 0; i<arrayCurso.size(); i++) {
			if(arrayCurso.get(i).getNome().equals(nome)) {
				arrayCurso.get(i).buscaPorCurso();
				return 1;
			}
		}
		return -1;
	}
	
	public double mediaDaTurma(String nome) {
		for (int i = 0; i < arrayCurso.size() ; i++ ){
			if(arrayCurso.get(i).getNome().equals(nome)) {
				return arrayCurso.get(i).media();
			}
		}
		return -1;
	}
	
	/*MÉTODOS GETS E SETS*/
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getTamanhoVetor() {
		int result = arrayCurso.size();
		return result;
	}
	
	public Curso getCurso(int i) {
		return arrayCurso.get(i);
	}
	
	public double mediaDoCurso(int i) {		
		return arrayCurso.get(i).media();
	}
	
	///AREA DE TESTES
	public int getCursoPosicao(String nome) {
		for(int i = 0; i<arrayCurso.size(); i++) {
			if(arrayCurso.get(i).getNome().equals(nome)) {
				return i;
			}
		}
		return -1;
	}
}


