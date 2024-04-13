package aps_questao3;



public class Cliente {
	public static void main(String[] args) {
		int base= 2, altura = 4;
		
		Forma impressora = new ImpressaoDados();
		
		Decorador quadrado = new DecoradorQuadrado();
		Decorador retangulo = new DecoradorRetangulo();
		Decorador triangulo = new DecoradorTriangulo();
		
		
		quadrado.setComponente(impressora);
		retangulo.setComponente(quadrado);
		triangulo.setComponente(retangulo);
		triangulo.operacao_area(base, altura);
	}
		
	/** Padrão de projeto Decorator
	 * Seguindo o mesmo modelo passado como exemplo, foi aplicado o padrão de projeto Decorator
	 * formas geometricas, criados todos os objetos do geometricos, cada objeto vai ter um compo-
	 * nente, o quadrado inicialmente tem impressora como seu componente, o retagunlo tem o quadra-
	 * do, o triangulo o retangulo, e por fim mando os dados para serem feitos o calculo da base e
	 * altura. Desse forma, como um escadinha ele irá imprimindo as operações de cada forma geometri-
	 * ca. 
	 * */
}
