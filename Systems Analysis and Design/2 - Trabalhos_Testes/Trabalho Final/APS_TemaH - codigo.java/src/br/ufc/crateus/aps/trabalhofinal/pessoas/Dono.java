package br.ufc.crateus.aps.trabalhofinal.pessoas;

public class Dono extends Pessoa {
	private String cpf;
	private Date dataNascimento;

	public Dono(String nome, String cpf, Date nascimento) {
		super(nome);
		if (validar(cpf)) {
			this.cpf = cpf;
		}
		this.dataNascimento = nascimento;

	}

	@Override
	public boolean validarDocumento() {
		return validar(cpf);
	}

	private boolean validar(String cpf) {
		if (cpf.length() == 14) {
			return true;
		}
		return false;

	}

	@Override
	public int calcularIdade() {
		return (dataNascimento.data() - dataNascimento.getAno());
	}

	@Override
	public void execute() {
		System.out.println("Dono");
	}

	@Override
	public Pessoa getPessoa() {
		
		return this;
	}

}
