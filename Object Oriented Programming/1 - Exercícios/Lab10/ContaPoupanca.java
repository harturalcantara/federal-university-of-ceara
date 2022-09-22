

package br.ufc.crateus.lab10;

public class ContaPoupanca extends Conta{
	
	

	public ContaPoupanca(Integer numero, double saldo) {
		super(numero, saldo);
	}

	@Override
	public void atualizar(double percentual)
	{	
		percentual = percentual*3;
		super.atualizar(percentual);
	}


}