class TesteBanco {
	public static void main(String[] args){
		Conta conta = new Conta();
		Conta contaCorrente = new ContaCorrente();
		Conta contaPoupanca = new ContaPoupanca();

		conta.saldo = 100;
		contaCorrente.saldo = 200;
		contaPoupanca.saldo = 300;

		System.out.println("Conta:"+conta.getSaldo());
		System.out.println("ContaCorrente:"+contaCorrente.getSaldo());
		System.out.println("contaPoupanca:"+contaPoupanca.getSaldo());

		Banco java = new Banco();

		java.adiciona(conta);
		java.adiciona(contaCorrente);
		java.adiciona(contaPoupanca);
		System.out.println(java.getQuantidadeDeContas());



	}

}