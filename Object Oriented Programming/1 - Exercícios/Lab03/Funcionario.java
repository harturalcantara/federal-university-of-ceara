class Funcionario {
	String nome;
	String departamento;
	double salario;
	Data dtInicio;
	String rg;
	boolean status = true;

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
}
