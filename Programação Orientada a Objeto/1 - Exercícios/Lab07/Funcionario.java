class Funcionario extends Pessoa implements Imprimivel{
	protected float salario;




	

	public Funcionario(String nome, Data nascimento, float salario){
		super(nome,nascimento);
		this.salario = salario;
	}
	@Override
	public String toString(){
		return "Nome:"+nome +" "+ "Data:"+nascimento.formatar()+" "+ "Salario: " +  salario;
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof Funcionario ){
			Funcionario p = (Funcionario) o;
			return this.salario == p.salario;
		}
		return false;
	}



	public float calcularImposto(){
		return (this.salario/100)*3; 
	}

	@Override
	public void imprimeDados(){
		super.imprimeDados();
		System.out.println("Salario do Funcionario: " + salario);
		System.out.println("Imposto do Funcionario"+calcularImposto());
	}
}