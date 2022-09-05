class Funcionario {
	String nome;
	String departamento;
	double salario;
	Data dtInicio;
	String rg;
	boolean status;

	void recebeAumento(double aumento) {
		salario += aumento;
	}

	double calculaGanhoAnual() {
		return 12 * salario;
	}

	void demitir() {
		status = false;
	}

	void transferir(String departamento) {
		this.departamento = departamento;
	}

	void mostrar() {
		System.out.println("Nome: " + nome);
		System.out.println("Departamento: " + departamento);
		System.out.println("Salário: " + salario);
		System.out.println("Data de Início: " + dtInicio.formatar());
		System.out.println("RG: " + rg);
		System.out.println("Status: " + status);
	}

	/*
	O que acontece se você tentar acessar um atributo diretamente na classe? Como,
	por exemplo:
		Funcionario.salario = 1234;
	Esse código faz sentido?
	Resposta: Não pois, Funcionario é um tipo, tem que ser uma referência!
	*/
}