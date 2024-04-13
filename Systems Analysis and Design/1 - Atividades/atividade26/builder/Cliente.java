package builder;

public class Cliente {
	
	public static void main(String args[]){

		Usuario usr =  new Usuario.UsuarioBuilder("Salt4Hookies", "1113336550")
		        .endereco("Fifty Street, 1000")
		        .informacoes("Watch the salt.")
		        .bairro("Salt District")
		        .cidade("Salt City")
		        .estado("Saltland")
				.dataNascimento("01/09/1979")
		        .build();
		
		Usuario usr2 =  new Usuario.UsuarioBuilder("Red Hat", "11133344409")
		        .dataNascimento("01/09/1979")
		        .endereco("Linus Street, 1000")
		        .bairro("Torvalds District")
		        .cidade("Linux")
		        .estado("Freeland")
		        .informacoes("Wath the I.T market way of business.")
		        .build();
		
		System.out.println("The End.");
		
	}
	
}
