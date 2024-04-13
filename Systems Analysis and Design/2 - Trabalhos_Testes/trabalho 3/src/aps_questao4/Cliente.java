package aps_questao4;

public class Cliente{

	public static void main(String a[]){
		
		ColecaoPessoa colecao = new ColecaoPessoa();
		colecao.add(new PessoaFisica("hartur","000.000.000-00"));
		colecao.add(new PessoaFisica("hartur","000.000.000-00"));
		colecao.add(new PessoaFisica("hartur","000.000.000-00"));
		
		
		while(colecao.hasNext()){
			System.out.println(colecao.next());
		}
		
	}
	
	/** Padrão de projeto Decorator
	 * Seguindo o mesmo modelo passado como exemplo, foi aplicado o padrão de projeto Decorator
	 * formas geometricas, criados todos os objetos do geometricos, cada objeto vai ter um compo-
	 * nente, o quadrado inicialmente tem impressora como seu componente, o retagunlo tem o quadra-
	 * do, o triangulo o retangulo, e por fim mando os dados para serem feitos o calculo da base e
	 * altura. Desse forma, como um escadinha ele irá imprimindo as operações de cada forma geometri-
	 * ca. 
	 * */
	
}
