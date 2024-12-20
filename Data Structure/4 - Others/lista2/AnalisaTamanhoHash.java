package br.ufc.crateus.eda.lista2;

import java.util.Random;

public class AnalisaTamanhoHash {
	
	private static void preencheTabela(int n){
		
		Random gerador = new Random();
		HashEncadeamento<Integer,Integer> tabelaHash = new HashEncadeamento<Integer,Integer>(n/100);
		for(int i=0;i<n;i++)
			tabelaHash.put(gerador.nextInt(), 0);
		System.out.println("\n\nN = "+n);
		System.out.println("Menor lista = "+tabelaHash.minSizeList());
		System.out.println("Maior lista = "+tabelaHash.maxSizeList());
		System.out.println("Tamanho esperado: "+ ((float) n / (n/100)) );
	}
	
	public static void main(String[] args) {
		preencheTabela(10*10);
		preencheTabela(10*10*10);
		preencheTabela(10*10*10*10);
		preencheTabela(10*10*10*10*10);
		preencheTabela(10*10*10*10*10*10);
		preencheTabela(10*10*10*10*10*10*10);
	}
	
}
