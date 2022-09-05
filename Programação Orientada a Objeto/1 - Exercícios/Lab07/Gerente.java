class Gerente extends Funcionario implements Imprimivel{

	private String area;



	
	public Gerente(String nome, Data nascimento, float salario, String area){
		super(nome,nascimento,salario);
		this.area = area;
	}

	@Override
	public String toString(){
		return "Nome:" + nome + " " + "Data:"+ nascimento.formatar() + " " + "Salario:" + salario + " " + "Area:" + area;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof Gerente){
			Gerente p = (Gerente) o;
			return this.area.equals(p.area);
		}
		return false;
	}


	@Override
	public float calcularImposto(){
		return (this.salario/100)*5; 
	}


	@Override
	public void imprimeDados(){
		super.imprimeDados();
		System.out.println("Area do Gerente:"+ area);
		System.out.println("Imposto do Gerente"+ calcularImposto());
	}

}