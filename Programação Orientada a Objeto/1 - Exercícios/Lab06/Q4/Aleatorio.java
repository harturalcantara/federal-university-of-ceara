
class Aleatorio{
    private java.util.Random rand = new java.util.Random();//System.currentTimeMillis()) - isso nao gerava numeros aleatorios;
    
    private static final int VALOR_MAXIMO_DEFAULT = 10;
    private int aleatorio;

    Aleatorio(int valorMaximo){
        this.aleatorio = valorMaximo;
        aleatorio = rand.nextInt(aleatorio);
    }
   	Aleatorio(){
      this(VALOR_MAXIMO_DEFAULT);
   	}

   	public int getAleatorio(){
   		return this.aleatorio;
   	}

  	public int renovar(){
       return aleatorio = rand.nextInt(aleatorio);
   	}



}