package br.ufc.crateus.eda.graphs;

import java.util.LinkedList;
import java.util.Stack;

import br.com.crateus.ufc.eda.st.SeparateChainingHashingST;

public class AdjacencyMatrixGraph<T extends Comparable<T>> implements Graph<T> {

	private final int V;
	private int INDEX;
	private int E;
	private boolean[][] adj;
	private SeparateChainingHashingST<T, Integer> labels;

	public AdjacencyMatrixGraph(int V) {
		this.V = V;
		this.INDEX = 0;
		this.E = 0;
		this.adj = new boolean[V][V];
		this.labels = new SeparateChainingHashingST<T, Integer>(V);

		for (Integer v = 0; v < V; v++) {
			for (Integer w = 0; w < V; w++) {
				this.adj[v][w] = false;
			}
		}
	}

	@Override
	public int countVertices() {
		return V;
	}

	@Override
	public int countEdges() {
		return E;
	}

	@Override
	public int index(T v) {
		return labels.get(v);
	}

	@Override
	public T label(int index) {
		for (T v : labels.keys()) {
			if (labels.get(v) == index)
				return v;
		}

		return null;
	}

	@Override
	public boolean contains(T v) {
		return labels.contains(v);
	}

	@Override
	public void addEdge(T v1, T v2) {
		if (!labels.contains(v1)) labels.put(v1, INDEX++);

		if (!labels.contains(v2)) labels.put(v2, INDEX++);

		adj[labels.get(v1)][labels.get(v2)] = true;
		adj[labels.get(v2)][labels.get(v1)] = true;

		E++;
	}

	@Override
	public Iterable<T> adjacents(T v) {
		LinkedList<T> ll = new LinkedList<T>();
		int index = labels.get(v);

		for (int i = 0; i < INDEX; i++) {
			if (adj[index][i])
				ll.add(label(i));
		}
		return ll;
	}

	@Override
	public int degree(T v) {
		LinkedList<T> vs = (LinkedList<T>) adjacents(v);
		return vs.size();
	}

	@Override
	public int shortestPath(T v1, T v2) {
		return ((Stack<T>) GraphUtils.shortestPath(this, v1, v2)).size() - 1;
	}

}
