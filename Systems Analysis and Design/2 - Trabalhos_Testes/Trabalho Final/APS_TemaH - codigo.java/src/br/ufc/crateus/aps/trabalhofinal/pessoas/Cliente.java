package br.ufc.crateus.aps.trabalhofinal.pessoas;

public class Cliente extends Pessoa {
	private String tipo;
	private String cpf;
	private Date dataNascimento;
	public Cliente(String nome,String cpf ,String tipo,Date nascimento) {
		super(nome);
		this.tipo = tipo;
		if(validar(cpf)) {
		this.cpf = cpf;
		}
		this.dataNascimento = nascimento;

		
		
		
	}
	
	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	private boolean validar(String cpf) {
		if(cpf.length() == 14) {
			return true;
		}
		return false;
		
	}

	
	public String getTipo() {
		return tipo;
	}


	@Override
	public boolean validarDocumento() {
		return validar(cpf);
	}

	@Override
	public int calcularIdade() {
		// TODO Auto-generated method stub
		return (dataNascimento.data() - dataNascimento.getAno());
	}

	@Override
	public void execute() {
		System.out.println("Cliente");
	}

	@Override
	public Pessoa getPessoa() {
		
		return this;
	}


}
