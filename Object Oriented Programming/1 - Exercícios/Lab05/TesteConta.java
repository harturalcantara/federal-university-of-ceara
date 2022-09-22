class TesteConta{
	public static void main(String[] args){
		
		Conta contaA = new Conta();
		Conta cc = new ContaCorrente();
		Conta contaP = new ContaPoupanca();

		contaA.setSaldo(1000);
		System.out.println("Saldo da contaA:" + contaA.getSaldo());

		contaA.depositar(200);
		contaA.sacar(100);
		System.out.println("Saldo da contaA:" + contaA.getSaldo());
		contaA.atualizar(-10);
		System.out.println("Saldo da contaA:" + contaA.getSaldo());

		cc.setSaldo(2000);
		System.out.println("Conta cc" + cc.getSaldo());

		contaP.setSaldo(3000);
		System.out.println("Conta contaP" + contaP.getSaldo());


	} 	
}