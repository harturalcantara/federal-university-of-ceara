package aps_questao1;

public class Impressora {

	private Impressora() {
	}

	private static final Impressora impressora = new Impressora();

	public void imprimirNota(CupomFiscal c) {
		System.out.println("\tMC ELETRODOMESTICOS");
		System.out.println("CNPJ: " + c.cnpj);
		// System.out.println("10/05/04"); //obs
		System.out.println("----------------------------------");
		System.out.println("CNPJ/CPF consumidor: " + c.cnpjConsumidor + "/" + c.cpfConsumidor);
		System.out.println("----------------------------------");
		System.out.println("\t CUPOM FISCAL");
		System.out.println("ITEM             " + "CODICO QTDxUNITARIO           " + " DESCRICAO VALOR(R$)");
		System.out.println("________________________________");

		double total = 0;

		// System.out.println(c.listaItem.length);

		/*
		 * for(int i=0; i< c.listaItem.length; i++) { System.out.println(i +
		 * c.listaItem[i].getCodigo()+" " + c.listaItem[i].getNome()+" "+
		 * c.listaItem[i].getQuantidade() + "x" +c.listaItem[i].getValorUnitario() +
		 * c.listaItem[i].calculoValorTotal() ); total = total +
		 * c.listaItem[i].calculoValorTotal(); }
		 */

		int i = 1;
		for (Item e : c.listaItem) {
			if (e != null) {
				System.out.println(i + e.getCodigo() + " " + e.getNome() + " " + e.getQuantidade() + "x"
				+ e.getValorUnitario() + e.calculoValorTotal());
				total = total + e.calculoValorTotal();
				i++;
			}
		}

		System.out.println("TOTAL RS \t" + total);
		System.out.println("VALOR RECEBIDO R$ \t" + c.dinheiroRecebido);
		System.out.println("TROCO RS \t" + (c.dinheiroRecebido - total));
	}

	public void imprimirNota(CupomFiscal c[]) {

		// for(int i=0; i< c.length; i++) imprimirNota(c[i]);

		for (CupomFiscal e : c) {
			imprimirNota(e);
		}

	}

	public static Impressora getInstance() {
		return impressora;
	}
}
