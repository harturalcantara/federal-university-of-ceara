class LojaMain {

	private static int busca(Produto[] produtos, int qtdProduto, Produto obj) {
		for(int i=0;i<qtdProduto;i++){
			if(obj instanceof Dvd ){
				Dvd p = (Dvd) obj;
				if(produtos[i].codigoBarra == p.codigoBarra) return i;
			}

			else if(obj instanceof Cd ){
				Cd p = (Cd) obj;
				if(produtos[i].codigoBarra == p.codigoBarra) return i;
			}

			else if(obj instanceof Livro ){
				Livro p = (Livro) obj;
				if(produtos[i]	.codigoBarra == p.codigoBarra) return i;
			}
		}
			System.out.println("Produto nao Encontrado!"); return -1;
	}


	public static void main(String[] args){
		CadastroProdutos java = new CadastroProdutos();

		/*Produtos criados*/
		Produto dvd1 = new Dvd("Elvis",10,3,10);
		Produto cd2 = new Cd("ohMds",10,2,11);
		Produto livro3 = new Livro("Rings",10,3,"J");
		Produto livro1 = new Livro("Lord",10,2,"R.R");
		Produto livro2 = new Livro("of",10,3,"tolkien");
		
			/*Produtos que me axiliam questão 6.(d)*/
		Produto dvd3 = new Dvd("Elvis",10,3,10);
		Produto dvd4 = new Dvd("Presley",10,4,10);


		java.adicionarProdutos(dvd1);
		java.adicionarProdutos(livro2);
		java.adicionarProdutos(livro1);
		java.adicionarProdutos(livro3);
		java.adicionarProdutos(cd2);

		java.imprimirProdutos();

		/*Adicionando Produtos com 1 com mesmo código de Barra e outro Diferente!*/
		//java.adicionarProdutos(dvd3);
		//java.adicionarProdutos(dvd4);

		//java.imprimirProdutos();
		System.out.println("\tResultado das Buscas:");
		System.out.println(busca(java.getProduto(), java.getQtdProdutos(), dvd3));
		System.out.println(busca(java.getProduto(), java.getQtdProdutos(), dvd4));
		

	}
}