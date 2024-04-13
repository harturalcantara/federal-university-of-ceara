package decorator_ex;

abstract class Decorator extends Estatistics {
	
	protected Estatistics componente;

	public void setComponente(Estatistics component) {
		this.componente = component;
	}

	public void operacao(int array[]) {
		if (componente != null)
			componente.operacao(array);
	}
	
}