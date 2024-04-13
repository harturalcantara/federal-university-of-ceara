package factorymethod;

public class PessoaFactory {
	
	private PessoaFactory(){};
	
	public static Pessoa facthoryMethod(String nome, String sexo) {
		if (sexo.equals("M"))
			return new Homem(nome);
		else if (sexo.equals("F"))
			return new Mulher(nome);
		else
			return null;
	}
	
}
