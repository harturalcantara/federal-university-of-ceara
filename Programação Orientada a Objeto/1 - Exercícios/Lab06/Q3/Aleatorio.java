
class Aleatorio{

    private java.util.Random rand = new java.util.Random(System.currentTimeMillis());
    private static final int VALOR_MAXIMO_DEFAULT = 10;
    private int aleatorio;

    Aleatorio(int valorMaximo){
        this.valorMaximo = valorMaximo;
        aleatorio = rand.nextInt(valorMaximo);
    }
   Aleatorio(){
      this(VALOR_MAXIMO_DEFAULT);
   }
   public java.util.Random getAleatorios(){
       return rand; 
   }

}