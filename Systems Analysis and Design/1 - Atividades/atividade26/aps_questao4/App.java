package aps_questao4;



public class App {
	public static void main(String[] args) {
		
		Fabrica abstracoes0 = new FabricaRefinada(new EmpresaA());
		Fabrica abstracoes1 = new FabricaRefinada(new EmpresaB());
        
		Fabrica[] fabricas = {abstracoes1, abstracoes0};
        
		for(Fabrica fabrica : fabricas)
            fabrica.operacao();
	}
}
