class QuadrilaterosAux{

	private Forma vetor[]= new Forma[10];
	private int qtdQuadrilateros=0 ;

	public void adicionaForma(Forma forma){
		vetor[qtdQuadrilateros++] = forma;
	}

	//@Override
	public void imprimeDadosVetor(){
		for (int i=0;i<qtdQuadrilateros;i++) {
			System.out.println(vetor[i].toString());
			System.out.println(vetor[i].calculaPerimetro());
			System.out.println(vetor[i].calculaArea());
					
		}
	}

}