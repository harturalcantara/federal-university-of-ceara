package br.ufc.crateus.lab10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Banco {
	
	private Collection<Conta> teste = new ArrayList<>();
	
	public void adicionar(Conta newConta) {
		teste.add(newConta);
	}
	
	public void mostrar() {
		for(Conta i : teste)
			System.out.println(i);
	}
	
//	public void mostrarOrenado() {
//		
//		List<Conta> mostrar = new ArrayList<>(teste);
//		
//		Collections.sort(mostrar);
//		for(Conta i : mostrar) {
//			System.out.println("Conta ordenado:" + i);
//		}
//		
//	}
	public void mostrarOrenado() {
		
		List<Conta> mostrar = new ArrayList<>(teste);
		
		Comparator<Conta> cmp = new Comparator<Conta>() {
			@Override
			public int compare(Conta o1, Conta o2)
		}
		
		Collections.sort(mostrar);
		for(Conta i : mostrar) {
			System.out.println("Conta ordenado:" + i);
		}
		
	}
	
}
