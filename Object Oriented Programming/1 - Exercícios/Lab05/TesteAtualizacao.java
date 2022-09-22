class TesteAtualizacao{
	public static void main(String[] args){
		Conta contaA = new Conta();

		AtualizadorDeContas atualizaContaA = new AtualizadorDeContas(10);

		contaA.setSaldo(1000);
		System.out.println("Saldo da contaA:" + contaA.getSaldo());

		contaA.depositar(200);
		contaA.sacar(100);
		System.out.println("Saldo da contaA:" + contaA.getSaldo());
		contaA.atualizar(-10);
		System.out.println("Saldo da contaA:" + contaA.getSaldo());

		atualizaContaA.roda(contaA);
		System.out.println("Total de somas feitas te o momento: " + atualizaContaA.getSaldoTotal());





	}
}