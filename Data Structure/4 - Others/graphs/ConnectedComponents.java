package br.ufc.crateus.eda.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents<T> {
	private Graph<T> G;
	private boolean[] marked; 
	private int[] cc; 
	private int count; 

	public ConnectedComponents(Graph<T> G) {
		this.G = G;
		this.cc = new int[G.countVertices()];
		this.marked = new boolean[G.countVertices()];
		for (int s = 0; s < G.countVertices(); s++) {
			if (!marked[s] && G.label(s) != null) {
				bfs(G, G.label(s));
				count++;
			}
		}
	}

	private void bfs(Graph<T> G, T s) {
		Queue<T> queue = new LinkedList<T>();
		marked[G.index(s)] = true;
		cc[G.index(s)] = count;
		queue.add(s);
		while (!queue.isEmpty()) {
			T v = queue.remove();
			for (T w : (LinkedList<T>) G.adjacents(v))
				if (!marked[G.index(w)]) {
					marked[G.index(w)] = true;
					queue.add(w);
				}
		}
	}

	public boolean connected(T v, T w) {
		return cc[G.index(v)] == cc[G.index(w)];
	}

	public int id(T v) {
		return cc[G.index(v)];
	}

	public int count() {
		return count;
	}
}
