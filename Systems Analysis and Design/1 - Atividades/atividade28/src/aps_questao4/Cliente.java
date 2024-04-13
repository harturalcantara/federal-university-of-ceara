package aps_questao4;

public class Cliente{

	public static void main(String a[]){
		
		ColecaoPessoa colecao = new ColecaoPessoa();
		colecao.add(new PessoaFisica("hartur1","000.000.000-00"));
		colecao.add(new PessoaFisica("hartur2","000.000.000-00"));
		colecao.add(new PessoaFisica("hartur3","000.000.000-00"));
		
		
		while(colecao.hasNext()){
			System.out.println(colecao.next());
		}
		
	}
	
	/** Padrão de projeto Iterator
	 * Seguindo o mesmo modelo passado como exemplo, foi aplicado o padrão de projeto Iterator
	 * sobre pessoas, instaciados objetos na colecao, cada objeto vai ter seus proprios dados,
	 * dessa forma, o iterador ira percorrer a quantidade de pessoas que posssui na colecao, e
	 * imprimindo os dados.
	 **/
	
}
