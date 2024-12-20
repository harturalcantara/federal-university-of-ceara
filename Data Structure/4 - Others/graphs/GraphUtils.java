package br.ufc.crateus.eda.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class GraphUtils {

	public static <T> int shortestPath(Graph<T> graph, T v1, T v2) {
		BreadthFirstPaths<T> bfs = new BreadthFirstPaths<T>(graph, v1);
		return bfs.pathTo(v2);

	}

	public static Graph<String> readFromFile(InputStream is, String sep) {
		Graph<String> grafo = new AdjacencyListGraph<String>(202000);
		
		BufferedReader arq;
		try {
			arq = new BufferedReader(new InputStreamReader(is));
			while (arq.ready()) {
				String[] vs = arq.readLine().split(sep);
				for(int i = 1; i < vs.length; i++) 
					grafo.addEdge(vs[0], vs[i]);
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		return grafo;
	}
	
	public static <T> int componentsConnected(Graph<T> graph) {
		ConnectedComponents<T> c = new ConnectedComponents<T>(graph);
		return c.count();
	}
	
	
}
