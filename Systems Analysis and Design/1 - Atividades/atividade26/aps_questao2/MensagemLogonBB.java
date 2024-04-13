package aps_questao2;

public class MensagemLogonBB extends MensagemLogon {

	public MensagemLogonBB() {}
	public MensagemLogonBB(String logo, String mensagem) {
		super(logo, mensagem);
	}
	
	@Override
	public void mostraTelaGrafica() {
		System.out.println(getLogo() + " " + getMensagem());
	}
}
