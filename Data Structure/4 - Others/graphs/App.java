package br.ufc.crateus.eda.graphs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		AdjacencyListGraph<String> graph = new AdjacencyListGraph<String>(20);
		//AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<String>(20);
		System.out.println("App");
		graph.addEdge("hartur", "mari");
		graph.addEdge("hartur", "mardonio");
		graph.addEdge("mardonio", "joaovitor");
		graph.addEdge("mardonio", "rafael");
		graph.addEdge("rafael", "lara");
		
		System.out.println("Quantidade de vertices: " + graph.countVertices());
		System.out.println("Quantidade de arestas: " + graph.countEdges());
		System.out.println("Posicao de insercao 'hartur': " + graph.index("hartur"));
		System.out.println("Posicao de insercao 'maria': " + graph.index("mari"));
		System.out.println("Vertices adjacentes 'hartur': " + graph.adjacents("hartur"));
		System.out.println("Rotulo do vertice: "+ graph.label(1));
		System.out.println("Contem hartur: "+ graph.contains("hartur"));
		System.out.println("Grau do vertice 'hartur': "+ graph.degree("hartur"));
		
		try {
			GraphUtils utilidade3 = new GraphUtils();
			Graph<String> g3 = utilidade3.readFromFile(new FileInputStream("movies.txt"), ",");
			System.out.println("Menor caminho 'hartur' a 'lara': "+ utilidade3.shortestPath(graph,"hartur", "lara"));
			System.out.println("Quantidade de vertice movies.txt: "+g3.countVertices());
			System.out.println("Quantidade de componente convexo movies.txt: "+utilidade3.componentsConnected(g3));
		} catch (FileNotFoundException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}
}
