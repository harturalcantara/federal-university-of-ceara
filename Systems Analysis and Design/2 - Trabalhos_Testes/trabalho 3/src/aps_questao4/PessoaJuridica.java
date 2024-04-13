package aps_questao4;

public class PessoaJuridica extends Pessoa {
	
	private String cnpj;
	private Data dataCriacao;
	
	PessoaJuridica(String nome, String cnpj, Data dataCriacao){
		super(nome);
		try {
			if(validarDocumento(cnpj)) this.cnpj = cnpj;	
			else throw new IllegalArgumentException("CNPJ INVALIDO!");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		this.dataCriacao = dataCriacao;		
	}
	
	@Override
	public String toString() {
		return "Nome: "+ super.getNome() + " CNPJ: " + cnpj + " Data de Criacao: " + dataCriacao;  
	}
	
	@Override 
	public int calcularIdade() {
		return (dataCriacao.getInt() - dataCriacao.getAno());
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (o != null) {
			PessoaJuridica p = (PessoaJuridica) o;
			if(this.cnpj.equals(p.getCnpj()))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean validarDocumento() {
		return (this.cnpj.length() == 18);
	}
	
	private boolean validarDocumento(String cnpj) {
		return (cnpj.length() == 18);
	}
	
	public boolean igual(String cnpj) {
		return cnpj.equals(cnpj);
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Data getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Data dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
