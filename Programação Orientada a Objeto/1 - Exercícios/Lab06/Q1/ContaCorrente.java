class ContaCorrente{
	protected double saldo;



	public ContaCorrente(double saldo){
		this.saldo = saldo;
	}


	void depositar(double deposito){
		this.saldo = saldo + deposito;
	}

	public void sacar(double x){
		this.saldo = this.saldo - x;
		this.saldo = saldo - (x*(5/100));
	}

	public void setSaldo(double saldo){
		this.saldo = saldo;
	}

	public double getSaldo(){
		return this.saldo;
	}

}