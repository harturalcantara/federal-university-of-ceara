package br.ufc.crateus.eda.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class BreadthFirstPaths<T> {
	private Graph<T> G;
	private boolean[] marked;
	private int[] edgeTo;
	private final T s;

	public BreadthFirstPaths(Graph<T> G, T s) {
		this.G = G;
		this.marked = new boolean[G.countVertices()];
		this.edgeTo = new int[G.countVertices()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph<T> G, T s) {
		Queue<T> queue = new LinkedList<T>();
		marked[G.index(s)] = true;
		queue.add(s);
		while (!queue.isEmpty()) {
			T v = queue.remove();
			for (T w : (LinkedList<T>) G.adjacents(v))
				if (!marked[G.index(w)]) {
					edgeTo[G.index(w)] = G.index(v);
					marked[G.index(w)] = true;
					queue.add(w);
				}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<T> pathTo(T v) {
		if (!hasPathTo(G.index(v))) return null;
		
		Stack<T> path = new Stack<T>();
		for (int x = G.index(v); x != G.index(s); x = edgeTo[x]) 
			path.push((T) G.label(x));
		path.push(s);
		return path;

	}

}
