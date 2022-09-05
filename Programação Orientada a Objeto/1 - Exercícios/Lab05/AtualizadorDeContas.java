class AtualizadorDeContas {
	private double saldoTotal = 0;
	private double selic;


	public AtualizadorDeContas(double selic){
		this.selic = selic;
	}

	public void roda(Conta c){
		//  aqui  voce  imprime o  saldo  anterior ,  atualiza a
		// conta ,  e  depois  imprime o  saldo  final
			System.out.println("--Saldo Anterior:" + c.getSaldo());
		// lembrando  de somar o  saldo  final  ao  atributo

			c.atualizar(selic);

			System.out.println("--Novo Saldo: " + c.getSaldo());
			saldoTotal += c.getSaldo();
	}

	public double getSaldoTotal(){
		return this.saldoTotal;
	}
	//  outros  metodos ,  colocar  o  g e t t e r  para  saldoTotal !

}