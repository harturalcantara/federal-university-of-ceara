public class Main{
    public static void main(String[] args) {

       Aleatorio randomico = new Aleatorio(10);

       for(int i=0; i<10; i++){
       		Aleatorio random = new Aleatorio(10);
       		System.out.println(random.getAleatorio());
       }
       System.out.println();
       System.out.println(randomico.getAleatorio());
       System.out.println(randomico.renovar());
    }
}