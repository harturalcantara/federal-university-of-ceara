package br.ufc.crateus.aps.trabalhofinal.pessoas;

public class PessoaFisica extends Pessoa{

	private Date dateNascimento;
	private String cpf;
	private String funcao;

	public PessoaFisica(String nome, String cpf, String funcao,Date nascimento) {
		super(nome);
		this.cpf = cpf;
		this.funcao = funcao;
		this.dateNascimento = nascimento;

	}

	@Override
	public boolean validarDocumento() {
		return (cpf.length() == 14);
	}

	@Override
	public int calcularIdade() {
		return (dateNascimento.data() - dateNascimento.getAno());
	}

	@Override
	public void execute() {
		System.out.println("Pessoa Fisica");
	}

	public Date getDateNascimento() {
		return dateNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public String getFuncao() {
		return funcao;
	}

	@Override
	public  Pessoa getPessoa() {
		return this;
	}



	
		
	

}
