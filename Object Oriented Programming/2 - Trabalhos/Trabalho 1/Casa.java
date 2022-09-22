class Casa{
   //ATRIBUTOS
   String cor;
   Porta[] portas;
   int totalPortas;
   
   
   
   //METODO CONSTRUTOR
   Casa(String cor){
      this.cor = cor;
      portas = new Porta[10];
   }
   //METODOS OPERACIONAIS
   void pintar(String cor){
      this.cor = cor;
   }
   
   void adicionarPorta(Porta porta){
      portas[totalPortas]= porta;
      totalPortas++;
   }
   
   int totalDePortas(){
      return totalPortas;
   }
   
   int quantasPortasEstaoAbertas(){
      int cont=0;
      for(int i=0;i<totalPortas;i++){
         if(portas[i].estaAberta()){
            cont++;
         }
      
      }
      return cont;
   }

}
