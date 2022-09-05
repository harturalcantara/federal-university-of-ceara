class TestaCasa{
   public static void main(String[] args){
      Casa home = new Casa("Branco");
      
   
      //TESTANDO METODO CONSTRUTOR
      System.out.println("Cor da Casa por PADRAO:" + home.cor+ "\n");
      
      //TESTANDO METODO PINTAR
      home.pintar("Preto");
      System.out.println("Cor da casa:" + home.cor);
      
      
      
      
      
      Porta portaCasa1 = new Porta("Branco",2.0,0.8,0.05);
      Porta portaCasa2 = new Porta("Branco",2.0,0.8,0.05);
      Porta portaCasa3 = new Porta("Branco",2.0,0.8,0.05);
      //ADICIONANDO PORTAS;
      home.adicionarPorta(portaCasa1);
      home.adicionarPorta(portaCasa2);
      home.adicionarPorta(portaCasa3);
      
      //ABRINDO AS PORTAS QUE ESVAM FECHADAS;
      System.out.println("Porta 01:" + portaCasa1.abrir());
      System.out.println("Porta 02:" + portaCasa2.abrir());
      System.out.println("Porta 03:" + portaCasa3.abrir());
      
      //METODO PINTAR;
      home.pintar("Preto");
      System.out.println("Cor da Casa:" + home.cor);
      
      
      //QUANTAS PORTAS TEM NA CASA;
      System.out.println("Total de portas na Casa:" + home.totalDePortas());
      
   } 
}
