package br.ufc.crateus.aps.trabalhofinal.grupo;
/*empresas e apenas o grupo de empresas */

public abstract class Empresas{

	private String nome;
	private String fundadores;
	private String descricao;
	private String endereco;
	private String localizacao;

	
	public Empresas(String nome, String fundadores, String descricao, String endereco, String localizacao) {
		super();
		this.nome = nome;
		this.fundadores = fundadores;
		this.descricao = descricao;
		this.endereco = endereco;
		this.localizacao = localizacao;
	}

	public abstract void imprimir();
	public abstract int anoDefundacao(); 
	public String getNome() {
		return nome;
	}

	public String getFundadores() {
		return fundadores;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getLocalizacao() {
		return localizacao;
	}

}
