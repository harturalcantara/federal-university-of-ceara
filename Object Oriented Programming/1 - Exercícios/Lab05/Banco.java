class Banco {


	Conta array[] = new Conta[50];
	private int qtdContas=0;



	public void adiciona(Conta c){
		array[qtdContas++] = c;
	}
	public Conta getConta(int x){
		return array[x];
	}

	public int getQuantidadeDeContas(){
		return qtdContas;
	}

}