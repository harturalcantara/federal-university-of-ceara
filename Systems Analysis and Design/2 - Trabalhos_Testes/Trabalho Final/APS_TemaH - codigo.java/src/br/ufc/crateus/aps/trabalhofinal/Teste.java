package br.ufc.crateus.aps.trabalhofinal;

import java.util.Scanner;
import br.ufc.crateus.aps.trabalhofinal.coffes.CapuccinoCoffeeInstant;
import br.ufc.crateus.aps.trabalhofinal.coffes.Coffee;
import br.ufc.crateus.aps.trabalhofinal.coffes.FrenchPressCoffee;
import br.ufc.crateus.aps.trabalhofinal.coffes.GourmetCoffee;
import br.ufc.crateus.aps.trabalhofinal.fornecedores.CoffeOfHigh;
import br.ufc.crateus.aps.trabalhofinal.fornecedores.CoffeOfProviders;
import br.ufc.crateus.aps.trabalhofinal.fornecedores.GreenCoffee;
import br.ufc.crateus.aps.trabalhofinal.pessoas.Cliente;
import br.ufc.crateus.aps.trabalhofinal.pessoas.Date;
import br.ufc.crateus.aps.trabalhofinal.pessoas.Dono;
import br.ufc.crateus.aps.trabalhofinal.pessoas.Pessoa;
import br.ufc.crateus.aps.trabalhofinal.pessoas.PessoaFisica;;

final class Teste {
	private final void menu() {
		System.out.println("Bem-vindo ao Sistema de Franquias de Cafes");
		System.out.println("[1] - Para adicionar uma pessoa."); // okay
		System.out.println("[2] - Para adicionar um fornecedor.");
		System.out.println("[3] - Para adicionar um tipo de cafe no fornecedor.");
		System.out.println("[4] - Para adicionar um dono a franquia.");
		System.out.println("[5] - Para adicionar uma franquia de cafe.");
		System.out.println("[6] - Buscar por prefixos de tipos de cafes.");
		System.out.println("[7] - Buscar por um tipo de cafe.");
		System.out.println("[8] - Remover uma franquia");
		System.out.println("[9] - Atualizar uma franquia.");
		System.out.println("[10] - Para imprimir.");
		System.out.println("[0] - Sair.");
	}

