package aps_questao1;

public class Cliente {

	public static void main(String a[]){
		
		int vetor1[] = {1,2,3,4,5};
		int vetor2[] = {1,2,3};
		
		PrototipoMedia mediaArit = new PrototipoMediaAritmetica(vetor1);
		//mediaArit.calcularMedia();
		
		PrototipoMedia mediaPond = new PrototipoMediaPonderada(vetor2);
		//mediaPond.calcularMedia();
		
		PrototipoMedia list[] = {mediaArit, mediaArit.clonar(), mediaPond, mediaPond.clonar(), mediaPond.clonar()};
		
		for(PrototipoMedia fg : list){
			fg.calcularMedia();
			System.out.print('\n');
		}
	}
	
}
