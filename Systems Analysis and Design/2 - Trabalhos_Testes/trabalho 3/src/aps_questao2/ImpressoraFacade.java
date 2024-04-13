package aps_questao2;

public class ImpressoraFacade {
	private Painel painel = null;
	private Tinta tinta = null;
	private CaboUSB cabo = null;
	
	public ImpressoraFacade(Painel painel, Tinta tinta, CaboUSB cabo) {
		this.painel = painel;
		this.tinta = tinta;
		this.cabo = cabo;
	} 
	
	public void imprimir() {
		
		painel.inicia(); //
		cabo.read();
		cabo.load();
		
		painel.ler();
		painel.verifica();
		painel.escrever();
		
		tinta.re_calculo();
		painel.libera();
		cabo.libera();
		
	}
	
}
