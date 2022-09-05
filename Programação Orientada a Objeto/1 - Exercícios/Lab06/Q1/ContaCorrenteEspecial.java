class ContaCorrenteEspecial extends ContaCorrente{

	public ContaCorrenteEspecial(double saldo){
		super(saldo);
	}

	@Override
	public void sacar(double x){
		this.saldo = saldo - x;
		this.saldo = saldo - (x*(0.1/100));
	}


}