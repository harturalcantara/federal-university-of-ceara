package aps_questao1;



public class App {

	public static void main(String[] args) {
		
		Item listaItem[] = new Item[100];
		int current=0;
		listaItem[current++] = new Item(45, "Forno Microondas", 355, 1);
		listaItem[current++] = new Item(80, "Circulador de Ar", 125, 2);
		listaItem[current++] = new Item(82, "Televisao 14", 470, 1);
		
		
		
		CupomFiscal cupom1 =  new CupomFiscal.CupomFiscalBuilder("Americanas", "1113336550")
				.cpfConsumirdor("00000000000")
				.cnpjConsumidor("0000000")
				.dinheiroRecebido(1100)
				.listaItem(listaItem)
		        .build();
		
		Impressora.getInstance().imprimirNota(cupom1);
	}

}
