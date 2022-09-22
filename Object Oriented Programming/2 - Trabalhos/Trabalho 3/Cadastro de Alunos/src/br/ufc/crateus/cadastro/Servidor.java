package br.ufc.crateus.cadastro;

public interface Servidor{

	double media();
	Aluno busca(String nome);
	int remover(String nome);
	
}