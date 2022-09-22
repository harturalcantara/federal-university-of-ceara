class Porta{
   String cor;
   double altura;
   double largura;
   double profundidade;
   boolean aberta;
   
   Porta(String cor, double altura, double largura, double profundiade){
      this.cor = cor;
      this.altura = altura;
      this.largura = largura;
      this.profundidade = profundidade;
      
   }
   boolean abrir(){
      if(aberta==true){     
         return false;
      }
      else{
         aberta = true;
         return true;
      }
   }
   boolean fechar(){
      if(aberta==false){
         return false;
      }
      else{
         aberta = false;
         return true; 
      }  
   }
   void pintar(String cor){
      this.cor = cor;
   }
   boolean estaAberta(){
      return aberta;
   }




}
