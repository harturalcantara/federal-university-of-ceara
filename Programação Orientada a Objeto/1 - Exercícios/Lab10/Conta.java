package br.ufc.crateus.lab10;


public class Conta implements Comparable<Conta>{

	private Integer numero;
	protected double saldo;


	
	public Conta(Integer numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + "]";
	}

	public double getSaldo(){
		return this.saldo;
	}

	public void deposita(double deposito){
		this.saldo = this.saldo + deposito;
	}

	public void sacar(double saque){
		this.saldo = this.saldo - saque;
	}

	public void atualizar(double percentual){
		double valor = (this.saldo/100) * percentual;
		this.saldo = this.saldo + valor;
	}

	@Override
	public int compareTo(Conta conta) {
		return this.numero.compareTo(conta.numero);
	}
	

	
}

