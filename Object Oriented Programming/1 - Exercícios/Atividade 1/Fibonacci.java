class Fibonacci{
	public static void main(String[] args){
		System.out.println(Fib(7));
	}

	public static int Fib(int x){
		if(x==0) return 0;
		if(x==1) return 1;
		return Fib(x-1)+Fib(x-2);	
	}
}
