package padrao.estrutural.decorator.ex2;

public class Cliente {

	public static void main(String a[]){
		int vetor[] = {10, 7, 4, 9, 5};
		
		Estatistics impressora = new ImpressaoSequencia();
		Decorator somatorio = new DecoratorSomatorio();
		Decorator desvioPadrao = new DecoratorDesvioPadrao();
		Decorator mediaAritmetica = new DecoratorMedia();
		
		somatorio.setComponente(impressora);
		mediaAritmetica.setComponente(somatorio);
		desvioPadrao.setComponente(mediaAritmetica);
		desvioPadrao.operacao(vetor);
		
	}
	
}
