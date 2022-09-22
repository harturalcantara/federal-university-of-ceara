package br.ufc.crateus.lab10;

public class TestaBanco {

	public static void main(String[] args) {
		
		Banco brasil = new Banco();
		
		Conta conta1 = new ContaCorrente(6 , 200.0);
		Conta conta2 = new ContaCorrente(5 , 100.0);
		Conta conta3 = new ContaCorrente(4 , 300.0);
		
		Conta conta4 = new ContaCorrente(3 , 500.0);
		Conta conta5 = new ContaCorrente(2 , 600.0);
		Conta conta6 = new ContaCorrente(1 , 700.0);
		
		
		
		brasil.adicionar(conta1);
		brasil.adicionar(conta2);
		brasil.adicionar(conta3);
		brasil.adicionar(conta4);
		brasil.adicionar(conta5);
		brasil.adicionar(conta6);
		
		
		System.out.println(conta1.compareTo(conta2));
		
		System.out.println("Não ordenado:");
		brasil.mostrar();
		System.out.println("Ordenado:");
		brasil.mostrarOrenado();
		

	}

}