	@SuppressWarnings("resource")
	public final void testeMain() {
		Invoker b = new Invoker();
		FranquiaDeCafe franquia;
		ColecaoDeFraquias<FranquiaDeCafe> franquias = new ColecaoDeFraquias<>(1);
		Fidelizacao fidelizacao = new Fidelizacao();
		CoffeOfProviders fornecedor = null;
		ListDonos donos = new ListDonos();

		int op = -1;
		while (op != 0) {

			menu();
			op = new Scanner(System.in).nextInt();
			

			switch (op) {

			case 1: {
				System.out.println("\n\n\n");

				System.out.println("*************Funcionario / Cliente da fraquia************");
				System.out.println("1 - Para adicionar cliente.");
				System.out.println("2 - Para adicionar funcionario.");
				int caso = new Scanner(System.in).nextInt();

				if (caso == 1) {
					System.out.println("Digite o dia/mes/ano a seguir:");
					Date dataPessoa = new Date(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(),
							new Scanner(System.in).nextInt());
					System.out.println("Digite o nome/cpf/sexo a seguir:");
					Pessoa clientes = new Cliente(new Scanner(System.in).next(), new Scanner(System.in).next(),
							new Scanner(System.in).next(), dataPessoa);
					b.addCliente(clientes);
					b.add(clientes);
				} else if (caso == 2) {
					System.out.println("Digite o dia/mes/ano a seguir:");
					Date dataPessoa = new Date(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(),
							new Scanner(System.in).nextInt());
					System.out.println("Digite o nome/cpf/cargo a seguir:");
					Pessoa funcionarios = new PessoaFisica(new Scanner(System.in).next(), new Scanner(System.in).next(),
							new Scanner(System.in).next(), dataPessoa);
					b.addFuncionario(funcionarios);
					b.add(funcionarios);
				}
				fidelizacao.add(b);
				System.out.println("\n\n\n");
				break;
			}
			case 2: {
				System.out.println("\n\n\n");
				System.out.println("************Fornecedores**************");
				System.out.println("1 - para adicionar do tipo CafeDasAltas (CoffeOfHigh)");
				System.out.println("2 - para adicionar do tipo CafeVerde (GreenCaffee)");

				int caso = new Scanner(System.in).nextInt();
				if (caso == 1) {
					System.out.println("Digite o nome do fornecedor CafeDasAltas:");
					fornecedor = new CoffeOfHigh(new Scanner(System.in).next());
				} else if (caso == 2) {
					System.out.println("Digite o nome do fornecedor CafeVerde:");
					fornecedor = new GreenCoffee(new Scanner(System.in).next());
				}
				System.out.println("\n\n\n");
				break;
			}
			case 3: {
				System.out.println("\n\n\n");
				System.out.println("************Tipos de cafes**************");
				int caso = 0;
				System.out.println("1 - para adicionar tipo de café (CapuccinoCoffeeInstant)");
				System.out.println("2 - para adicionar tipo de café (FrenchPressCoffee)");
				System.out.println("3 - para adicionar tipo de café (FilteredorDripCoffee)");
				System.out.println("4 - para adicionar tipo de café (GourmetCoffee)");
				caso = new Scanner(System.in).nextInt();

				if (caso == 1) {
					Coffee cafe = new CapuccinoCoffeeInstant(new Scanner(System.in).next(),
							new Scanner(System.in).nextDouble());

					fornecedor = new CoffeOfHigh();
					fornecedor.addNewCoffe(cafe);
					fornecedor = new GreenCoffee();
					fornecedor.addNewCoffe(cafe);
				} else if (caso == 2) {
					Coffee cafe = new FrenchPressCoffee(new Scanner(System.in).next(),
							new Scanner(System.in).nextDouble());
					fornecedor = new CoffeOfHigh();
					fornecedor.addNewCoffe(cafe);
					fornecedor = new GreenCoffee();
					fornecedor.addNewCoffe(cafe);
				} else if (caso == 3) {
					Coffee cafe = new GourmetCoffee(new Scanner(System.in).next(), new Scanner(System.in).nextDouble());
					fornecedor = new CoffeOfHigh();
					fornecedor.addNewCoffe(cafe);
					fornecedor = new GreenCoffee();
					fornecedor.addNewCoffe(cafe);
				}
				System.out.println("\n\n\n");
				break;
			}
			case 4: {
				System.out.println("\n\n\n");
				System.out.println("**************Dono da Franquia******************");
				System.out.println("Digite o dia/mes/ano a seguir:");
				Date dataPessoa = new Date(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(),
						new Scanner(System.in).nextInt());
				System.out.println("Digite o nome/cpf do Dono da franquia a seguir :");
				Dono dono = new Dono(new Scanner(System.in).next(), new Scanner(System.in).next(), dataPessoa);
				donos.addDonos(dono);
				System.out.println("\n\n\n");

				break;

			}
			case 5: {
				System.out.println("\n\n\n");
				System.out.println("***************Adicionar Franquia******************");
				System.out.println("(OBS: Insira fornecedores antes.)");
				System.out.println("Digite o CNPJ /registrador" + "/razao Social/nome fantasia/"
						+ "latitude/longitude/" + "enedereco/telefone  a seguir");
				franquia = new FranquiaDeCafe.Builder(new Scanner(System.in).next(), new Scanner(System.in).next(),
						new Scanner(System.in).next(), new Scanner(System.in).next())
								.latitude(new Scanner(System.in).nextDouble())
								.longitude(new Scanner(System.in).nextDouble()).endereco(new Scanner(System.in).next())
								.fidelizacao(fidelizacao).telefone(new Scanner(System.in).next()).donos(donos)
								.fornecedores(fornecedor).getBuilder();

				franquias.add(franquia);
				System.out.println("\n\n\n");
				break;
			}
			case 6: {
				System.out.println("********Busca por tipos de cafes com determinado prefixo*********");

				franquias.searchOfPrefix(new Scanner(System.in).next());
				System.out.println("\n\n\n");
				break;
			}
			case 7: {
				franquias.search(new Scanner(System.in).nextLine());
				
				
				break;
			}
			case 8: {
				System.out.println("********DIGITE O NOME FANTASIA DA FRANQUIA*********");
				franquias.remove(new Scanner(System.in).next());
				
				break;

			}
			case 9: {
				System.out.println("********ATUALIZAR DADOS FRANQUIAS*********");
				System.out.println("Digite o nome fantasia da franquia para atualizar.");
				
				String nome = new Scanner(System.in).nextLine();
				int x = franquias.getSearch(nome);
				
				if( x >= 0){
					System.out.println("[1] - cnpj."); // okay
					System.out.println("[2] - registro.");
					System.out.println("[3] - razaoSocial.");
					System.out.println("[4] - nomeFantasia.");
					System.out.println("[5] - latitude.");
					System.out.println("[6] - longitude.");
					System.out.println("[7] - endereco.");
					System.out.println("[8] - telefone.");
					int caso = new Scanner(System.in).nextInt();
					if (caso == 1) {
						System.out.println("Digite o cnpj novo.");
						franquias.franquia[x].setCnpj(new Scanner(System.in).next());
					}
					else if(caso == 2) {
						System.out.println("Digite o registro novo.");
						franquias.franquia[x].setRegistro(new Scanner(System.in).next());
					}
					else if(caso == 3) {
						System.out.println("Digite o razaoSocial novo.");
						franquias.franquia[x].setRazaoSocial(new Scanner(System.in).next());
					}
					else if(caso == 4) {
						System.out.println("Digite o nomeFantasia novo.");
						franquias.franquia[x].setNomeFantasia(new Scanner(System.in).next());
					}				
					else if(caso == 5) {
						System.out.println("Digite o latitude novo.");
						franquias.franquia[x].setLatitude(new Scanner(System.in).nextInt());
					}
					else if(caso == 6) {
						System.out.println("Digite o longitude novo.");
						franquias.franquia[x].setLongitude(new Scanner(System.in).nextInt());
					}
					else if(caso == 7) {
						System.out.println("Digite o endereco novo.");
						franquias.franquia[x].setEndereco(new Scanner(System.in).next());
					}
					else if(caso == 8) {
						System.out.println("Digite o telefone novo.");
						franquias.franquia[x].setTelefone(new Scanner(System.in).next());
					}
				}
				else
					System.out.println("Nome da Franquia invalido");
				break;
			}
			case 10: {
				System.out.println("\n\n\n");
				while(franquias.hasNext()) {
					System.out.println(franquias.next());
				}
				franquias.show();
				System.out.println("\n\n\n");
				break;
			}
			case 0: {
				System.err.println("SAIU");
				System.exit(op);
			}

			default:
				break;
			}

		}

	}
}
