class ContaCorrente extends Conta{



///METODOS OPERACIONAIS

	@Override
	public void depositar(double x){
		super.depositar(x - 0.10);
	}


	@Override
	public void atualizar(double percentual){
		super.atualizar(2 * percentual);
	}
}