class Parafuso extends Parte{
	private float comprimento;
	private float diametro;

	public Parafuso(int cod, String nome , float valor,float comprimento,float diametro){
		super(cod,nome,valor);
		this.comprimento = comprimento;
		this.diametro = diametro;

	}

	public float getComprimento(){
		return comprimento;
	}
	public float getDiametro(){
		return diametro;
	}


}