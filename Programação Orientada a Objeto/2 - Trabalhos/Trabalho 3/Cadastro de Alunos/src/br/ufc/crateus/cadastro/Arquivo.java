package br.ufc.crateus.cadastro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	
	public static String Read(String caminho) {
		String conteudo = "";
		
		try {
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			try {
				linha = lerArq.readLine();
				while(linha != null) {
					conteudo += linha;
					linha = lerArq.readLine();
				}
				arq.close();
				return conteudo;
			}catch (IOException ex) {
				System.out.println("Erro: Não foi possivel ler o arquivo!");
				return "";
			}
		}catch (FileNotFoundException ex) {
			System.out.println("Erro: Arquivo não encontrado!");
			return "";
		}
		
	}
	
	public static boolean Write(String caminho, String texto) {
		
		try {
			FileWriter arq = new FileWriter(caminho);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(texto);
			gravarArq.close();
			return true;
			
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
}
