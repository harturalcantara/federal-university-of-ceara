package br.ufc.crateus.aps.trabalhofinal.grupo;

public class Starbucks extends Empresas {

	public Starbucks(String nome, String fundadores, String descricao, String endereco, String localizacao) {
		super(nome, fundadores, descricao, endereco, localizacao);
	}

	@Override
	public void imprimir() {
		System.out.println("Nome : "+getNome());
		System.out.println("Fundadores : "+getFundadores());
		System.out.println("Endereco : "+getEndereco());
		System.out.println("Localizacao : "+getLocalizacao());
		System.out.println("Descricao : "+getDescricao());
		
	}

	@Override
	public int anoDefundacao() {
		
		return 2002;
	}

	
}
