package br.ufc.crateus.eda.lista2;

/**QUESTAO  - LISTA 2 - EDA*/
public class BuscaSubstring {
	
	public static void main(String[] args) {
		
		String texto = "cgcgggcgcg";
		String substring = "gg";
		LinearProbingHashST<String, String> hash = new LinearProbingHashST<String, String>();
		
		for(int i=0; i < texto.length(); i++){
			for(int j=i; j < texto.length(); j++){
				hash.put(texto.substring(i, j), texto.substring(i, j));
			}
		}
		
		int tamSub = substring.length(), inicio=0, fim=inicio+tamSub;
		for(int i=0; i < texto.length(); i++){
			if(fim <= texto.length() && substring.equals(hash.get(texto.substring(inicio, fim)))){
				System.out.println(hash.get(texto.substring(inicio, fim))+" esta na posicao "+inicio);
			}
			inicio++;
			fim++;
		}
	}
}
