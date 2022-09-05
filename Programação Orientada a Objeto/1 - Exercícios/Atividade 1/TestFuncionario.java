class TestFuncionario{
	public static void main(String[] args){
		Funcionario hartur;
		hartur = new Funcionario();
		hartur.nome = "HARTUR ALCANTARA";
		hartur.salario = 1000;
		hartur.recebeAumento(50);
		System.out.println("Nome: " + hartur.nome);
		System.out.println("Salario de hartur: " + hartur.salario);	
	}

}
