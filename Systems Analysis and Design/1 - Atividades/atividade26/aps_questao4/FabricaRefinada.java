package aps_questao4;

public class FabricaRefinada implements Fabrica{
	private Empresa empresa;
    
	public FabricaRefinada(Empresa empresa){
        this.empresa = empresa;
    }
	
	@Override
    public void operacao(){
    	empresa.operacaoConcreta();
    }
}
