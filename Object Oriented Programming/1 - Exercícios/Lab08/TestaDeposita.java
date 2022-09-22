class TestaDeposita{
    public static void main(String[] args) {
        

        Banco banq = new Banco();
        Conta cc = new ContaCorrente(300);
        Conta cp = new ContaPoupanca(400);
        
      
        // Adicionar 
        banq.adicionar(cp);
        banq.adicionar(cc);
        
        //Depositar
       // cc.depositar(100);
        cp.depositar(200);
        
        //Tratando excecão
        try{
            cc.depositar(-100); //Passado valor inválido 
        }catch(Exception e){
            System.out.println("Valor inválido :(");
            System.out.println(e.getMessage());
        }
        System.out.println("==ORDENAR==");
        banq.ordenar();
        


    }
}