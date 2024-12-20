package br.ufc.crateus.eda.lista2;

public class MultiplicaPolinomio{

					// Expoente, Coeficiente
	private static LinkedListST<Double, Double> a;
	private static LinkedListST<Double, Double> b;
	private static SeparateChainingHashST<Double, Double> c;
	
	public MultiplicaPolinomio(){
		this.a = new LinkedListST<>();
		this.b = new LinkedListST<>();
	// Expoente, Coeficiente
		a.put(0.0, 1.0);
		a.put(1.0, 1.0);
		a.put(2.0, 1.0);
		b.put(1.0, 2.0);
		b.put(2.0, 2.0);
		b.put(3.0, 2.0);
	}
	
	public void multiplica(LinkedListST<Double, Double> a, LinkedListST<Double, Double> b){
		c = new SeparateChainingHashST<>(a.size());
		for(Double expA : a.keys()){
			for(Double expB : b.keys()){
				
				System.out.println("Expoente - expA: "+expA +" expB: "+ expB);
				System.out.println("Coeficiente - a: "+a.get(expA)+ " b: " + b.get(expB));
				
				Double expProduto = expA + expB;
				System.out.println(expProduto);
				Double coefProduto = a.get(expA) * b.get(expB);
				System.out.println();
				Double coef = c.get(expProduto);
				if(coef != null)
					c.put(expProduto, coef+coefProduto);
				else 
					c.put(expProduto, coefProduto);
			}
		}
		for(Double exp : c.keys()){
			System.out.println(c.get(exp)+" ^ "+exp);
		}
	}
	
	public static void main(String[] args) {
		MultiplicaPolinomio multiplicaPolinomio = new MultiplicaPolinomio();
		multiplicaPolinomio.a.put(0.0, 1.0);
		multiplicaPolinomio.a.put(1.0, 1.0);
		multiplicaPolinomio.a.put(2.0, 1.0);
		multiplicaPolinomio.b.put(1.0, 2.0);
		multiplicaPolinomio.b.put(2.0, 2.0);
		multiplicaPolinomio.b.put(3.0, 2.0);
		multiplicaPolinomio.multiplica(multiplicaPolinomio.a, multiplicaPolinomio.b);
	}
	
}
