package br.ufc.crateus.eda.lista2.trab;

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

/* Relatorio
 * 
N = 100
Menor lista = 100
Maior lista = 100
Tamanho esperado: 100.0


N = 1000
Menor lista = 96
Maior lista = 119
Tamanho esperado: 100.0


N = 10000
Menor lista = 120
Maior lista = 131
Tamanho esperado: 100.0


N = 100000
Menor lista = 102
Maior lista = 141
Tamanho esperado: 100.0


N = 1000000
Menor lista = 103
Maior lista = 140
Tamanho esperado: 100.0


N = 10000000
Menor lista = 99
Maior lista = 157
Tamanho esperado: 100.0

 * */
