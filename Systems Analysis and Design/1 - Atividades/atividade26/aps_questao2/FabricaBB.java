package aps_questao2;

public class FabricaBB extends FabricaAbstrata{
	@Override
	public MensagemLogon gerarMensagemLogon() {
		return new MensagemLogonBB();
	}
	@Override
	public MensagemLogout gerarMensagemLogout() {
		return new MensagemLogoutBB();
	}
}
