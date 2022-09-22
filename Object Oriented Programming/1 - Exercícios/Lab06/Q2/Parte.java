class Parte{
	protected int cod;
	protected String nome;
	protected float valor;


	public Parte(int cod, String nome , float valor){
		this.cod = cod;
		this.nome = nome;
		this.valor = valor;

	}


	public float calculaValor(Object o){
		if(o instanceof Motor){
			Motor p = (Motor) o;
			return p.valor;
		}
		
		else if(o instanceof Parafuso){
			Parafuso p = (Parafuso) o;
			return p.valor;
		}
		return 0;		
	}


	@Override
	public String toString(){
		return nome;
	}

}