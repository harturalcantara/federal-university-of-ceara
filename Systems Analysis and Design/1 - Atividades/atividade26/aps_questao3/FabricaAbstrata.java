package aps_questao3;

public abstract class FabricaAbstrata {
	
	public abstract MensagemLogon gerarMensagemLogon();
	public abstract MensagemLogout gerarMensagemLogout();
	
	public static FabricaAbstrata configurarInstancia(int codigoBanco) {
		if(codigoBanco == Banco.getCodigoItau()) return new FabricaItau();
		else if(codigoBanco == Banco.getCodigoBradesco()) return new FabricaBradesco();
		return null;
	}
}
