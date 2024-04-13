package aps_questao2;

public class MensagemLogonItau extends MensagemLogon {
	
	public MensagemLogonItau() {}
	public MensagemLogonItau(String logo, String mensagem) {
		super(logo, mensagem);
	}

	@Override
	public void mostraTelaGrafica() {
		System.out.println(getLogo() +" "+ getMensagem());
	}
}
