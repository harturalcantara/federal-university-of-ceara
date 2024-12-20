package br.ufc.crateus.eda.graphs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App {

	public static void main(String[] args) {
		AdjacencyListGraph<String> graph = new AdjacencyListGraph<String>(6);
		//AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<String>(4);
		
		//adiciona uma aresta entre os vértices v1 e v2
		graph.addEdge("Joao", "Maria");
		graph.addEdge("Antonio", "Paulo");
		graph.addEdge("Joao","Paulo");
		graph.addEdge("Maria","Antonio");
		//graph.addEdge("Jose","Josa");
		//graph.addEdge("Josa","Jose");
		
		// retorna o número de vértices do grafo
		System.out.println(graph.countVertices());
		
		// retorna o número de arestas do grafo
		System.out.println(graph.countEdges());
		
		//retorna o indice do vértice v, que indica, na sequências de inserções, a posição de inserção do vértice
		System.out.println(graph.index("Paulo"));
		
		//retorna o rótulo do vértice cujo indice é index
		System.out.println(graph.label(1));
		
		//verifica se existe vértice com rótulo v
		System.out.println(graph.contains("Jose"));
		
		//retorna os vértices adjacentes a v
		System.out.println(graph.adjacents("Joao"));
		
		//retorna o grau do vértice v
		System.out.println(graph.degree("Maria"));
		
		//encontra o menor caminho, em n´umero de arestas, entre os vértices v1 e v2, usando BFS.
		System.out.println(graph.shortestPath("Joao", "Paulo"));
		
		
		//lê o grafo de um arquivo movies.txt
		try {
			AdjacencyListGraph<String> graph2 = (AdjacencyListGraph<String>) GraphUtils.readFromFile(new FileInputStream("movies.txt"), ",");
			
			//System.out.println(graph2.countVertices());
			
			//ConnectedComponents<String> cc = new ConnectedComponents<String>(graph2);
			// retorna o numero de componentes conexas do grafo
			//System.out.println(cc.count());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
