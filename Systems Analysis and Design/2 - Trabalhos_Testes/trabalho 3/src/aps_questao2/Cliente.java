package aps_questao2;

public class Cliente {
	public static void main(String a[]){
		
		ImpressoraFacade imp = new ImpressoraFacade(new Painel(), new Tinta(), new CaboUSB());
		imp.imprimir();
		
	}
	/** Padr�o de projeto Facade
	 * Seguindo o mesmo modelo passado como exemplo, foi aplicado o padr�o de projeto Facade
	 * sobre um impressora, onde a impressora � composto pelo painel, a tinta, e caboUSB, 
	 * formando uma impressora, ap�s isso chamo metodo imprimir onde a impressora segue pas-
	 * sos para sua execu��o. 
	 * */
	
}
