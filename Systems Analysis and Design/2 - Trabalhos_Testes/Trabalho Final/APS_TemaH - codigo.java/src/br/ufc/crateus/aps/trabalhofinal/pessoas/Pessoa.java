package br.ufc.crateus.aps.trabalhofinal.pessoas;

public abstract class Pessoa implements Command {
	protected String nome;
	public Pessoa(String nome) {
		this.nome = nome;
	}

    public abstract boolean validarDocumento();
    public abstract int calcularIdade();
    public String getNome() {
    	return nome; 
    	
    }
    
    
	@Override
	public String toString() {
		return "nome : " + nome ;
	}
	
}
