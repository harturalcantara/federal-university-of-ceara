package br.ufc.crateus.eda.graphs;

import java.util.LinkedList;

import br.ufc.crateus.eda.hash.SeparateChainingHashMap;

public class AdjacencyMatrixGraph<T extends Comparable<T>> implements Graph<T> {

	private final int V;
	private int E;
	private int index;
	private boolean[][] adj;
	private SeparateChainingHashMap<T, Integer> table;

	public AdjacencyMatrixGraph(int V) {
		this.V = V;
		this.E = 0;
		this.index = 0;
		this.adj = new boolean[V][V];
		this.table = new SeparateChainingHashMap<T, Integer>(V);
		for (Integer v = 0; v < V; v++) 
			for (Integer w = 0; w < V; w++) 
				this.adj[v][w] = false;
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
		return table.get(v);
	}

	@Override
	public T label(int index) {
		for (T v : table.keys()) 
			if (table.get(v) == index)
				return v;
		return null;
	}

	@Override
	public boolean contains(T v) {
		return table.contains(v);
	}

	@Override
	public void addEdge(T v1, T v2) {
		if (!table.contains(v1)) table.put(v1, index++);
		if (!table.contains(v2)) table.put(v2, index++);
		adj[table.get(v1)][table.get(v2)] = true;
		adj[table.get(v2)][table.get(v1)] = true;
		E++;
	}

	@Override
	public Iterable<T> adjacents(T v) {
		LinkedList<T> lista = new LinkedList<T>();
		int ind = table.get(v);
		for (int i = 0; i < index; i++)
			if (adj[ind][i])
				lista.add(label(i));
		return lista;
	}

	@Override
	public int degree(T v) {
		LinkedList<T> vs = (LinkedList<T>) adjacents(v);
		return vs.size();
	}
}