package application;

public class Gauss {
	private static double[][] matr; //matriz dos coeficientes
	private static double[] b; //vetor dos temos indepedentes
	private static double[] x; //
	
	public  double[][] getMatr() {
		return matr;
	}
	public  void setMatr(double[][] matr) {
		Gauss.matr = matr;
	}
	public  double[] getB() {
		return b;
	}
	public void setB(double[] b) {
		Gauss.b = b;
	}
	public  double[] getX() {
		return x;
	}
	public void setX(double[] x) {
		Gauss.x = x;
	}
	
	
}
