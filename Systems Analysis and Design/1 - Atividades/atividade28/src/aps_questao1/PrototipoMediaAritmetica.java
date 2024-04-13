package aps_questao1;

public class PrototipoMediaAritmetica extends PrototipoMedia {
	
	@Override
	public PrototipoMediaAritmetica clonar() {
		return new PrototipoMediaAritmetica(this);
	}

	public PrototipoMediaAritmetica(PrototipoMediaAritmetica prototipoMediaAritmetica) {
		this.array = prototipoMediaAritmetica.getArray();
	}

	public PrototipoMediaAritmetica(int array[]) {
		this.array = array;
	}

	@Override
	public void calcularMedia() {
		int array[] = this.array;
		int s = 0;
		for(int i = 0; i < array.length;i++) s += array[i];
		System.out.println("MediaArit: " + s/array.length);
	}
}
