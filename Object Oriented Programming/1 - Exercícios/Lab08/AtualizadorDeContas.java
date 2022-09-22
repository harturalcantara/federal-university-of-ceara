class AtualizadorDeContas {
	private double saldoTotal = 0.0;
	private double selic;

	public AtualizadorDeContas(double selic) {
		this.selic = selic;
	}

	public void roda(Conta c) {
		System.out.println(c.getSaldo());
		c.atualizar(selic);
		System.out.println(c.getSaldo());

		saldoTotal += c.getSaldo();
	}

	public double getSaldoTotal() {
		return saldoTotal;
	}
}