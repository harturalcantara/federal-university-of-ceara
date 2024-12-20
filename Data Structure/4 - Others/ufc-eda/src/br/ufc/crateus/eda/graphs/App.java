package br.ufc.crateus.eda.graphs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App {

	public static void main(String[] args) {
		AdjacencyListGraph<String> graph = new AdjacencyListGraph<String>(6);
		//AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<String>(4);
		
		//adiciona uma aresta entre os v�rtices v1 e v2
		graph.addEdge("Joao", "Maria");
		graph.addEdge("Antonio", "Paulo");
		graph.addEdge("Joao","Paulo");
		graph.addEdge("Maria","Antonio");
		//graph.addEdge("Jose","Josa");
		//graph.addEdge("Josa","Jose");
		
		// retorna o n�mero de v�rtices do grafo
		System.out.println(graph.countVertices());
		
		// retorna o n�mero de arestas do grafo
		System.out.println(graph.countEdges());
		
		//retorna o indice do v�rtice v, que indica, na sequ�ncias de inser��es, a posi��o de inser��o do v�rtice
		System.out.println(graph.index("Paulo"));
		
		//retorna o r�tulo do v�rtice cujo indice � index
		System.out.println(graph.label(1));
		
		//verifica se existe v�rtice com r�tulo v
		System.out.println(graph.contains("Jose"));
		
		//retorna os v�rtices adjacentes a v
		System.out.println(graph.adjacents("Joao"));
		
		//retorna o grau do v�rtice v
		System.out.println(graph.degree("Maria"));
		
		//encontra o menor caminho, em n�umero de arestas, entre os v�rtices v1 e v2, usando BFS.
		System.out.println(graph.shortestPath("Joao", "Paulo"));
		
		
		//l� o grafo de um arquivo movies.txt
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
