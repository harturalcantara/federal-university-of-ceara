package br.ufc.crateus.eda.lista2;

public class BuscaStringCorrigida {

//	private int hashString(String str) { // questao 3 EDA
//		return (str.hashCode() & 0x7fffffff);
//	}

	public static void main(String[] args) {

		// String texto = "casa da moeda da espanha";
		String substring = "bcd";
		String texto = "abcdef";

//		LinearProbingHashST<String, String> hash = new LinearProbingHashST<String, String>();

		int hashSubstring = substring.hashCode();
		System.out.println("hash normal '"+ substring + "': " + hashSubstring);

//		int hashPrimeiro = texto.substring(0, substring.length()).hashCode();
//		int hashA= 0;
		for (int i = 0; i < texto.length(); i++) {
			
			int aux = substring.length() + i;
			//if ( aux <= texto.length() ) {
			//	System.out.println("str: "+texto.substring(i, aux)+" hash: " + texto.substring(i, aux).hashCode() );
				
			//}
			if(hashSubstring == texto.substring(i, aux).hashCode() ) {
				System.out.println("posicao encontrada:" + i);
				break;
			}
		}

	}

}
