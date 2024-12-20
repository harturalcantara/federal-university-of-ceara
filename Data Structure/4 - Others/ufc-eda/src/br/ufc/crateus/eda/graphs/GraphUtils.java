package br.ufc.crateus.eda.graphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GraphUtils {

	public static <T> Iterable<T> shortestPath(Graph<T> graph, T v1, T v2) {
		BreadthFirstPaths<T> bfs = new BreadthFirstPaths<T>(graph, v1);
		return bfs.pathTo(v2);

	}

	public static Graph<String> readFromFile(InputStream is, String sep) {
		Graph<String> graph = new AdjacencyListGraph<String>(198990);
		
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while (br.ready()) {
				String[] vs = br.readLine().split(sep);
				
				for(int i = 1; i < vs.length; i++) {
					graph.addEdge(vs[0], vs[i]);
				}
			}

			br.close();

		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException e) {
			System.out.println(e);
		}
		return graph;
	}
}
