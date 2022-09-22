package br.ufc.crateus.cadastro;

public class Menu {
	
	
	public void principal() {
	    System.out.println("\t\t\t\t\t\t\t\t\t   CADASTRO DE ALUNOS - UNIVERSIDADE FEERAL DO CEAR�");
		System.out.println("\t\t[1] - Inserir aluno");
		System.out.println("\t\t[2] - Buscar ou atualizadar dados do aluno.");
		System.out.println("\t\t[3] - Remover aluno");
		System.out.println("\t\t[4] - Medias gerais");
		System.out.println("\t\t[5] - Informa��o geral do Sistema de Alunos.");
		System.out.println("\t\t[0] - Sair");
		System.out.print("\t\tDigite uma op��o: ");
	}
	public void inserir() {
	    System.out.println("\n\n\t\tVoc� selecionou a op��o: [1] ");				
		System.out.println("\t\t[1] - Inserir Aluno de Graduacao");
		System.out.println("\t\t[2] - Inserir Aluno P�s-Graduacao");			
		System.out.println("\t\t[0] - Voltar.");
		System.out.print("\t\tDigite uma op��o: ");
	}
	public void buscar() {
	    System.out.println("\n\n\t\tVoce digitou 02: ");				
		System.out.println("\t\t01 - Buscar aluno pelo nome");
		System.out.println("\t\t02 - Buscar aluno pelo curso");			
		System.out.println("\t\t00 - Voltar.");
		System.out.print("\t\tDigite uma op��o: ");
	}
	public void media() {
		System.out.println("\n\n\t\t[1] - M�dia da Institui��o.");
		System.out.println("\t\t[2] - M�dia dos Cursos.");
		System.out.println("\t\t[3] - M�dia das Turmas.");
		System.out.println("\t\t[4] - M�dia dos alunos de uma Turma.");
		System.out.println("\t\t[0] - Voltar.");
		System.out.print("\t\tDigite uma op��o: ");
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
		 System.out.println("\t\t[3] - Atualizar endere�o");
		 System.out.println("\t\t[4] - Atualizar CPF");
		 System.out.println("\t\t[5] - Atualizar RG");
		 System.out.println("\t\t[6] - Atualizar matricula");
		 System.out.println("\t\t[7] - Atualizar notas");
		 System.out.println("\t\t[0] - Sair");
		 System.out.print("\t\tDigite uma op��o: ");
	}
	
}
