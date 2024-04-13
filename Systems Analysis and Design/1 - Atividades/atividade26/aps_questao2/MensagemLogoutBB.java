package aps_questao2;

public class MensagemLogoutBB extends MensagemLogout {
	
	public MensagemLogoutBB() {}
	public MensagemLogoutBB(String logo, String mensagem) {
		super(logo, mensagem);
	}

	@Override
	public void mostraTelaGrafica() {
		System.out.println(getLogo() + " " + getMensagem());
	}
}
