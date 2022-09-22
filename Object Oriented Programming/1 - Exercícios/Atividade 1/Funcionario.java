class Funcionario {
	String nome;	
	double salario;

	void recebeAumento(double aumento) {
		this.salario = this.salario + aumento;
	}

	double calculaGanhoAnual() {
		this.salario = this.salario*12;// o que fazer aqui dentro?
		return 0.0;
	}
}
