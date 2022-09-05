package br.ufc.crateus.cadastro;

public class Menu {
	
	
	public void principal() {
	    System.out.println("\t\t\t\t\t\t\t\t\t   CADASTRO DE ALUNOS - UNIVERSIDADE FEERAL DO CEARÁ");
		System.out.println("\t\t[1] - Inserir aluno");
		System.out.println("\t\t[2] - Buscar ou atualizadar dados do aluno.");
		System.out.println("\t\t[3] - Remover aluno");
		System.out.println("\t\t[4] - Medias gerais");
		System.out.println("\t\t[5] - Informação geral do Sistema de Alunos.");
		System.out.println("\t\t[0] - Sair");
		System.out.print("\t\tDigite uma opção: ");
	}
	public void inserir() {
	    System.out.println("\n\n\t\tVocê selecionou a opção: [1] ");				
		System.out.println("\t\t[1] - Inserir Aluno de Graduacao");
		System.out.println("\t\t[2] - Inserir Aluno Pós-Graduacao");			
		System.out.println("\t\t[0] - Voltar.");
		System.out.print("\t\tDigite uma opção: ");
	}
	public void buscar() {
	    System.out.println("\n\n\t\tVoce digitou 02: ");				
		System.out.println("\t\t01 - Buscar aluno pelo nome");
		System.out.println("\t\t02 - Buscar aluno pelo curso");			
		System.out.println("\t\t00 - Voltar.");
		System.out.print("\t\tDigite uma opção: ");
	}
	public void media() {
		System.out.println("\n\n\t\t[1] - Média da Instituição.");
		System.out.println("\t\t[2] - Média dos Cursos.");
		System.out.println("\t\t[3] - Média das Turmas.");
		System.out.println("\t\t[4] - Média dos alunos de uma Turma.");
		System.out.println("\t\t[0] - Voltar.");
		System.out.print("\t\tDigite uma opção: ");
	}
	
	
	public void nota(){
		 System.out.println("\n\n\t\t[1] - Nota 01");
		 System.out.println("\t\t[2] - Nota 02");
		 System.out.println("\t\t[3] - Nota 03");
		 System.out.println("\t\t[0] - Voltar.");
		 System.out.print("\t\tDigite o numero da nota que deseja alterar: ");
	}
	public void atualizar() {
		 System.out.println("\n\n\t\tEscolha o dado que deseja atualizar:");
		 System.out.println("\t\t[1]  - Atualizar nome");
		 System.out.println("\t\t[2] - Atualizar data de nascimento");
		 System.out.println("\t\t[3] - Atualizar endereço");
		 System.out.println("\t\t[4] - Atualizar CPF");
		 System.out.println("\t\t[5] - Atualizar RG");
		 System.out.println("\t\t[6] - Atualizar matricula");
		 System.out.println("\t\t[7] - Atualizar notas");
		 System.out.println("\t\t[0] - Sair");
		 System.out.print("\t\tDigite uma opção: ");
	}
	
}
