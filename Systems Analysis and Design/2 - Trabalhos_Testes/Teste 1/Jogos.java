package br.crateus.ufc.teste1;

import java.util.Scanner;

public class Jogos {

	public static void main(String[] args) {
		
		EstadioCopa copa = new EstadioCopa();
		String name = "";
		int soma = 0, mult = 0;
		
		System.out.println("Digite o numero de TIMES:");
		copa.setT(new Scanner(System.in).nextInt()); 
		while( copa.getT() < 2 || copa.getT() > 200) // Restricao 1
			copa.setT(new Scanner(System.in).nextInt());
		
		System.out.println("Digite o numero de PARTIDAS:");
		copa.setN(new Scanner(System.in).nextInt());
		while( copa.getN() < 0 || copa.getN() > 10000) //Restricao 2
			copa.setN(new Scanner(System.in).nextInt());
		
		for(int i = 0; i < copa.getN(); i++) {
			name = new Scanner(System.in).nextLine();
			while( name.length() > 10) // Restricao 3
				name = new Scanner(System.in).nextLine();
			String []vetor = name.split(" ");
			copa.getTimes().add(new Times( vetor[0], Integer.parseInt(vetor[1])) );
		}
		
		for(int i = 0; i< copa.getN(); i++) {
			soma +=copa.getTimes().get(i).getPoint();
		}
		mult = copa.getT() * 3;
		soma = mult - soma;
		System.out.println("Numero de empates:");
		System.out.println(soma);
	}	

}
