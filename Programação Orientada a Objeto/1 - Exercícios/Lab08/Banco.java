class Banco{
    private Conta contas[] = new Conta[10]; //vetor de 10 contas
    private int qtdContas;
   

    public void adicionar(Conta conta){
        contas[qtdContas++] = conta;
         
    }
    
    public void ordenar(){
        Conta[] c = new Conta[qtdContas];

        for(int i=0; i<qtdContas; i++){
            c[i]= contas[i];
        }

        java.util.Arrays.sort(c);
        this.imprimir(c);

	}
    
    public void imprimir(Conta[] a){

        for(int i=0; i<qtdContas;i++){
            System.out.println(a[i]);
        }

    }
}