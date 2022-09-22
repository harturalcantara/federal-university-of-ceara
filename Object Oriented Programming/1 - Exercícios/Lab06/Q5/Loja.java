class Loja {
	public static void main(String[] args){
		CadastroProdutos java = new CadastroProdutos();

		//Cd elvis = new Cd();
		Produto voltaAoMundo = new Dvd("kkkk",10,3);
		//Livro senhorAneis = new Livro)();

		java.adicionarProdutos(voltaAoMundo);

		java.imprimirProdutos();
	}

}