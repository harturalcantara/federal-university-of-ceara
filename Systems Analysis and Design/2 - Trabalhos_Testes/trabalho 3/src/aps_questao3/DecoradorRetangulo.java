package aps_questao3;

public class DecoradorRetangulo extends Decorador{
	public void operacao_area(int base, int altura) {
		super.operacao_area(base, altura);
		double area = base * altura;
		System.out.println("A area do retangulo e:" + area);
	}
}
