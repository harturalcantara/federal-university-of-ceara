class ThreadA {
  public static void main(String[] args){
          ThreadB b = new ThreadB();
          //THREAD B INICIA;
          b.start();
          //SINCRONISMO;
          synchronized(b){
              try{
                  System.out.println("Aguardando o b completar...");
                  b.wait();
              }catch(InterruptedException e){
                  e.printStackTrace();
              }
   
              System.out.println("Total é igual a: " + b.total);
              System.out.println("QUAL É O MEU NOME: " + b.h);
          } 
  }

}
   