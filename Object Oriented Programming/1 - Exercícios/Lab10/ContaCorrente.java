package br.ufc.crateus.lab10;

public class ContaCorrente extends Conta{
	

	public ContaCorrente(Integer numero, double saldo) {
		super(numero, saldo);
	}



	@Override
	public void atualizar(double percentual){
		percentual = percentual*2;
		super.atualizar(percentual);
	}

	@Override
	public void deposita(double deposito){
		
		deposito = deposito - 0.10;
		super.deposita(deposito);
	
	}
}