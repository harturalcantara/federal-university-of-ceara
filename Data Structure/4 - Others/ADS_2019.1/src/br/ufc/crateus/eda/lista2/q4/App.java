package br.ufc.crateus.eda.lista2.q4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class App {
	public static void errosOrtograficos(SeparateChainingHash<String, Integer> dicionario) {
		try {
			File caminho = new File("C:\\Users\\hartu\\Desktop\\DicionarioPessoal.txt");			
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			int posicao = 0;
			try {
				linha = lerArq.readLine();
				posicao++;
				while (linha != null) {
					if (dicionario.contains(linha) == false) {
						System.out.println("'No Arquivo Pessoal' - possui erro na palavra: " + "[" + linha + "]"
								+ " na posicao: " + "[" + posicao + "]");
						System.out.println();
						
						System.out.println("\tSolucao: Adicionando um caractere.");
						ArrayList<?> arrayAux = adicaoUmCaractere(linha, dicionario);
						if(arrayAux.size() == 0)
							System.out.println("Error - Nao encontramos palavras em nosso dicionario.\n");
						for(int i=0; i < arrayAux.size(); i++)
							System.out.println(arrayAux.get(i)); 
						
						System.out.println("\tSolucao: Removendo um caractere.");
						ArrayList<?> arrayAux2 = removeUmCaractere(linha, dicionario);
						if(arrayAux2.size() == 0)
							System.out.println("Error - Nao encontramos palavras em nosso dicionario.\n");
						for(int i=0; i < arrayAux2.size(); i++)
							System.out.println("Voce pode ter querido dizer: " +"'"+ arrayAux2.get(i) + "'"); 
						
						System.out.println("\tSolucao: Trocando caracteres adjacentes.");
						ArrayList<?> arrayAux3 = inversaoDeCaractere(linha, dicionario);
						if(arrayAux3.size() == 0)
							System.out.println("Error - Nao encontramos palavras em nosso dicionario.\n");
						for(int i=0; i < arrayAux3.size(); i++)
							System.out.println("Voce pode ter querido dizer: " +"'"+ arrayAux3.get(i) + "'"); 
						System.out.println("---------------------------------------------------------------------------");
					}
					linha = lerArq.readLine();
					posicao++;
				}		
				arq.close();
			} catch (IOException e) {
				System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			}
		} catch (FileNotFoundException ex) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", ex.getMessage());
		}
	}

	public static ArrayList<String> adicaoUmCaractere(String palavra, SeparateChainingHash<String, Integer> dicionario) {
		String prefixo = "";
		String sufixo = "";
		String palavraTotal = "";
		ArrayList<String> vetorStr = new ArrayList<>();
		for (int i = 0; i < palavra.length() + 1; i++) {
			for (int j = 0; j < 256; j++) {
				prefixo = palavra.substring(0, i);
				sufixo = palavra.substring(i, palavra.length());
				char c = (char) j;
				palavraTotal = prefixo + c + sufixo;
				if ( dicionario.contains(palavraTotal) == true)
					vetorStr.add(palavraTotal);
			}
		}
		return vetorStr;
	}

	public static ArrayList<String> removeUmCaractere(String palavra, SeparateChainingHash<String, Integer> dicionario) {
		String prefix = "";
		String sufixo = "";
		String palavraTotal = "";
		ArrayList<String> vetorStr = new ArrayList<>();
		for (int i = 0; i < palavra.length(); i++) {
			prefix = palavra.substring(0, i);
			sufixo = palavra.substring(i + 1, palavra.length());
			palavraTotal = prefix + sufixo;
			if (dicionario.contains(palavraTotal) == true)
				vetorStr.add(palavraTotal);
		}
		return vetorStr;
	}

	public static ArrayList<String> inversaoDeCaractere(String palavra, SeparateChainingHash<String, Integer> dicionario) {
		ArrayList<String> list = new ArrayList<>();
		char[] pala = palavra.toCharArray();
		char[] nome = pala;
		for (int i = 0; i < palavra.length() - 1; i++) {
			char c = nome[i];
			nome[i] = nome[i + 1];
			nome[i + 1] = c;
			String word = String.copyValueOf(nome);
			if (dicionario.contains(word) == true)
				list.add(word);
			c = nome[i];
			nome[i] = nome[i + 1];
			nome[i + 1] = c;
		}
		return list;
	}

	public static void main(String[] args) {
		SeparateChainingHash<String, Integer> list = new SeparateChainingHash<>(10);
		try {
			File caminho = new File("C:\\Users\\hartu\\Desktop\\dicionarioExistente.txt");
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			int posicao = 0;
			try {
				linha = lerArq.readLine();
				posicao++;
				while (linha != null) {
					list.put(linha, posicao);
					linha = lerArq.readLine();
					posicao++;
				}
				arq.close();
			} catch (IOException e) {
				System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			}
		} catch (FileNotFoundException ex) {
			System.err.printf("arquivo: %s.\n", ex.getMessage());
		}
		errosOrtograficos(list);
	}
}

/** 	Relatorio do Sistema.
 *  O sistema se baseia na logica de correcao de palavras, usando apartir de dois arquivos, cujo um dos arquivos
 *  contem as palavras erradas, e outro arquivo contem as palavras certas, o arquivo que contem as palavras
 *  corretas sao inseridas na estrutura da SeparateChainning, de modo que ao ler linha por linha vai sendo inserido,
 *  apos ter inserido as palavras corretas, chamo o metodo errosOrtograficos(), onde ele vai ler o segundo arquivo
 *  e a cada linha que ele le, ele compara se existe no dicionario, se a palavra estiver errada ele ira retornar a posi-
 *  cao na linha, e busca por tres solucoes, caso a solucao exista ele retorna as palavras, se nao significa que a pala-
 *  vra nao existe no dicionario de palavras corretas.
 * 
 *  By.: Hartur Alcantara - 2019.1
 * */	