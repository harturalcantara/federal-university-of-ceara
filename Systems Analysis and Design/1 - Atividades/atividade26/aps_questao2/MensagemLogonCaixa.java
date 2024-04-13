package aps_questao2;

public class MensagemLogonCaixa extends MensagemLogon {

	public MensagemLogonCaixa() {}
	public MensagemLogonCaixa(String logo, String mensagem) {
		super(logo, mensagem);
	}

	@Override
	public void mostraTelaGrafica() {
		System.out.println(getLogo() +" "+ getMensagem());
	}	
}
