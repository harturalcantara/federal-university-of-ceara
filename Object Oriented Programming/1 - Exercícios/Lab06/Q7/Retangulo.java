class Retangulo extends Quadrilateros implements Forma{

	public Retangulo(double base, double altura){
		super(base,altura,base,altura);
	}

	@Override
	public double calculaPerimetro(){
		return 2*(base1 +altura1);
	}

	@Override
	public double calculaArea(){
		return base1* altura1;
	}

	@Override
	public String toString(){
		return "Retangulo sua Base"+ base1+"\n" +"Retangulo sua Altura"+ altura1;
	}

}