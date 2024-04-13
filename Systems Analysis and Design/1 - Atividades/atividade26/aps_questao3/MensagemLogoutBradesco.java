package aps_questao3;

public class MensagemLogoutBradesco extends MensagemLogout{
	
	public MensagemLogoutBradesco() {}
	public MensagemLogoutBradesco(String logo, String mensagem) {
		super(logo, mensagem);
	}

	@Override
	public void mostraTelaGrafica() {
		System.out.println(getLogo() + " " + getMensagem());
	}
}
