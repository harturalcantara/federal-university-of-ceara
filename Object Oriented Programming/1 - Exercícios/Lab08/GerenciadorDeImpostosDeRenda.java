class GerenciadorDeImpostosRenda{

    private double total;

    public void adicionar(Tributavel a){
        System.out.println("Tributavel: " + a);
        this.total += a.calcularTributos();
    }
   
    public double getTotal() {
        return total;
    }
}