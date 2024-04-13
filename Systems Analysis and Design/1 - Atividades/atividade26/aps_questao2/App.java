package aps_questao2;

public class App {
	public static void main(String[] args) throws Exception {

		//BANCO ITAU
		@SuppressWarnings("static-access")
		int codItau = Banco.getInstance().getCodigoItau();
		FabricaAbstrata fbs = FabricaAbstrata.configurarInstancia(codItau);

		MensagemLogon tlgn = fbs.gerarMensagemLogon();
		MensagemLogout sair = fbs.gerarMensagemLogout();

		tlgn.setLogo("ITAU - ");
		tlgn.setMensagem("BEM VIDO AO ITAU!");
		sair.setLogo("ITAU - ");
		sair.setMensagem("Adeus!");
		
		tlgn.mostraTelaGrafica();
		sair.mostraTelaGrafica();
		System.out.println();
		
		/*
		//BANCO BRADESCO
		@SuppressWarnings("static-access")
		int codBran = Banco.getInstance().getCodigoBrandesco();
		FabricaAbstrata lgBran = FabricaAbstrata.configurarInstancia(codBran);

		MensagemLogon branLog = lgBran.gerarMensagemLogon();
		MensagemLogout branLgt = lgBran.gerarMensagemLogout();

		branLog.setLogo("BRANDESCO - ");
		branLog.setMensagem("BEM VIDO A BRANDECO!");
		branLgt.setLogo("BRANDESCO - ");
		branLgt.setMensagem("ATE MAIS!");
		
		branLog.mostraTelaGrafica();
		branLgt.mostraTelaGrafica();
		
		System.out.println();
		//BANCO BB
		@SuppressWarnings("static-access")
		int codBB = Banco.getInstance().getCodigoBrandesco();
		FabricaAbstrata lgBB = FabricaAbstrata.configurarInstancia(codBB);

		MensagemLogon bbLog = lgBB.gerarMensagemLogon();
		MensagemLogout bbLgt = lgBB.gerarMensagemLogout();

		bbLog.setLogo("BB - ");
		bbLog.setMensagem("BEM VIDO A BB!");
		bbLgt.setLogo("BB - ");
		bbLgt.setMensagem("ATE MAIS!");
		
		bbLog.mostraTelaGrafica();
		bbLgt.mostraTelaGrafica();
		
		System.out.println();
		//BANCO CAIXA
		@SuppressWarnings("static-access")
		int codCA = Banco.getInstance().getCodigoBrandesco();
		FabricaAbstrata lgCA = FabricaAbstrata.configurarInstancia(codCA);

		MensagemLogon caLog = lgCA.gerarMensagemLogon();
		MensagemLogout caLgt = lgCA.gerarMensagemLogout();

		caLog.setLogo("CAIXA - ");
		caLog.setMensagem("VEM PRA CAIXA VC TBM!");
		caLgt.setLogo("CAIXA - ");
		caLgt.setMensagem("ATE MAIS!");
		
		caLog.mostraTelaGrafica();
		caLgt.mostraTelaGrafica();
*/
	}
}
