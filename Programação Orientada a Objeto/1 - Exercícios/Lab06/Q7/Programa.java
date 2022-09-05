class Programa{
	public static void main(String [] args){
		//QuadrilaterosAux java = new QuadrilaterosAux();

		Forma quadrado = new Quadrado(2);
		Forma retangulo = new Retangulo(2,2);
		Forma circulo = new Circulo(2);


		// java.adicionaForma(quadrado);
		// java.adicionaForma(retangulo);
		// java.adicionaForma(circulo);
		System.out.println("\tPerimetro e Area das Formas!");
		/*Usando metodos do quadrado*/
		System.out.println("Perimetro do Quadrado:" + quadrado.calculaPerimetro());
		System.out.println("Area do Quadrado:" + quadrado.calculaArea());
		/*Usando metodos do Retangulo*/
		System.out.println("Retangulo seu Perimetro:" + retangulo.calculaPerimetro());
		System.out.println("Retagunlo sua Area:" + retangulo.calculaArea());
		/*Usando metodos do Circulo*/
		System.out.println("Circulo seu Perimetro:" + circulo.calculaPerimetro());
		System.out.println("Circulo sua Area:" + circulo.calculaArea());

		Forma geometricas[] = new Forma[10];
		
		geometricas[0] = quadrado;
		geometricas[1] = retangulo;
		geometricas[2] = circulo;

		System.out.println();
		for (int i=0;i<3;i++){
			//if(geometricas[i] instanceof )

			System.out.println(geometricas[i].toString());
			System.out.println("O perimetro:");
			System.out.println(geometricas[i].calculaPerimetro());	
			System.out.println("Area:");
			System.out.println(geometricas[i].calculaArea());
			System.out.println();
		}

		// java.adicionaForma(quadrado);
		// java.adicionaForma(retangulo);
		// java.adicionaForma(circulo);
		// public void imprimeDadosVetor(){
		// 	for (int i=0;i<qtdQuadrilateros;i++) {
		// 	System.out.println(vetor[i].toString());
		// 	System.out.println(vetor[i].calculaPerimetro());
		// 	System.out.println(vetor[i].calculaArea());
					
		// 	}
		// }
		

		

	}
}

