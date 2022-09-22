class TesteConta{
	public static void main(String[] args){



		ContaCorrente hartur = new ContaCorrente(1000.0);
		System.out.println(hartur.getSaldo());
		hartur.sacar(200);
		System.out.println(hartur.getSaldo());

		ContaCorrente harturEspecial = new ContaCorrenteEspecial(2000.0);
		System.out.println(harturEspecial.getSaldo());
		harturEspecial.sacar(200);
		System.out.println(harturEspecial.getSaldo());


	}
}