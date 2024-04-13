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
	
	/** Padr�o de projeto ProtoType
	 * Seguindo o mesmo modelo passado como exemplo, foi aplicado o padr�o de projeto proto_type
	 * nas opera��es sobre m�dias, onde considerado a media aritmetica e ponderada, e adicionando
	 * em um vetor list, onde recebe os objetos originais e clones e ap�s isso, mando imprimir
	 * as m�dias de cada um.
	 * */
	
}
