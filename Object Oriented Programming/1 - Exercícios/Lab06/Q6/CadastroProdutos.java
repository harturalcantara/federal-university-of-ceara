class CadastroProdutos{
	Produto produtos[] = new Produto[100];
	private int qtdProdutos=0;

	public void adicionarProdutos(Produto produto){
		produtos[qtdProdutos++] = produto;
	}

	public Produto[] getProduto(){
		return produtos;
	}

	public int getQtdProdutos(){
		return qtdProdutos;
	}


	public void imprimirProdutos(){
		for (int i=0;i<qtdProdutos;i++) {
			System.out.println(produtos[i].toString());
		}
	}

	@Override
	public boolean equals(Object o){
		for (int i=0;i<qtdProdutos;i++) {
			if(o instanceof Dvd ){
				Dvd p = (Dvd) o;
				return produtos[i].codigoBarra == p.codigoBarra;
			}

			else if(o instanceof Cd ){
				Cd p = (Cd) o;
				return produtos[i].codigoBarra == p.codigoBarra;
			}
			else if(o instanceof Livro ){
				Livro p = (Livro) o;
				return produtos[i].codigoBarra == p.codigoBarra;
			}
		}

		return false;
	}

	/* Desnecessario Isso aqui
	public int buscar(Produto obj){
		for(int i=0;i<qtdProdutos;i++){

			if(obj instanceof Dvd ){
				Dvd p = (Dvd) obj;
				if(produtos[i].codigoBarra == p.codigoBarra){
					return i;
				}
			}

			else if(obj instanceof Cd ){
				Cd p = (Cd) obj;
				if(produtos[i].codigoBarra == p.codigoBarra){
					return i;
				}
			}

			else if(obj instanceof Livro ){
				Livro p = (Livro) obj;
				if(produtos[i]	.codigoBarra == p.codigoBarra){
					return i;
				}
			}
		}
			System.out.println("Produto nao Encontrado!");
			return -1;
	}
	*/
}