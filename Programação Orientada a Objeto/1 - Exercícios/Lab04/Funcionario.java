class Funcionario {
	private String nome;
	private String departamento;
	private double salario;
	private Data dtInicio;
	private String rg;
	private boolean status = true;
	private int idUnico;
	public static int indenficador=0;

//METODO CONSTRUTOR
	Funcionario(String nome){
		indenficador++;
		this.nome = nome;
		this.idUnico = indenficador;
	}

//METODOS SET
	void setNome(String nome){
		this.nome = nome;
	}

	void setDepartamento(String departamento){
		this.departamento = departamento;
	}

	void setRG(Double salario){
		this.salario = salario;
	}
	//OBS
	void setData(Data data){
		this.dtInicio = data;
	}

	void setRG(String rg){
		this.rg = rg;
	}
	void setStatus(boolean status){
		this.status = status;
	}
///METODOS GETS
	int getIdUnico(){
		return this.idUnico;
	}

	String getNome(){
		return this.nome;
	}

	String getDepartamento(){
		return this.departamento;
	}

	double getSalario(){
		return this.salario;
	}
	//OBS
	Data getData(){
		return this.dtInicio;
	}
	String getRG(){
		return this.rg;
	}
	boolean getStatus(){
		return this.status;
	}
///METODOS OPERACIONAIS
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
