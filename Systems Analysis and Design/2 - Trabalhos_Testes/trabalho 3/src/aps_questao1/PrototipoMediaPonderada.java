package aps_questao1;

public class PrototipoMediaPonderada extends PrototipoMedia{
	@Override
	public PrototipoMediaPonderada clonar() {
		return new PrototipoMediaPonderada(this);
	}

	public PrototipoMediaPonderada(PrototipoMediaPonderada prototipoMediaAritmetica) {
		this.array = prototipoMediaAritmetica.getArray();
	}

	public PrototipoMediaPonderada(int array[]) {
		this.array = array;
	}

	@Override
	public void calcularMedia() {
		int array[] = this.array;
		int numerador = 0, somaPesos = 0;
		for(int i = 0; i < array.length;i++) {
			numerador += (array[i] * i);
			somaPesos += i;
		}
		System.out.println("Media Ponderada: " + numerador/somaPesos);
	}
}
