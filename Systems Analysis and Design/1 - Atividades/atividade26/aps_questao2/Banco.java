package aps_questao2;

public class Banco {
    
    private static final int CODIGO_ITAU = 10;
    private static final int CODIGO_BRANDESCO = 11;
    private static final int CODIGO_BB = 12;
    private static final int CODIGO_CAIXA = 13;
    
    private Banco() {}
    private static final Banco banco = new Banco();
    
    public static Banco getInstance() {
    	return banco;
    }

	public static int getCodigoItau() {
		return CODIGO_ITAU;
	}

	public static int getCodigoBrandesco() {
		return CODIGO_BRANDESCO;
	}

	public static int getCodigoBb() {
		return CODIGO_BB;
	}

	public static int getCodigoCaixa() {
		return CODIGO_CAIXA;
	}

}
