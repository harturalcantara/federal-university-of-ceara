package aps_questao2;

public class MensagemLogoutCaixa extends MensagemLogout {
	
	public MensagemLogoutCaixa() {}
	public MensagemLogoutCaixa(String logo, String mensagem) {
		super(logo, mensagem);
	}

	@Override
	public void mostraTelaGrafica() {
		System.out.println(getLogo() + " " + getMensagem());
	}
}
