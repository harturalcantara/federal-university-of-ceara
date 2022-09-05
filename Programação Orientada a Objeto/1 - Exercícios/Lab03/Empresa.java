class Empresa{
   ///Atributos, -Variaveis sao inicializadas com letras minusculas;
   String nome;
   String cnpj;
   Funcionario[] empregados = new Funcionario[10];
   int qtdEmpregados=0;
   boolean status;    
   
   
   
   ///METODOS
   int registroFuncionarios(){
      return qtdEmpregados;
   }
   void adicionar(Funcionario empregado){
      empregados[qtdEmpregados++] = empregado;
   }
   
   
   
   int funcionariosAtivos(){
      int quantidade=0;
      for(int i=0;i<qtdEmpregados;i++){
         if(empregados[i].status==true){
            quantidade++;
         }
      }
      return quantidade;
   }
   void mostraEmpregados(){
      for(int i=0; i<qtdEmpregados;i++){
         System.out.println("Nome do Funcionario: "+ empregados[i].nome + "\nSalario desse Funcionario:"+ empregados[i].salario); 
      }
   
   }
   void contem(Funcionario nomex){
      for(int i=0;i<qtdEmpregados;i++){
         if(empregados[i]==nomex){
            System.out.println("Ele se encontra nesta Empresa!");
            break;
         }else
            System.out.println("Ele nao existe nesta Empresa!");  
      }
   }
   
   
   
   
   
   
}
