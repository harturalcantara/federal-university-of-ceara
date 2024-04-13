package aps_questao3;

public class Banco {
    
    private static final int CODIGO_ITAU = 10;
    private static final int CODIGO_BRADESCO = 11;
    
    private Banco() {}
    private static final Banco banco = new Banco();
    
    public static Banco getInstance() {
    	return banco;
    }

	public static int getCodigoItau() {
		return CODIGO_ITAU;
	}

	public static int getCodigoBradesco() {
		return CODIGO_BRADESCO;
	}

}
