class Cliente extends Pessoa implements Imprimivel{
	protected int codigo;


	@Override
	public String toString(){
		return "Nome:"+ nome +"Data de nascimento: "+ nascimento.formatar() + "Codigo: " +  codigo;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof Cliente ){
			Cliente p = (Cliente) o;
			return this.codigo == p.codigo;
		}
		return false;
	}

	public Cliente(String nome, Data nascimento ,int codigo){
		super(nome,nascimento);
		this.codigo = codigo;
	}

	@Override
	public void imprimeDados(){
		super.imprimeDados();
		System.out.println("Codigo do Cliente: " + codigo);
	}
}
