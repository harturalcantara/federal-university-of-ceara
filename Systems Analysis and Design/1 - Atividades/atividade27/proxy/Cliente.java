package padrao.estrutural.proxy;

public class Cliente {

	public static void main(String[] args) throws Exception{
		
		Operador opr = new Proxy();
		opr.operacao();
		
		
	}
}
