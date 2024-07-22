package br.ufc.crateus.lista2.questoes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**QUESTAO 16 - LISTA 2 EDA*/
public class Filmes { 

	final String diretorio = "C:\\Users\\hartu\\Desktop\\Lista2 - EDA\\movies.txt";
	private TST<String> arvore;

	private String tratarString(String filme) {
		int index = filme.indexOf("(");
		if (index != -1)
			filme = filme.substring(0, index);
		filme = filme.trim();
		filme = filme.toLowerCase();
		filme = filme.replaceAll("á|à|â|ã|ä", "a");
		filme = filme.replaceAll("é|è|ê|ẽ|ë", "e");
		filme = filme.replaceAll("í|ì|î|ĩ|ï", "i");
		filme = filme.replaceAll("ó|ò|ô|õ|ö", "o");
		filme = filme.replaceAll("ú|ù|û|ũ|ü", "u");
		filme = filme.replaceAll("ç", "c");
		filme = filme.replaceAll("[^a-z 0-9]", "?");
		return filme;
	}

	public Filmes() {
		arvore = new TST<String>();
		try {
			FileReader arq = new FileReader(diretorio);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			while (linha != null) {
				String filme = tratarString(linha);
				
				arvore.put(filme, filme);
				linha = lerArq.readLine(); 
				//System.out.println(filme);
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Filmes filmes = new Filmes();
		Scanner s = new Scanner(System.in);

	    System.out.println("Digite o nome para busca: ");
	    String string = s.next();
	    System.out.println("Voce digitou: " + string);
	    
		System.out.println("\n\n\nresult - keysWithPrefix");
		System.out.println(filmes.arvore.keysWithPrefix(filmes.tratarString(string)));
		
		System.out.println("\n\n\nresult - longestPrefixOf");
		System.out.println(filmes.arvore.longestPrefixOf(filmes.tratarString(string)));
		
		System.out.println("\n\n\nresult - keysThatMatch");
		for (String filme : filmes.arvore.keysThatMatch(string.toLowerCase().trim())) {
			System.out.println(filme);
		}
		
	}

}
	/**Relatorio
	 * Resultados obtidos:
	 * 
	 * teste1
			Digite o nome para busca: 
			wor
			
			Voce digitou: wor
			
			result - keysWithPrefix
			[word of honor, word of mouth, working girl, working girls? the, world according to garp? the, world apart? a, world gone wild, world is full of married men? the, world is not enough? the, worst witch? the, worth winning]
			
			result - longestPrefixOf
			wor
			
			result - keysThatMatch
	
	-----
	 * teste 2
			Digite o nome para busca: 
			w..
			Voce digitou: w..
			result - keysWithPrefix
			[]
			
			result - longestPrefixOf
			w
			
			result - keysThatMatch
			wit
			woo
	-----
	 * */

