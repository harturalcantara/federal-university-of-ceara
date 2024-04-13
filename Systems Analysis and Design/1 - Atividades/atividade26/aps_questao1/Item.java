package aps_questao1;

public class Item {
	
	private int codigo;
	private String nome;
	private double valorUnitario;
	private int quantidade;
	
	public Item(int codigo, String nome, double valorUnitario, int quantidade){
		this.codigo = codigo;
		this.nome = nome;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}
	
	public double calculoValorTotal() {
		return this.quantidade * this.valorUnitario;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	
	
	
}
