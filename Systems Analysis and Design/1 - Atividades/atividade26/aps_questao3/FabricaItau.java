package aps_questao3;

public class FabricaItau extends FabricaAbstrata {
	@Override
	public MensagemLogon gerarMensagemLogon() {
		return new MensagemLogonItau();
	}
	@Override
	public MensagemLogout gerarMensagemLogout() {
		return new MensagemLogoutItau();
	}
}