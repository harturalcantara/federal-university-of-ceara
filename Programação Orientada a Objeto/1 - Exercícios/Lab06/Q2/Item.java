class Item{
	Parte parte;
	int quantidade;


	public Item(int quantidade, Parte parte){
		this.parte = parte;
		this.quantidade = quantidade;
	}



	@Override
	public String toString(){
		return "Total:"+ quantidade;
	}
	
	public double calculaValor(Object o){
		if(o instanceof Motor){
			Motor p = (Motor) o;
			return p.valor *((0.7* p.getPotencia())+(0.003*p.getRpm()));
		}
		
		else if(o instanceof Parafuso){
			Parafuso p = (Parafuso) o;
			//float aux = p.valor * (Math.PI * ((p.getDiametro()/2)*(p.getDiametro()/2))  *  p.getComprimento());
			return  p.valor * (3.14 * ((p.getDiametro()/2)*(p.getDiametro()/2))*p.getComprimento());
		}
		return 0.0;		
	}
	

}