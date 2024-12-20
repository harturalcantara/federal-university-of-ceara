package br.ufc.crateus.eda.lista2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
				System.out.println(filme);
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}

	public static void main(String[] args) {
		Filmes filmes = new Filmes();
		
		System.out.println("\n\n\nkeysWithPrefix");
		System.out.println(filmes.arvore.keysWithPrefix(filmes.tratarString("world")));
		
		System.out.println("\n\n\nlongestPrefixOf");
		System.out.println(filmes.arvore.longestPrefixOf(filmes.tratarString("world")));
		
		System.out.println("\n\n\nkeysThatMatch");
		for (String filme : filmes.arvore.keysThatMatch("w..".toLowerCase().trim())) {
			System.out.println(filme);
		}
		
		/*
		for (String filme : filmes.arvore.keysWithPrefix(filmes.tratarString(args[0]))) {
			System.out.println(filme);
		}

		System.out.println("\n\n\nlongestPrefixOf");
		System.out.println(filmes.arvore.longestPrefixOf(filmes.tratarString(args[0])));

		System.out.println("\n\n\nkeysThatMatch");
		for (String filme : filmes.arvore.keysThatMatch(args[0].toLowerCase().trim())) {
			System.out.println(filme);
		}*/
	}

}
/**Relatorio
 * 
 * */

