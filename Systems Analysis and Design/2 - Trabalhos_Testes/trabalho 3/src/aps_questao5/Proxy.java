package aps_questao5;

public class Proxy implements Soma {

	SomaConcreto op = new SomaConcreto();
	
	@Override
	public void soma(double x, double y) {
		this.op.soma(x,y);
	}

}
