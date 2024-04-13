package aps_questao3;

abstract class Decorador extends Forma{
	
	protected Forma componente;

	public void setComponente(Forma component) {
		this.componente = component;
	}
	
	
	public void operacao_area(int base, int altura) {
		if(componente!=null)
			componente.operacao_area(base, altura);
	}
}
