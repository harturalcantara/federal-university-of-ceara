package br.ufc.crateus.eda.graphs;

import java.util.LinkedList;
import java.util.Stack;


import br.com.crateus.ufc.eda.st.SeparateChainingHashingST;

public class AdjacencyListGraph<T> implements Graph<T> {

	private final int V;
	private int INDEX;
	private int E;
	private SeparateChainingHashingST<T, Integer> labels;
	private LinkedList<T>[] adj;

	@SuppressWarnings("unchecked")
	public AdjacencyListGraph(int V) {
		this.V = V;
		this.INDEX = 0;
		this.E = 0;
		this.labels = new SeparateChainingHashingST<T, Integer>(V);
		this.adj = (LinkedList<T>[]) new LinkedList[V];

		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<T>();
		}

	}

	@Override
	public int countVertices() {
		return INDEX;
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
		if (!labels.contains(v1))
			labels.put(v1, INDEX++);

		if (!labels.contains(v2))
			labels.put(v2, INDEX++);

		adj[labels.get(v1)].add(v2);
		adj[labels.get(v2)].add(v1);

		E++;

	}

	@Override
	public Iterable<T> adjacents(T v) {
		return adj[labels.get(v)];
	}

	@Override
	public int degree(T v) {
		return adj[labels.get(v)].size();
	}

	@Override
	public int shortestPath(T v1, T v2) {
		return ((Stack<T>) GraphUtils.shortestPath(this, v1, v2)).size() - 1;
	}

}
