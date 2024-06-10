package br.ufc.crateus.eda.corretorOrt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import br.ufc.crateus.eda.st.ST;

public class SeparateChainingHash <K, V > implements ST<K, V> {
	
	private static class  Node{
		Object key;
		Object value;
		Node next;
		
		public Node(Object key , Object value, Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
	}
	
	
	/**METODOS ADICIONAIS PARA RESOLUCAO DO TRABALHO*/
	
	/*public V getPosi(K key) {
		
		if(key == null) return null;
		
		int k = hash(key);
		
		for (Node aux= array[k]; aux != null; aux = aux.next) {
			if(!key.equals(aux.key)) {
				return (V) aux.value;
			}
		}
		
		return null;
	}*/
	
	/*
	public boolean containsPosi(K key) {
		
		if(key == null) return false;
		
		int k = hash(key);
		
		for (Node aux= array[k]; aux != null; aux = aux.next) {
			if( key.equals(aux.key) ) {
				return true;
			}
		}
		
		return false;
	}*/
	/*
	public void errosOrtograficos(SeparateChainingHash arqPre) {
		
		try {
			File caminho = new File("/home/harturalcantara/Área de Trabalho/DicionarioPreE.txt");
			FileReader arq = new FileReader(caminho);
		    BufferedReader lerArq = new BufferedReader(arq);
		 
		    String linha = "";
		    int posicao = 0;
		    try {
		      linha = lerArq.readLine();
		      //posicao++;
		      while (linha != null) {
		        System.out.println("A palavra no arquivo pre-existente contém? " + arqPre.contains(linha) +" "+ arqPre.getPosi(linha));
		        if(arqPre.contains(linha)== false)
		        	System.out.println("\t\tNo -Arquivo Pessoal- possui erro posicao:"+ linha +" "+ arqPre.getPosi(linha));
		        linha = lerArq.readLine(); // lê da segunda até a última linha
		        posicao++; //Vai invrementando a posicao
		      }
		 
		      arq.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		    }
		}catch (FileNotFoundException ex) {
			 System.err.printf("Erro na abertura do arquivo: %s.\n", ex.getMessage());
		}
	    System.out.println();
		
	}*/
	
	private int M = 10;
	private Node[] array;
	private int count;
	

	public SeparateChainingHash(int m) {
		this.array = new Node[m];
		this.count = 0;
	}
	
	private int hash(K key) {
		return ( key.hashCode() &  0x7fffffff % M );
	}
	
	
	@Override
	public void put(K key, V value) {
		
		if(value == null) delete(key);
		if(key == null) return;
		
		int k = hash(key);
		
		for (Node aux= array[k]; aux != null; aux = aux.next) {
				if(key.equals(aux.key)) {
					aux.value = value;
					return;
				}
		}
		
		 array[k] =  new Node(key , value , array[k] );
		 this.count++;
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
				
		if(key == null) return null;
		
		int k = hash(key);
		
		for (Node aux= array[k]; aux != null; aux = aux.next) {
			if(key.equals(aux.key)) {
				return (V) aux.value;
			}
		}
		
		return null;
	}

	@Override /** Okay */
	public boolean contains(K key) {
		
		if(key == null) return false;
		
		int k = hash(key);
		
		for (Node aux= array[k]; aux != null; aux = aux.next) {
			if( key.equals(aux.key) ) {
				return true;
			}
		}
		
		return false;
	}
	
	private Node delete(Node r, K key) {
		
		if(r == null) return null;
		
		if(key.equals(r.key)) {
			r = r.next;
			count--;
		}
		else r.next = delete(r.next,key);		
		
		return r;
	}

	@Override
	public void delete(K key) {
		if(key == null) return;	
		int k = hash(key);
		array[k] = delete(array[k], key);
	}

	@Override
	public boolean isEmpty() {
		return array == null;
	}

	@Override
	public int size() {
		return count;
	}
	
	public void imp(K key) {

		int i = 0;
		int k = hash(key);
		
		Node aux = array[k];
		while(i < 19) {
			if( aux != null ) {
				System.out.println(aux.key);
			}
			else
				System.out.println("Vazio!");
			
			aux = array[i+1];
			
			i++;
		}
	}

	public Iterable<K> keys() {
		return new Iterable<K>(){
			
			@Override
			public Iterator<K> iterator() {
				return new Iterator<K>() {
					Node aux;
					int count = 0;
					
					@Override
					public boolean hasNext() {
						return count < array.length;
					}

					@Override
					public K next() {
						
						if(aux != null) {
							do {
								@SuppressWarnings("unchecked")
								K key = (K) aux.key;
								aux = aux.next;
								return key;
								
							} while (aux != null);
							
						}else {
							aux = array[count++];
						}
						return null;
					}
				};
			}
			
		}; 

	}
	
}
