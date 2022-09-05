public class ContaPoupanca extends Conta {

	public ContaPoupanca(double saldo) {
		super(saldo);
	}

	@Override
	public void atualizar(double p) {
		super.atualizar(p, 3.0);
	}
	
	@Override
	public String toString() {
		return "saldo: "+super.getSaldo();
	}
}