package br.ufc.crateus.eda.bag;

public class Zed {
	
	/**main - ArrayList*/ 
	
	public static void main(String[] args) {
		
		//ArrayListBag <Integer> list = new ArrayListBag<>(20);
		LinkedListBag <Integer> list = new LinkedListBag<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		
		AbstractListBag <Object> abs = new ArrayListBag<>(20) ;
		abs.add(1);
		abs.add(2);
		abs.add(3);
		abs.add(4);
        
		System.out.println("Meu abs");
		abs.imprimir();
		
		
		AbstractListBag <Object> absS = abs.subList(0, 3);
		System.out.println("NEW NEG");
		absS.imprimir();
		
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
//		list.add("e");
//		list.add("f");
		//list.imprimir();
		
		/*
		System.out.println("List elements - Metodo interator()!");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
		
		
		
//		
//		
//		System.out.println("Metodo contains()!");
//		System.out.println( "f - " + list.contains("a") );
//		System.out.println( "d - " + list.contains("c") );
//		System.out.println( "b - " + list.contains("e") );

//		System.out.println("Remove element! - VOID");
//		list.remove("f");
//		list.remove("d");
//		list.remove("b");
//		
//		list.imprimir();
//		System.out.println( "f - " + list.contains("a") );
//		System.out.println( "d - " + list.contains("c") );
//		System.out.println( "b - " + list.contains("e") );
		
//		System.out.println("Remove index - RETURN");
//		System.out.println( list.remove(0) );
//		System.out.println( list.remove(0) );
//		System.out.println( list.remove(0) );
//		System.out.println("Now");
//		list.imprimir();
		

		
//		Iterator<Integer> it = list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		
		/*

		
		System.out.println(" Método - size()!\n");
		System.out.println( list.size() );		
		
		System.out.println(" Metodo set()! - alterando posicao 0 para elemento 2!");
		list.set(1, 2);
		list.imprimir();
		
		System.out.println(" Metodo indexOf()! - Primeira ocorrencia!");
		System.out.println(list.indexOf(2));
		
		System.out.println(" Metodo lastIndexOf()! - Ultima ocorrencia!");
		System.out.println(list.lastIndexOf(2));
		
		System.out.println("Lista atual!");
		list.imprimir();
		
		System.out.print(" Método - remove()!\n");
		System.out.println( "Deletando o elemento: "+ list.remove(1) );
		System.out.println( "Deletando o elemento: "+ list.remove(1) );
		System.out.println( "Deletando o elemento: "+ list.remove(1) );
		
		System.out.println("Reverificando se os elementos deletados contém! ");
		System.out.println( "10 - " + list.contains(10) );
		System.out.println( "9 - " + list.contains(9) );
		System.out.println( "8 - " + list.contains(8) );
		

		System.out.println("List Atual");
		list.imprimir();
		
		
		System.out.println("Meu Iterator!!");
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		*/
			
	}
	
	
	/** Main - LinkedList */
	/*
	public static void main(String args[]) {
		System.out.println("LISTA ENCADEADAS");
		LinkedListBag<Integer> list = new LinkedListBag<>();
		
		System.out.println("Metodo isEmpty() - " + list.isEmpty());
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		
		System.out.println("Metodo isEmpty() - " + list.isEmpty());
		list.imprimir();
		
		System.out.println("Metodo remove()!");
		System.out.println( list.remove(2) );
		System.out.println( list.remove(4) );
		
		//list.remove(4);
		
		System.out.println("Actual list");
		list.imprimir();
		
		
		/*
		System.out.println("Metodo set()! - Alterando posição [0] para element '2' ");
		System.out.println( list.set(0, 2) );
		
		System.out.println("Metodo contains()!");
		System.out.println( "1 - " + list.contains(1) );
		System.out.println( "2 - " + list.contains(2) );
		System.out.println( "7 - " + list.contains(7) );
		System.out.println( "12 - " + list.contains(12) );
		
		System.out.println("List actual");
		list.imprimir();
		
		System.out.println("Metodo - size()!");
		System.out.println("Tamanho da lista - " +  list.size() );
		
		System.out.println("O primeiro caso de 2: " + list.indexOf(2) );
		System.out.println("O ultimo caso de 2: " + list.lastIndexOf(2) );
		
		
		
		
		
		System.out.println("Meu Iterator!!");
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		//System.out.println("Iterator!!");
		//for(int i=0 ; i < list.size(); i++) {
		//	System.out.println( list.iterator() );
		//}
		
		

	}*/
		

}
