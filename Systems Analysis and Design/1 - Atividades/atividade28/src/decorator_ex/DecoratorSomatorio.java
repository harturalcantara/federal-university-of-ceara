package decorator_ex;

public class DecoratorSomatorio extends Decorator
{
	
	public void operacao(int array[]){
		super.operacao(array);
		double m = calcularSomatorio(array);
		System.out.println("O somat�rio para a sequ�ncia �: "+ m);
	}
	
	double calcularSomatorio(int array[]){
		
		double s = 0;
		for(int i = 0; i < array.length;i++)
			s += array[i];
		return s;
		
	}
	
}