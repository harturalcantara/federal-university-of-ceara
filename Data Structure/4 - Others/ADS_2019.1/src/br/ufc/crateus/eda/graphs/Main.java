package br.ufc.crateus.eda.graphs;

public class Main {

	public static void main(String[] args) {
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		Node n4 = new Node();
		Node n5 = new Node();
		
		Graph graph = new Graph();
		
		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		graph.addNode(n5);
		
		graph.connectNode(n1, n2,1);
		graph.connectNode(n1, n3,2);
		graph.connectNode(n2, n4,3);
		graph.connectNode(n2, n5,4); 
		
		if(graph.isTree()) {
			System.out.println("é uma arvore");
		} else {
			System.out.println("nao é uma arvore");
		}
		
		System.out.println("ordem nodo n1: "+graph.degreeNode(n1));
		System.out.println("ordem do grafo:"+graph.graphOrder());
		System.out.println("grafo é regular: "+graph.regularGraph());
		System.out.println("grafo é completo: "+ graph.completeGraph());
		System.out.println("grafo é conexo: "+graph.isConnected());
		System.out.println("fecho transitivo: "+graph.transitiveClosure(n1).toString());
		System.out.println("nodos adjacetes de n1: " + graph.adjacentNodes(n2)); 
		
		System.out.println("busca do nodo com id = 2: "+graph.search(2));

		System.out.println(graph.DijkstraDistance(n1));
		
		
	}

}
