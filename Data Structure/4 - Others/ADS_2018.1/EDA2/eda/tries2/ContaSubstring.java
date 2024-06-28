package br.ufc.crateus.eda.tries2;

public class ContaSubstring {

	public static void main(String[] args) {
		String texto = "casa da moeda da espanha";
		//String texto = "cgcgggcgcg";
		int tamSubstring = 3;

		RWayTrieST<String> arvore = new RWayTrieST<String>();

		int inicio = 0, fim = inicio + tamSubstring;
		for (int i = 0; i < texto.length(); i++) {
			if (fim <= texto.length()) {
				System.out.println(inicio + texto.substring(inicio, fim));
				arvore.put(texto.substring(inicio, fim), texto.substring(inicio, fim));
			}
			inicio++;
			fim++;
		}
		
//		for(String aux : arvore.keys())
//			System.out.println(aux);
//		
		System.out.println("Palavra: " + texto.length());
		System.out.println("Tamanho: " + arvore.size());
		
		/// L = custo da operacao de insercao
		// (texto.length - tamSubString + 1) = quantidade de substring
		
		/**(texto.length - tamSubString + 1) * L = custo relacionado ao tempo*/

	}

}
