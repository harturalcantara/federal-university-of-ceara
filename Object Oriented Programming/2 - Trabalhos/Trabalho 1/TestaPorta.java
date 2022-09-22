class TestaPorta{
   public static void main(String[] args){
      Porta p1 = new Porta("Branco",2.0,0.8,0.05);
      
      //TESTANDO O METODO CONSTRUTOR;
      System.out.println("Cor da porta JÁ DEFINIDA: "+ p1.cor);
      //PINTANDO PORTA
      p1.pintar("Preto");
      System.out.println("Cor da porta1: "+ p1.cor);
      
      //ABRINDO A PORTA = RETORNA VERDADE
      System.out.println("A porta está aberta agora:(true)"+ p1.abrir());
      //ABRINDO A PORTA NOVAMENTE = RETORNA FALSO
      System.out.println("A porta já está aberta:(false)"+ p1.abrir());
      //FECHANDO PORTA = RETORNA TRUE;
      System.out.println("A porta está fechada agora:(true)"+ p1.fechar());
      //FACEHANDO PORTA NOVAMENTE = RETORNA FALSE;
      p1.fechar();
      System.out.println("A porta já está fechada:(false)"+ p1.fechar());
      //STATUS DA PORTA ATUAL
      System.out.println("Estado da porta:"+ p1.estaAberta());
   }

}
