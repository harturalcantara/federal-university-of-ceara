package aps_questao1;

public abstract class PrototipoMedia {
	
	
	protected int array[] = null;

	public int []getArray() {
		return this.array;
	}

	public void setArray(int array[]) {
		this.array = array;
	}
	
	public abstract PrototipoMedia clonar();

	public abstract void calcularMedia();
	
}
