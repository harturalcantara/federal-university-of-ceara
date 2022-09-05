class TestaCadastro{
	public static void main(String[] args){

		CadastroPessoas bancoPessoa = new CadastroPessoas();

		Data nascPessoa1 = new Data(05,06,2000);
		Pessoa pessoa1 = new Cliente("hartur ", nascPessoa1, 1010);

		pessoa1.imprimeDados();

		System.out.println();

		Data nascPessoa2 = new Data(01,10,1998);
		Pessoa pessoa2 = new Funcionario("Alimpio", nascPessoa2, 10000);
		pessoa2.imprimeDados();

		System.out.println();

		Data nascPessoa3 = new Data(01,10,1998);
		Pessoa pessoa3 = new Gerente("Joao Vitor", nascPessoa3, 10000, "Dormir");
		pessoa3.imprimeDados();

		System.out.println();

		/*Adicionando pessoas no Vetor*/
		bancoPessoa.cadastraPessoa(pessoa1);
		bancoPessoa.cadastraPessoa(pessoa2);
		bancoPessoa.cadastraPessoa(pessoa3);
		/*Imprimindo o Vetor*/
		System.out.println("\tImprimindo o que está no Vetor!");
		bancoPessoa.imprimeCadastro();
		/*ToString Referencias*/
		System.out.println("\ttoStrings da Classes:");
		System.out.println(pessoa1);
		System.out.println(pessoa2);
		System.out.println(pessoa3);
		System.out.println(bancoPessoa);

		System.out.println("\tEquals da Classes:");
		Pessoa pessoa1aux = new Cliente("hartur ", nascPessoa1, 101);
		System.out.println(pessoa1.equals(pessoa1aux));

		Pessoa pessoa2aux = new Funcionario("Alimpio", nascPessoa2, 1000);
		System.out.println(pessoa2.equals(pessoa2aux));


		Pessoa pessoa3aux = new Gerente("Joao Vitor", nascPessoa3, 10000, "Dormirr");
		System.out.println(pessoa3.equals(pessoa3aux));


		CadastroPessoas bancoPessoaAux = new CadastroPessoas();
		bancoPessoaAux.cadastraPessoa(pessoa1);
		bancoPessoaAux.cadastraPessoa(pessoa2);
		bancoPessoaAux.cadastraPessoa(pessoa3);
		//bancoPessoaAux.setQtdAtual(3);
		System.out.println(bancoPessoa.equals(bancoPessoaAux));



	}
}