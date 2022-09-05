class Conta{

	protected double saldo;



///METODO CONSTRUTOR
	/*
	Conta(double saldo){
		this.saldo = saldo;
	}
	*/
///METODOS OPERACIONAIS


 //METODOS SETS
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}




 //METODOS GETS
	public double getSaldo(){
		return this.saldo;
	}




 //METODOS NORMAIS
	public void depositar(double x){
		this.saldo = this.saldo + x;
	}
	public void sacar(double x){
		this.saldo = this.saldo - x;
	}
	public void atualizar(double percentual){
		double valor = (this.saldo/100)*percentual;
		this.saldo = this.saldo + valor;
	}

	/*
	public void atualizar(double percentual){
		saldo += saldo * 2 * p;
	}
	*/

}