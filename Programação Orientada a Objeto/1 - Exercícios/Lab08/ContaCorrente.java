public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente(double saldo) {
		super(saldo);
	}

	@Override
	public void atualizar(double p) {
		super.atualizar(p, 2.0);
	}

	@Override
	public void depositar(double val) {
		super.depositar(val - 0.10);
	}
	
	@Override
	public double calcularTributos() {
		return this.getSaldo()*0.01;
	}
	
	@Override
	public String toString() {
		return "saldo: "+super.getSaldo();
	}
	
}