class Quadrado extends Quadrilateros implements Forma{
	
	public Quadrado(double lado){
		super(lado,lado,lado,lado);
	}



	@Override
	public double calculaPerimetro(){
		return base1+base2+altura1+altura2;
	}

	@Override
	public double calculaArea(){
		return base1* altura1;
	}

	@Override
	public String toString(){
		return "Quadrado sua Base:" + base1+"\n"+"Quadrado sua Altura:"+altura1; 
	}

}