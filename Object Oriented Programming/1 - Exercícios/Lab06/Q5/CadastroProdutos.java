class CadastroProdutos{
	Produto produtos[] = new Produto[100];
	private int qtdProdutos=0;

	public void adicionarProdutos(Produto produto){
		produtos[qtdProdutos++] = produto;
	}



	public void imprimirProdutos(){
		for (int i=0;i<qtdProdutos;i++) {
			System.out.println(produtos[i].toString());
			
		}
	}
}