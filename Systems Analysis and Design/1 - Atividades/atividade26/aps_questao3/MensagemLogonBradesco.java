package aps_questao3;

public class MensagemLogonBradesco extends MensagemLogon {
	
	public MensagemLogonBradesco() {}
	public MensagemLogonBradesco(String logo, String mensagem) {
		super(logo, mensagem);
	}

	@Override
	public void mostraTelaGrafica() throws Exception {
		System.out.println(getLogo() + " " + getMensagem());
	}
}
