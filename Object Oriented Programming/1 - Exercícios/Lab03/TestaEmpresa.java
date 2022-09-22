class TestaEmpresa{
     
     public static void main(String[] args){
      Empresa java = new Empresa();
      Funcionario empregado1 = new Funcionario();
      
      
      
         Funcionario empregado2 = new Funcionario();
         Funcionario empregado3 = new Funcionario();
         //Empregado1
         java.adicionar(empregado1);
         empregado1.nome = "Hartur";
         empregado1.salario= 1000;
         //Empregado2
         empregado2.nome=("Alimpio");
         empregado2.salario= 2000;
         java.adicionar(empregado2);
         //Empregado3
         java.adicionar(empregado3);
         int r; 
         r = java.registroFuncionarios();
         System.out.println("Quantidade de Funcionario na empresa: "+ r);
         java.mostraEmpregados();
         System.out.println("\tO funcionario está na empresa:");
         java.contem(empregado1);
     }
     
}
