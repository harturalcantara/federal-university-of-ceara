package aps_questao4;

public class PessoaFisica extends Pessoa{
	private String cpf;
	private Data dataNascimento;
	
	PessoaFisica(String nome, String cpf) {
		super(nome);
		try {
			if(validarDocumento(cpf)) this.cpf = cpf;	
			else throw new IllegalArgumentException("CPF INVALIDO!");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		return "Nome: " + super.getNome() + " CPF:" + this.cpf + " DataNascimento:" + this.dataNascimento;
	}

	@Override
	public boolean validarDocumento() {
		return this.cpf.length() == 11;
	}

	@Override 
	public int calcularIdade() {
		return (dataNascimento.getInt() - dataNascimento.getAno());
	}
	
	private boolean validarDocumento(String cpf) {
		return cpf.length() == 14; 
	} 
	
	@Override
	public boolean equals(Object o) {
		if (o != null) {
			PessoaFisica p = (PessoaFisica) o;
			if(this.cpf.equals(p.getCpf()))
				return true;
		}
		return false;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
