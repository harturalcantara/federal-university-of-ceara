class ContaPoupanca extends Conta{

	@Override
	public void atualizar(double percentual){
		super.atualizar(3*percentual);
	}


}