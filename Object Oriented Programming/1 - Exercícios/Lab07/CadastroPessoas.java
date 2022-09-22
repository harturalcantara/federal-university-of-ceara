class CadastroPessoas{
	private Pessoa pessoas[] = new Pessoa[100];
	private int qtdAtual=0;

	public void cadastraPessoa(Pessoa pessoa){
		pessoas[qtdAtual++] = pessoa;
	}


	public void imprimeCadastro(){
		for(int i=0;i<qtdAtual;i++){
			pessoas[i].imprimeDados();
			System.out.println();
		}
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof CadastroPessoas){
			CadastroPessoas p = (CadastroPessoas) o;
			return this.qtdAtual == p.qtdAtual;
		}
		return false;
	}
	/*Esse set não é nescessario, foi implementado devido a testes!*/
	public void setQtdAtual(int atual){
		this.qtdAtual = atual;
	}
	public int getQtdAtual(){
		return this.qtdAtual;
	}

	@Override
	public String toString(){
		return "CadastroPessoa" + "Quantidade de pessoas cadastradas: "+ this.qtdAtual;
	}


}
