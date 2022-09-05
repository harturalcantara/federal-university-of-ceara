class TesteItem{
	public static void main(String[] args){


		
		Parte teste = new Parte(12,"nome",0);
		Item carregador = new Item(2,teste);

		
		Parte carro = new Motor(10,"MotorA",100,30,20,11);
		Parte parafusoRedondo = new Parafuso (11,"Carito",40, 10,300);

		

		System.out.println(carro);
		System.out.println(parafusoRedondo);

		System.out.println(teste.calculaValor(carro));
		System.out.println(teste.calculaValor(parafusoRedondo));

		Item vendas = new Item(6,carro);

		System.out.println(carregador.calculaValor(carro));

	}
}