package aps_questao4;

public class ColecaoPessoa implements Iteravel, Colecao {
	private Pessoa []dados = new Pessoa[10];
	private	int pCorrente=0;
	int posicaoIteracao=0;
	
	@Override
	public void add(Object p) {
		dados[pCorrente++] = (Pessoa) p;
	}
	
	@Override
	public Object next() {
		Pessoa p = dados[posicaoIteracao];
		posicaoIteracao++;
		return p;
	}
	
	@Override
	public boolean hasNext() {
		
		if (posicaoIteracao >= dados.length || dados[posicaoIteracao] == null) {
			this.posicaoIteracao = 0;
			return false;
		} else {
			return true;
		}
		
	}
	
}
