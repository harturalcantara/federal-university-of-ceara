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
	
	
	
//	Decorator desvioPadrao = new DecoratorDesvioPadrao();
//	Decorator mediaAritmetica = new DecoratorMedia();
//	
//	somatorio.setComponente(impressora);
//	mediaAritmetica.setComponente(somatorio);
//	desvioPadrao.setComponente(mediaAritmetica);
//	desvioPadrao.operacao(vetor);
}
