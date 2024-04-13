package aps_questao1;



public class CupomFiscal {
	public String nomeLoja; //atributo obrigatorio
	public String cnpj; 	//atributo obrigatorio
	public String cpfConsumidor;
	public String cnpjConsumidor;
	public double dinheiroRecebido;
	public Item listaItem[] = new Item[100];
	//public int listaCont=0;
	
	public CupomFiscal(CupomFiscalBuilder builder) {
		this.nomeLoja = builder.nomeLoja;
        this.cnpj = builder.cnpj;
        this.cpfConsumidor = builder.cpfConsumidor;
        this.cnpjConsumidor = builder.cnpjConsumidor;
        this.dinheiroRecebido= builder.dinheiroRecebido;
        this.listaItem = builder.listaItem;

	}
	
	public static class CupomFiscalBuilder{
		private String nomeLoja;
		private String cnpj;
		private String cpfConsumidor;
		private String cnpjConsumidor;
		private double dinheiroRecebido;
		private Item listaItem[];
		//private int listaCont=0;
		
		
		public CupomFiscalBuilder(String nomeLoja, String cnpj){
	            this.nomeLoja = nomeLoja;
	            this.cnpj = cnpj;
	    }
		
		public CupomFiscalBuilder cpfConsumirdor(String cpfConsumirdor){
			this.cpfConsumidor = cpfConsumirdor;
	        return this;
	    } 
		
		public CupomFiscalBuilder cnpjConsumidor(String cnpjConsumidor){
			this.cpfConsumidor = cnpjConsumidor;
	        return this;
	    } 
		
		public CupomFiscalBuilder dinheiroRecebido(double dinheiroRecebido){
			this.dinheiroRecebido = dinheiroRecebido;
	        return this;
	    } 
		
		public CupomFiscalBuilder listaItem(Item listaItem[]){
			this.listaItem = listaItem;
			//this.listaCont = tamList;
	        return this;
	    } 
		
        public CupomFiscal build(){
            return new CupomFiscal(this);
        }
	}
}
