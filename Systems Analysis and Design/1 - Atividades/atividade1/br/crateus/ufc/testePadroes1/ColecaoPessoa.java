package br.crateus.ufc.testePadroes1;


public class ColecaoPessoa implements Colecao {
	private Pessoa []dados = new Pessoa[100];
	private	int pCorrente=0;
	
	private static final ColecaoPessoa colecao = new ColecaoPessoa();
	public static ColecaoPessoa getInstance() {
		return colecao;
	}
	private ColecaoPessoa() {}
	
	@Override
	public boolean inserir(Pessoa p) {
		if(p != null) {
			dados[pCorrente++] = p;
			return true;
		} 
		return false;
	}

	@Override
	public boolean remover() {
		dados[pCorrente-1] = null;
		pCorrente--;
		return true;
	}

	@Override //verificar
	public boolean remover(int index) {
		if(index < 0) return false;
		
		int i;
		for(i=index; i<pCorrente; i++)
			dados[i] = dados[i+1];
		
		dados[i] = null;
		pCorrente--;
		return true;
	}

	@Override
	public void atualizar(int index, Pessoa p) {
		if(index < pCorrente  && index < 0) return;
			dados[index] = p;
	}

	@Override
	public boolean pesquisar(Pessoa p) {
		for(int i=0; i< pCorrente; i++)
			if(dados[i].equals(p))
				return true;
		return false;
	}

	@Override
	public boolean colecaoEstaVazia() {
		return pCorrente == 0;
	}

	@Override
	public void imprimirDados() {
		for(int i=0; i< pCorrente; i++)
			System.out.println(dados[i].toString());
	}

	@Override
	public Pessoa retornaObjeto(int index) {
		if(index < 0 || index > pCorrente) return null;
		return dados[index];
	}

	public int getPosicaoCorrente() {
		return pCorrente;
	}

	public void setPosicaoCorrente(int posicaoCorrente) {
		this.pCorrente = posicaoCorrente;
	}
	
	
}
