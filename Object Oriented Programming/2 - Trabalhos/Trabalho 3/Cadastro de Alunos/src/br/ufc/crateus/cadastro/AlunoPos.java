package br.ufc.crateus.cadastro;

public class AlunoPos extends Aluno{
	
	private String graduacao;
	private String orientador;
	
	public AlunoPos(String nome, Data idade, String endereco, String cpf, String rg, int matricula, boolean status,String graduacao, String orientador) {
		super(nome, idade, endereco, cpf, rg, matricula, status);
		this.graduacao = graduacao;
		this.orientador = orientador;
	}

	@Override
	public String toString() {
		return super.toString() +"\n\t\tGraduação:" + graduacao +"\n\t\tOrientador: " + orientador + "\n";
	}
	
	public String gravarNoArquivo() {
		
		return super.getNome() + ";" + graduacao + ";" + orientador + ";" + super.getEndereco() + ";" + super.getCpf() + ";" + super.getRg() + ";" + super.getData();
		
	}
}
