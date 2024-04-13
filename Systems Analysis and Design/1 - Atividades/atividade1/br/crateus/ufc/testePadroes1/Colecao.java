package br.crateus.ufc.testePadroes1;

public interface Colecao {
	
	boolean inserir(Pessoa p); /**Passado a pessoa, inserir a pessoa.*/
	
	boolean remover(); /**Remove uma pessoa recentemente inserida*/
	
	boolean remover(int index); /** Remove a pessoa passada o indice.*/
	
	void atualizar(int index, Pessoa p); /** Atualiza a pessoa pelo indice passado.*/
	
	boolean pesquisar(Pessoa p); /** Verifica se a pessoa está contida no vetor. */
	
	boolean colecaoEstaVazia(); /** Verifica se a colecao de pessoas está vazia.*/
	
	void imprimirDados(); /**Imprime a colecao de pessoas. */
	
	Pessoa retornaObjeto(int index); /**Retorna uma pessoa passado o indice. */
}
