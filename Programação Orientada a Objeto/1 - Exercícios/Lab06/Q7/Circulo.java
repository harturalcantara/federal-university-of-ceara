class Circulo implements Forma{
	double raio;


	public Circulo(double raio){
		this.raio = raio;
	}

	@Override
	public double calculaPerimetro(){
		return 2*raio*3.14;
	}

	@Override
	public double calculaArea(){
		return 3.14*(raio*raio);
	}

	@Override
	public String toString(){
		return "Circulo o seu Raio:" + raio;
	}
}