package aps_questao3;

public class DecoradorQuadrado extends Decorador{
	
	public void operacao_area(int base, int altura) {
		super.operacao_area(base, altura);
		double area = Math.pow(base,2);
		System.out.println("A area do quadrado e:" + area);
	}
}
