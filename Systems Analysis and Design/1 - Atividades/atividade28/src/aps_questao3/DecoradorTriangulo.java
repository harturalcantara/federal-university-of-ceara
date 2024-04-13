package aps_questao3;

public class DecoradorTriangulo extends Decorador {
	public void operacao_area(int base, int altura) {
		super.operacao_area(base, altura);
		double area = (base * altura) / 2;
		System.out.println("A area do triangulo e:" + area);
	}
}
