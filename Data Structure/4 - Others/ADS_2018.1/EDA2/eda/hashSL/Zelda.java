package br.ufc.crateus.eda.hashSL;

//import br.ufc.crateus.hashing.LinearProbingHashST;

public class Zelda {
	
	
	
	
	
	
	public static void main(String[] args) {
		HashSL  list = new HashSL(9);
		
		list.put(5, "a");
		list.put(5, "b");
		list.put(28, "b");
		list.put(19, "c");
		
		list.put(15, "d");
		list.put(20, "e");
		list.put(33, "f");
		
		list.put(12, "g");
		list.put(17, "h");
		list.put(10, "i");
		
		list.impKey(0);
		
		//Hartu--n   Hartu r -- n+1 n+2y
	}
}
