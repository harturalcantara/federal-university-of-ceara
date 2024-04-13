package aps_questao2;

public class MensagemLogoutItau extends MensagemLogout{
	
	public MensagemLogoutItau() {}
	public MensagemLogoutItau(String logo, String mensagem) {
		super(logo, mensagem);
	}

	@Override
	public void mostraTelaGrafica() {
		System.out.println(getLogo() + " " + getMensagem());
	}
}
