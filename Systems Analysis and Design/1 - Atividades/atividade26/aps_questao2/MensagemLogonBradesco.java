package aps_questao2;

public class MensagemLogonBradesco extends MensagemLogon{
	
	public MensagemLogonBradesco() {}
	public MensagemLogonBradesco(String logo, String mensagem) {
		super(logo, mensagem);
	}

	@Override
	public void mostraTelaGrafica() {
		System.out.println(getLogo() + " " + getMensagem());
	}
}
