package facade_ex;

public class Cliente {

	public static void main(String a[]){
		ComputadorFacade desktop = new ComputadorFacade(new CPU(), new Memoria(), new HardDrive());
		desktop.ligarComputador();
	}
	
}
