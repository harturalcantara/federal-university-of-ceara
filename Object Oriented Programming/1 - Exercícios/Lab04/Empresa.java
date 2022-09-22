class Empresa{
   //Atributos, - Variaveis sao inicializadas com letras minusculas;
   private String nome;
   private String CNPJ;
   private Funcionario[] empregados = new Funcionario[10];
   private int qtdEmpregados=0;

//METODO CONSTRUTOR


   //METODOS SETS
   void setNome(String nome){
      this.nome = nome;
   }

   void setCNPJ(String cnpj){
      this.CNPJ = cnpj;
   }

   //METODOS GETS
   String getNome(){
      return this.nome;
   }

   String getCNPJ(){
      return this.CNPJ;
   }

   int getRegistroFuncionarios(){
      return qtdEmpregados;
   }

   int getFuncionariosAtivos(){
      int quantidade=0;
      for(int i=0;i<qtdEmpregados;i++){
         if(empregados[i].getStatus()==true){
            quantidade++;
         }
      }
      return quantidade;
   }

   void getMostraEmpregados(){
      for(int i=0; i<qtdEmpregados;i++){
         System.out.println("Nome do Funcionario: "+ empregados[i].getNome() + "\nSalario desse Funcionario:"+ empregados[i].getSalario()); 
      }
   
   }

   void getContem(Funcionario nomex){
      for(int i=0;i<qtdEmpregados;i++){
         if(empregados[i]==nomex){
            System.out.println("TRUE - Ele se encontra nesta Empresa!");
         }else
            System.out.println("FALSE - Ele nao existe nesta Empresa!");  
      }
   }

   //METODOS NORMAIS
   void adicionar(Funcionario empregado){
      this.empregados[qtdEmpregados++] = empregado;
   }
  
   
   

}
