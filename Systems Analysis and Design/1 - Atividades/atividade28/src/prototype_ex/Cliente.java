package prototype_ex;

public class Cliente {

	public static void main(String a[]){
		PrototipoFiguraGeometrica quadrado = new PrototipoQuadrado(4);
		
		PrototipoFiguraGeometrica triangulo = new PrototipoTriangulo(3);
		
		PrototipoFiguraGeometrica list[] = {quadrado, quadrado.clonar(), triangulo, triangulo.clonar(), triangulo.clonar()};
		
		for(PrototipoFiguraGeometrica fg : list){
			fg.imprimirFigura();
			System.out.print('\n');
		}
	}
	
}
