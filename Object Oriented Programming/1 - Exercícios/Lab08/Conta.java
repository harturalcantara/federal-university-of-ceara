public abstract class Conta implements Comparable {
	protected double saldo;

	public Conta(double saldo) {
		this.saldo = saldo;
	}	
	
	public double getSaldo() {
		return saldo;
	}
	
	public void depositar(double val) { //IllegalArgumentException
		if(val < 0){
				// throw new IllegalArgumentException("Você tentou depositar um valor negativo");
				throw new ValorInvalidoException(val);
			// try{
			// 	
			// 	}catch(Exception e){
			// 		System.out.println("Massa");
			// 	}

			}
		
		
		saldo += val;
	}
	

	public void sacar(double val) {
		saldo -= val;
	}

	protected void atualizar(double taxaSelic, double fator) {
		saldo += saldo * taxaSelic * fator;		
	}	

	public abstract void atualizar(double taxaSelic);

	@Override
    public int compareTo(Object o) {
		Conta conta = (Conta) o;
		return (int)(this.saldo -conta.saldo);
    }

}