class ValorInvalidoException extends RuntimeException{
    
    ValorInvalidoException(double valor){
        super("Inválido: "+ valor);
    }
}