package br.ufc.crateus.eda.st;



public class Zed {
	
	/** Main BinarySearchTreeST */
	/*
	public static void main(String[] args) {
		
		BinarySearchTreeST <Integer, String> list  = new BinarySearchTreeST<>();
				
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
		
		System.out.println("Metodo get() - Okay!");
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(4));
		System.out.println(list.get(7));
		
		System.out.println("Metodo contains() - Okay!");
		System.out.println(list.get(1));
		System.out.println(list.get(22));
		System.out.println(list.get(7));
		System.out.println(list.get(27));
		
		System.out.println("Metodo delete() - Okay!");
//		list.delete(2);
//		list.delete(4);
//		list.delete(7);
//		
//		System.out.println(list.get(2));
//		System.out.println(list.get(4));
//		System.out.println(list.get(7));
		
		
		
		
	}
	*/
	
	
	/**Main  BinaryST */ /*
	public static void main(String[] args) {
		
		OrderedST<Integer, String> st = new BinarySearchTreeST<>();
		
		st.put(4, "");
		st.put(9, "");
		st.put(7, "");
		st.put(2, "");
		st.put(13, "");
		st.put(0, "");
		st.put(8, "");
		st.put(3, "");
		st.put(14, "");
		st.put(10, "");
		st.put(11, "");
		st.put(6, "");
		st.put(1, "");
		st.put(5, "");
		st.put(12, "");
		
		for (int i = -1; i <= 15; i++)
			System.out.println(st.select(i));
		
		System.out.println(st.rank(10));
	} */
	
	
	
	
	
	
	/**main - class LinearProbingHash*/ 
	/*
	 public static void main(String[] args) {
	 
		
		LinearProbingHashST list = new LinearProbingHashST<>(10);
		
		list.put("hartur", "a");
		list.put("rafael", "b");
		list.put('b' , "c");
		list.put('c' , "d");
		
		
		//list.put(5, "e");
		//list.put(6, "f");
		//list.put(7, "g");
		//list.put(8, "h");
		//list.put(9, "i");
		//list.put(10, "j");
		for(Object ob : list.keys()) {
			System.out.println(ob);
		}
		
		list.put(5, "e");
		list.put(6, "f");
		System.out.println("NEW");
		for(Object ob : list.keys()) {
			System.out.println(ob);
		}
		
		
		
		System.out.println("Método - get()!");
		System.out.println(list.get(2));
		System.out.println(list.get(42));
		System.out.println(list.get(7));
		
		System.out.println("\nMétodo - contains()!");
		System.out.println("2 " + list.contains(2));
		System.out.println("42 " + list.contains(42));
		System.out.println("7 " + list.contains(7));
		
		System.out.println("\nElementos inseridos! - size()!");
		System.out.println(list.size());
		
		System.out.println("Método - delete()!");
		list.delete(2);
		list.delete(7);
		
		System.out.println(list.contains(2));
		System.out.println(list.contains(7));
		
		//int i=0;
		//for(i=0; i < list.size(); i++ ) {
			//System.out.println("i" + list.contains(i));
		//}
		
		System.out.println("\nMétodo - keys()!");
		//list.put(11, "i");
		//list.put(13, "i");
		//list.put(15, "i");
		
		for(Object ob : list.keys()) {
			System.out.println(ob);
		}
		
	}*/

	
	
	

	
	/**Main = AVLTreeST*/
	/*
	public static void main(String args[]){
		
		System.out.println("Minha árvore:");
		list.imprimirArv();
		
		System.out.println("\nDeletando a chave '4' ");
		list.delete(4);
		list.imprimirArv();
		
		System.out.println("\nDeletando maior");
	    list.deleteMax();
	    list.imprimirArv();
		
	    System.out.println("\nDeletando o menor ");
		list.deleteMin();
		list.imprimirArv();
	}*/
	 
}
