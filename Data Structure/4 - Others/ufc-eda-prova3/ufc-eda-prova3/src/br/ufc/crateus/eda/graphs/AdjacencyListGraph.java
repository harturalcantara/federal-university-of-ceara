package br.ufc.crateus.eda.graphs;

import java.util.LinkedList;

import br.ufc.crateus.eda.hash.*;

public class AdjacencyListGraph<T> implements Graph<T> {
	
	private int V; 
	private int E;
	private int index;
	private SeparateChainingHashMap<T, Integer> table;
	private LinkedList<T>[] adj;

	@SuppressWarnings("unchecked")
	public AdjacencyListGraph(int V) {
		this.setV(V);
		this.E = 0;
		this.index = 0;
		this.table = new SeparateChainingHashMap<T, Integer>(V);
		this.adj = (LinkedList<T>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) 
			adj[i] = new LinkedList<T>();
	}

	@Override
	public int countVertices() {
		return index;
	}

	@Override
	public int countEdges() {
		return E;
	}

	@Override
	public int index(T v) {
		if(!table.contains(v)) return -1;
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
		if (!table.contains(v1))
			table.put(v1, index++);
		if (!table.contains(v2))
			table.put(v2, index++);
		adj[table.get(v1)].add(v2);
		adj[table.get(v2)].add(v1);
		E++;
	}

	@Override
	public Iterable<T> adjacents(T v) {
		if(!table.contains(v)) return null;
		return adj[table.get(v)];
	}

	@Override
	public int degree(T v) {
		return adj[table.get(v)].size();
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

}
