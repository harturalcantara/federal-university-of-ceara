package br.crateus.ufc.testePadroes1;

public class App {
	public static void main(String[] args) {
		
		/* Pessoas Fisicas */
		Data data1 = new Data(22,4,2000);
		Pessoa p1 = new PessoaFisica("hartur", "000.000.000-00", data1);
		Data data2 = new Data(27,10,1999);
		Pessoa p2 = new PessoaFisica("Joao", "000.000.000-00", data2);
		
		/* Pessoas Juridicas */
		Data data3 = new Data(22,4,1998);
		Pessoa p3 = new PessoaJuridica("manel", "0000.0000.0000.000", data3);
		Data data4 = new Data(27,10,1997);
		Pessoa p4 = new PessoaJuridica("alimpio", "0000.0000.0000.000", data4);
		
		/** Inserindo*/
		ColecaoPessoa.getInstance().inserir(p1);
		ColecaoPessoa.getInstance().inserir(p2);
		ColecaoPessoa.getInstance().inserir(p3);
		ColecaoPessoa.getInstance().inserir(p4);
		
		//Colecao
		System.out.println("Colecao esta vazia? - "+ColecaoPessoa.getInstance().colecaoEstaVazia());
		System.out.println();
		
		//retornaObjeto()
		System.out.println(ColecaoPessoa.getInstance().retornaObjeto(0).toString());
		System.out.println(ColecaoPessoa.getInstance().retornaObjeto(1).toString());
		System.out.println(ColecaoPessoa.getInstance().retornaObjeto(2).toString());
		System.out.println(ColecaoPessoa.getInstance().retornaObjeto(3).toString());
		System.out.println();
		
		//pesquisar();
		System.out.println("Pessoa p1 contém - " + ColecaoPessoa.getInstance().pesquisar(p1));
		System.out.println("Pessoa p2 contém - " + ColecaoPessoa.getInstance().pesquisar(p2));		
		System.out.println("Pessoa p1 contém - " + ColecaoPessoa.getInstance().pesquisar(p3));
		System.out.println("Pessoa p2 contém - " + ColecaoPessoa.getInstance().pesquisar(p4));
		System.out.println();
		
		/**Calculando idades*/
		System.out.println(p1.calcularIdade());
		System.out.println(p2.calcularIdade());
		System.out.println(p3.calcularIdade());
		System.out.println(p4.calcularIdade());
		

		/*Imprimindo as pessoas.*/
		ColecaoPessoa.getInstance().imprimirDados();
		
	}

}
