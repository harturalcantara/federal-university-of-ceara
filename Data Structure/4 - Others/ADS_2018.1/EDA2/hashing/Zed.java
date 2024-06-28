package br.ufc.crateus.hashing;

public class Zed {
	public static void main(String[] args) {
		
		//SeparateChainingHash <Integer, String> list = new SeparateChainingHash<>(9);
		LinearProbingHashST <Integer, String> list = new LinearProbingHashST<>(9);
		
		list.put(5, "a");
		list.put(28, "b");
		list.put(19, "c");
		list.put(15, "d");
		list.put(20, "e");
		list.put(33, "f");
		list.put(12, "g");
		list.put(17, "h");
		list.put(10, "i");
		
		//list.imp(5);
		
		System.out.println("Meu Iterator!!");
		for(Object ob : list.keys()) {
			System.out.println(ob);
		}
		
		
		
		/*
		SeparateChainingHash <Integer, String> list = new SeparateChainingHash<>(20);
		
		list.put(1, "a");
		list.put(2, "b");
		list.put(3, "c");
		list.put(4, "d");
		list.put(5, "e");
		list.put(6, "f");
		list.put(7, "g");
		list.put(8, "h");
		list.put(9, "i");
		list.put(10, "j");
		
		System.out.println("Método - contains()!");
		System.out.println( list.contains(2) );
		System.out.println( list.contains(1) );
		System.out.println( list.contains(3) );
		
		System.out.println("Método - get()!");
		System.out.println( list.get(2) );
		System.out.println( list.get(1) );
		System.out.println( list.get(3) );
		
		//System.out.println("Imprimindo");
//		int i = 0;	
//		while(i < 19) {
//			System.out.println( list.contains(i) );
//			i++;
//		}
		//list.imp(1);
		
		
		System.out.println("Meu Iterator!!");
		for(Object ob : list.keys()) {
			System.out.println(ob);
		}
		
		/**
		 * Escreva um programa que insira N chaves inteiras (numeros int) aleatorias em uma tabela de tamanho
		 * N/100 usando hashing com encadeamento e depois determine  o  comprimento  da  lista  mais  curta  e 
		 *  da  mais  longa.   Faca  isso  para N igual  a  10 3,  10 4 ,  10 5,  106.   (Faca  um  pequeno  relatorio  so-
		 *  bre  os  resultados  e acrescente o relatorio, como comentario, ao final do seu programa.)
		 * */
		
		//SeparateChainingHash <Integer, String> list = new SeparateChainingHash<>(10);
		
		//obeter do usuario o quando de inserçoes e dps inserir o int
		// saber qual lista tem mais e que tem menos
		
		/*
		list.put(1, "a");
		list.put(2, "b");
		list.put(3, "c");
		list.put(4, "d");
		list.put(5, "e");
		list.put(6, "f");
		list.put(7, "g");
		list.put(8, "h");
		
		System.out.println(list.maiorList(list.getArray()));
		*/

	}
}
