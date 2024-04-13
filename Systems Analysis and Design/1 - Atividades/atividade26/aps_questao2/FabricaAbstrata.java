package aps_questao2;

public abstract class FabricaAbstrata {
	
	public abstract MensagemLogon gerarMensagemLogon();
	public abstract MensagemLogout gerarMensagemLogout();
	
	public static FabricaAbstrata configurarInstancia(int codigoBanco) {
		if(codigoBanco == Banco.getCodigoItau()) return new FabricaItau();
		else if(codigoBanco == Banco.getCodigoBrandesco()) return new FabricaBradesco();
		else if(codigoBanco == Banco.getCodigoBb()) return new FabricaBB();
		else if(codigoBanco == Banco.getCodigoCaixa()) return new FabricaCaixa();
		return null;
	}
}
