package aps_questao2;

public class FabricaBradesco extends FabricaAbstrata {
	@Override
	public MensagemLogon gerarMensagemLogon() {
		return new MensagemLogonBradesco();
	}
	@Override
	public MensagemLogout gerarMensagemLogout() {
		return new MensagemLogoutBradesco();
	}
}
