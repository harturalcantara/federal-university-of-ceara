package br.ufc.crateus.cadastro;


import java.util.Scanner;

//import javax.swing.JOptionPane;

public class Programa{
	public static void main(String[] args){
		
		/*DADOS JÁ DEFINIDOS*/
		String arquivoInstitucao = "Instituição.txt";
		String dadosIsntituicao = Arquivo.Read(arquivoInstitucao);
		String conteudoInstituicao = dadosIsntituicao.split(";")[0];
		Instituicao ufc = new Instituicao(conteudoInstituicao);
		
		
		
		//LENDO ARQUIVO Cusos.txt
		String arquivoCursos= "Cusos.txt";
		String dadosCusos = Arquivo.Read(arquivoCursos);
		String ConteudoCc = dadosCusos.split(";")[0];
		String ConteudoSi = dadosCusos.split(";")[1];
		String ConteudoCp = dadosCusos.split(";")[2];
		String ConteudoEc = dadosCusos.split(";")[3];

		Curso cc = new Graduacao(ConteudoCc);
		Curso si = new Graduacao(ConteudoSi);
		Curso cp = new PosGraduacao(ConteudoCp);
		Curso ec = new PosGraduacao(ConteudoEc);


		String arquivoDisciplinas= "Disciplinas.txt";
		String dadosDisciplinas = Arquivo.Read(arquivoDisciplinas);
		String ConteudoPoo = dadosDisciplinas.split(";")[0];
		String ConteudoCalc = dadosDisciplinas.split(";")[1];
		String ConteudoAd = dadosDisciplinas.split(";")[2];
		String ConteudoArq = dadosDisciplinas.split(";")[3];
		
		Disciplina poo = new Disciplina(ConteudoPoo);
		Disciplina calc = new Disciplina(ConteudoCalc);
		Disciplina ad = new Disciplina(ConteudoAd);
		Disciplina arq = new Disciplina(ConteudoArq);
		

		String arquivoTurmas= "Turmas.txt";
		String dadosTurmas = Arquivo.Read(arquivoTurmas);
		String a = dadosTurmas.split(";")[0];
		String b = dadosTurmas.split(";")[1];
		String c = dadosTurmas.split(";")[2];
		String d = dadosTurmas.split(";")[3];
		String e = dadosTurmas.split(";")[4];
		String f = dadosTurmas.split(";")[5];
		String g = dadosTurmas.split(";")[6];
		String h = dadosTurmas.split(";")[7];
		
		Turma turmaA = new Turma(a, poo);
		Turma turmaB = new Turma(b, poo);
		
		Turma turmaC = new Turma(c, calc);
		Turma turmaD = new Turma(d, calc);
		
		Turma turmaE = new Turma(e, ad);
		Turma turmaF = new Turma(f, ad);
		
		Turma turmaG = new Turma(g, arq);
		Turma turmaH = new Turma(h, arq);

		
		String arquivoDatas= "Datas.txt";
		String dadosDatas = Arquivo.Read(arquivoDatas);
		int diaLiv = Integer.parseInt(dadosDatas.split(";")[0]), mesLiv = Integer.parseInt(dadosDatas.split(";")[1]), anoLiv = Integer.parseInt(dadosDatas.split(";")[2]);
		int diaLili = Integer.parseInt(dadosDatas.split(";")[3]), mesLili = Integer.parseInt(dadosDatas.split(";")[4]), anoLili = Integer.parseInt(dadosDatas.split(";")[5]);
		int diaFil = Integer.parseInt(dadosDatas.split(";")[6]), mesFil = Integer.parseInt(dadosDatas.split(";")[7]), anoFil = Integer.parseInt(dadosDatas.split(";")[8]);
		int diaRob = Integer.parseInt(dadosDatas.split(";")[9]), mesRob = Integer.parseInt(dadosDatas.split(";")[10]), anoRob = Integer.parseInt(dadosDatas.split(";")[11]);
		
		Data dataLivio = new  Data(diaLiv,mesLiv,anoLiv);
		Data dataLilian = new Data(diaLili,mesLili,anoLili);
		Data dataFelipe = new Data(diaFil,mesFil,anoFil);
		Data dataRoberto = new Data(diaRob,mesRob,anoRob);
		
		
		
		String arquivoProfessores= "Professores.txt";
		String dadosProfessores = Arquivo.Read(arquivoProfessores);
		String livNome = dadosProfessores.split(";")[0] ,livEndereco = dadosProfessores.split(";")[1],livCpf = dadosProfessores.split(";")[2],livRg = dadosProfessores.split(";")[3];
		double livSalario = Double.parseDouble(dadosProfessores.split(";")[4]);
		String liliNome = dadosProfessores.split(";")[5], liliEndereco = dadosProfessores.split(";")[6], liliCpf = dadosProfessores.split(";")[7] ,liliRg = dadosProfessores.split(";")[8];
		double liliSalario = Double.parseDouble(dadosProfessores.split(";")[9]);
		String felNome = dadosProfessores.split(";")[10], felEndereco = dadosProfessores.split(";")[11] ,felCpf = dadosProfessores.split(";")[12], felRg = dadosProfessores.split(";")[13];
		double felSalario = Double.parseDouble(dadosProfessores.split(";")[14]);
		String RobNome = dadosProfessores.split(";")[15], RobEndereco  = dadosProfessores.split(";")[16] ,RobCpf = dadosProfessores.split(";")[17], RobRg = dadosProfessores.split(";")[18];
		double RobSalario = Double.parseDouble(dadosProfessores.split(";")[19]);
		
		
		Professor livio = new Professor(livNome, dataLivio, livEndereco, livCpf, livRg, livSalario);
		Professor lilian = new Professor(liliNome, dataLilian, liliEndereco, liliCpf, liliRg, liliSalario);
		Professor filipe = new Professor(felNome, dataFelipe, felEndereco, felCpf, felRg, felSalario);
		Professor roberto = new Professor(RobNome, dataRoberto, RobEndereco, RobCpf, RobRg, RobSalario);
		


		ufc.adicionarCurso(cc);
		ufc.adicionarCurso(si);
		ufc.adicionarCurso(cp);
		ufc.adicionarCurso(ec);

		cc.adicionarTurma(turmaA);
		cc.adicionarTurma(turmaB);
		
		si.adicionarTurma(turmaC);
		si.adicionarTurma(turmaD);
		
		cp.adicionarTurma(turmaE);
		cp.adicionarTurma(turmaF);
		
		ec.adicionarTurma(turmaG);
		ec.adicionarTurma(turmaH);
		
		turmaA.adicionarProfessor(lilian);
		turmaB.adicionarProfessor(filipe);
		turmaC.adicionarProfessor(roberto);
		turmaD.adicionarProfessor(livio);
		turmaE.adicionarProfessor(lilian);
		turmaF.adicionarProfessor(filipe);
		turmaG.adicionarProfessor(roberto);
		turmaH.adicionarProfessor(livio);
		
		
		String arquivoAluno = "Alunos.txt";
		
		String dadosAlunos = Arquivo.Read(arquivoAluno);
		ufc.lerDoArquivo(dadosAlunos);
		
		
		int contadorMatricula = 999;
	    int op = -1, op1 = -1, op2 = -1, op3 = -1, op4 = -1;
		int contAluno = 0;
	    Menu menu = new Menu();
	    Scanner scanf = new Scanner(System.in);
	    scanf.useDelimiter(System.getProperty("line.separator"));
	     
	    while(op1 != 0){
	    	
	    	menu.principal();
			op1 = scanf.nextInt();
			
			if(op1 == 1){
				op2 = -1;
				while(op2 != 0){
					
					menu.inserir();
					op2 = scanf.nextInt();
					
					if(op2 == 1){

						String nome, endereco, cpf, rg;
						int matricula, dia, mes, ano;

						System.out.println("\n\n\t\tDigite os dados do aluno de Graduação");

						System.out.print("\t\tDigite o nome: ");
						nome = scanf.next();
						System.out.print("\t\tDigite o endereço: ");
						endereco = scanf.next();
						System.out.print("\t\tDigite o CPF: ");
						cpf = scanf.next();
						System.out.print("\t\tDigite o RG: ");
						rg = scanf.next();
						
						matricula = ++contadorMatricula;
	
						System.out.print("\t\tDigite o dia de nascimento: ");
						dia = scanf.nextInt();
						System.out.print("\t\tDigite o mes de nascimento: ");
						mes = scanf.nextInt();
						System.out.print("\t\tDigite o ano de nascimento: ");
						ano = scanf.nextInt();
						
						Data data = new  Data(dia,mes,ano);
						Aluno aluno = new Aluno(nome, data, endereco, cpf, rg, matricula, true);
						contAluno++;
						
						/*EXIBIR PARA O USUARIO OS CURSOS E TURMA QUE TEM!*/
						int qtdCursos = ufc.getTamanhoVetor(), contCurso = 0,contTurma = 0, qtdTurmas = 0;
						System.out.println("\t\tCursos de Graduação: \n");
						for(int i=0; i<qtdCursos; i++) {
							if(ufc.getCurso(i) instanceof Graduacao){
								contCurso++;
								System.out.println("\t\t" + contCurso + " - " + ufc.getCurso(i).getNome());
								
								qtdTurmas = ufc.getCurso(i).getTamanhoVetorTurma();
								contTurma=0;
								for(int j = 0; j<qtdTurmas; j++) {
									contTurma++;
									System.out.println("\t\t\t" +  contTurma + " - " + ufc.getCurso(i).getTurma(j).getNumeroDaTurma());
								}
							}
						}
						
						while(op3 != 0){	
							System.out.print("\n\t\tDigite o número do Curso: ");
							op3 = scanf.nextInt();
							if(op3 == 1){
								while(op4 != 0){
									
									System.out.print("\n\t\tDigite o numero da turma: ");
									op4 = scanf.nextInt();

									if(op4 == 1){
										turmaA.adicionarAluno(aluno);
										System.out.println("\t\tAluno de Graduação inserido com sucesso!");
										break;
									}
									if(op4 == 2){
										turmaB.adicionarAluno(aluno);
										System.out.println("\t\tAluno de Pós-Graduação inserido com sucesso!");
										break;
									}
								}
								break;
							}
							if(op3 == 2){
								while(op4 != 0){
									System.out.print("\n\t\tDigite o numero da turma: ");
									op4 = scanf.nextInt();
									if(op4 == 1){
										turmaC.adicionarAluno(aluno);
										System.out.println("\n\t\tAluno de Graduação inserido com sucesso!");
										break;
									}
									if(op4 == 2){
										turmaD.adicionarAluno(aluno);
										System.out.println("\n\t\tAluno de Pós-Graduação inserido com sucesso!");
										break;
									}
								}
								break;
							}
						}
						
						System.out.println("\n\n");

					}
					else if(op2 == 2){
						String nome, endereco, cpf, rg, graduacao, orientador;
						int matricula, dia, mes, ano;

						System.out.println("\t\tDigite os dados do aluno de Pós-Graduação");

						System.out.print("\t\tDigite o nome: ");
						nome = scanf.next();
						System.out.print("\t\tDigite a graduação que aluno: ");
						graduacao = scanf.next();
						System.out.print("\t\tDigite o nome do orientador: ");
						orientador = scanf.next();
						System.out.print("\t\tDigite o endereco: ");
						endereco = scanf.next();
						System.out.print("\t\tDigite o CPF: ");
						cpf = scanf.next();
						System.out.print("\t\tDigite o RG: ");
						rg = scanf.next();
						
						matricula = ++contadorMatricula;
						
						System.out.print("\t\tDigite o dia de nascimento: ");
						dia = scanf.nextInt();
						System.out.print("\t\tDigite o mes de nascimento: ");
						mes = scanf.nextInt();
						System.out.print("\t\tDigite o ano de nascimento: ");
						ano = scanf.nextInt();

						Data data = new  Data(dia,mes,ano);
						Aluno aluno = new AlunoPos(nome, data, endereco, cpf, rg, matricula, true, graduacao, orientador);
						contAluno++;
						int qtdCursos = ufc.getTamanhoVetor(), contCurso = 0,contTurma = 0, qtdTurmas = 0;
						System.out.println("\t\tCursos de Graduação e suas turmas disponíveis: \n");
						for(int i=0; i<qtdCursos; i++) {
							if(ufc.getCurso(i) instanceof PosGraduacao){
								contCurso++;
								System.out.println("\t\t" + contCurso + " - " + ufc.getCurso(i).getNome());
								
								qtdTurmas = ufc.getCurso(i).getTamanhoVetorTurma();
								contTurma=0;
								for(int j = 0; j<qtdTurmas; j++) {
									contTurma++;
									System.out.println("\t\t\t" +  contTurma + " - " + ufc.getCurso(i).getTurma(j).getNumeroDaTurma());
								}
							}
						}
						


						while(op3 != 0){	
							
							System.out.print("\n\t\tDigite o número do curso: ");
							op3 = scanf.nextInt();
							
							if(op3 == 1){
								while(op4 != 0){
									System.out.print("\n\t\tDigite o número da turma: ");
									op4 = scanf.nextInt();

									if(op4 == 1){
										turmaE.adicionarAluno(aluno);
										System.out.println("\n\t\tAluno de Pós-Graduação inserido com sucesso!");
										break;
									}
									if(op4 == 2){
										turmaF.adicionarAluno(aluno);
										System.out.println("\n\t\tAluno de Pós-Graduação inserido com sucesso!");
										break;
									}
								}
								break;
							}
							if(op3 == 2){
								while(op4 != 0){
									System.out.print("\n\t\tDigite o número da turma: ");
									op4 = scanf.nextInt();

									if(op4 == 1){
										turmaG.adicionarAluno(aluno);
										System.out.println("\n\t\tAluno de Pós-Graduação inserido com sucesso!");
										break;
									}
									if(op4 == 2){
										turmaH.adicionarAluno(aluno);
										System.out.println("\n\t\tAluno de Pós-Graduação inserido com sucesso!");
										break;
									}
								}
								break;
							}
						}

					}
					else if(op2 >= 3 || op2 < 0){
						System.out.println("\t\tOpção digitada invalida, digite novamente!");
					}
					else {
						System.out.println("\n\n");
					}
				}
			}
			else if(op1 == 2){
				op2 = -1;
				while(op2 != 0){
					
					menu.buscar();
					op2 = scanf.nextInt();
					
					if(op2 == 1){
						System.out.println("\n\n\t\tVocê selecionou a opção: [1] ");
						System.out.print("\t\tDigite o nome do aluno: ");
						String nome = scanf.next();
						Aluno alunoBuscado = ufc.busca(nome);
						
						if(alunoBuscado != null) {
							op3 = -1;
							System.out.println("\n\n\t\tDados do aluno: " + "["+alunoBuscado.getNome()+"]");
							System.out.println(alunoBuscado.toString());//imprimir junto o media
							
							while(op3 != 0) {
								
								 System.out.println("\t\t[1] - Atualizar dados do aluno");
								 System.out.println("\t\t[2] - Inserir notas do aluno");//colocar isso  no menu de inserir
								 System.out.println("\t\t[0] - Sair");
								 System.out.print("\n\n\t\tDigite uma opcao: ");
								 op3 = scanf.nextInt();
								 
								 if(op3 == 1) {
									 op4 = -1;
									 String strings;
									 int matricula;
									 while(op4 != 0) {
										 
										 menu.atualizar();
										 op4 = scanf.nextInt();
										 
										 if(op4 == 1) {
											 System.out.print("\t\tDigite o novo nome:");
											 strings = scanf.next();
											 alunoBuscado.setNome(strings);
										 }
										 else if(op4 == 2) {
											 int dia, mes, ano;
											 
											 System.out.print("\t\tDigite a nova data de nascimento");
											 System.out.print("\t\tDigite o dia: ");
											 dia = scanf.nextInt();
											 System.out.print("\t\tDigite o mes: ");
											 mes = scanf.nextInt();
											 System.out.print("\t\tDigite o ano: ");
											 ano = scanf.nextInt();

											Data data = new  Data(dia,mes,ano);
											alunoBuscado.setIdade(data);
										 }
										 else if(op4 == 3) {
											 System.out.print("\t\tDigite o novo endereço:");
											 strings = scanf.next();
											 alunoBuscado.setEndereco(strings);
										 }
										 else if(op4 == 4) {
											 System.out.print("\t\tDigite o novo CPF:");
											 strings = scanf.next();
											 alunoBuscado.setCpf(strings);
										 }
										 else if(op4 == 5) {
											 System.out.print("\t\tDigite o novo RG");
											 strings = scanf.next();
											 alunoBuscado.setRg(strings);
										 }
										 else if(op4 == 6) {
											 System.out.print("\t\tDigite o novo matricula");
											 matricula = scanf.nextInt();
											 alunoBuscado.setMatricula(matricula);
										 }
										 else if(op4 == 7) {
											double novaNota;
											while(op != 0) {	 
												
												menu.nota();
												 op = scanf.nextInt();
												 
												 if(op == 1) {
													 System.out.println("\t\tDigite a nova nota:");
													 novaNota = scanf.nextDouble();
													 System.out.println(novaNota);
													 alunoBuscado.setNotas(0,novaNota);
												 }
												 else if(op == 2) {
													 System.out.println("\t\tDigite a nova nota:");
													 novaNota = scanf.nextDouble();
													 alunoBuscado.setNotas(1,novaNota);
												 }
												 else if(op == 3) {
													 System.out.println("\t\tDigite a nova nota:");
													 novaNota = scanf.nextDouble();
													 alunoBuscado.setNotas(2,novaNota);
												 }
												 else if(op >= 4 || op <0) {
													 System.out.println("\t\tOpcao invalida! Digite novamente.");
												 }
											}
										 }
										 else if(op4 >= 8 || op4 <0 ) {
											 System.out.println("\t\tOpcao invalida! Digite novamente.");
										 }
									 }
								 }
								 else if(op3 == 2) {
									 System.out.println("\t\tDigite a do aluno nota:");
									 int result;
									 double nota = scanf.nextDouble();
									 
									 result = alunoBuscado.adicionarNota(nota);
									 
									 if(result == -1) {
										 System.out.println("\t\tNumero de notas possiveis atingido!");
									 }
								 }
								 
								 else if(op3 >= 4 || op3 < 0){
										System.out.println("\t\tOpção digitada inválida, digite novamente!");
								 }
							}
					
						}
						else {
							System.out.println("\n\t\tO nome não foi encontrado!");
						}

					}
					else if(op2 == 2){
						System.out.print("\t\tDigite o nome do curso: ");
						String nome = scanf.next();
						int result = ufc.buscaPorCurso(nome);
						
						if(result == -1) {
							System.out.println("\n\t\tO curso não foi encontrado!");
						}
					}
					else if(op2 >= 3 || op2 < 0){
						System.out.println("\t\tOpção digitada inválida, digite novamente!");
					}
					else{
						System.out.println("\n\n");
					}
				}
			}
			
			else if(op1 == 3){
				System.out.print("\t\tDigite o nome do aluno para ser removido: ");
				String nome = scanf.next();
				
				int result = ufc.remover(nome);
				if(result == 1) {
					System.out.println("\t\tAluno removido com sucesso!\n");
				}
				else {
					System.out.println("\t\tAluno não encontrado!\n");
				}
			}
			else if(op1 == 4) {
				op2 = -1;
				while(op2 != 0){
					
					menu. media();
					op2 = scanf.nextInt();
					
					if(op2 == 1) {
						System.out.println("\n\n\t\tMédia da UFC: "+ufc.media()+"\n");
					}
					else if(op2 == 2) {

						int qtdCursos = ufc.getTamanhoVetor();
						
						for(int i = 0; i<qtdCursos; i++) {
							System.out.println("\n\t\tCurso: " + ufc.getCurso(i).getNome() + "\n" + "\t\tMedia: " + ufc.mediaDoCurso(i) + "\n\n");
						}
					}
					else if(op2 == 3) {
						int qtdCursos = ufc.getTamanhoVetor();
						for(int i = 0; i<qtdCursos; i++) {
							for(int j = 0; j< ufc.getCurso(i).getTamanhoVetorTurma(); j++) {
								System.out.println("\n\t\tTurma: " + ufc.getCurso(i).getTurma(j).getNumeroDaTurma() + "\n" + "\t\tMedia: " + ufc.getCurso(i).getTurma(j).media() + "\n\n");
							}
						}
						
					}
					
					else if(op2 == 4){ /*EXIBIR PARA O USUARIO AS TURMAS QUE TEM, ESCOLHE A TURMA E EXIBE!*/
						
						System.out.println("\n\t\tDigite o nome do Curso:");
						String curso = scanf.next();
						int result = ufc.getCursoPosicao(curso);
						if(result == -1) {
							System.out.println("\n\t\tO curso não foi encontrado!");
						}
						else {	
							int contTurma = 0, qtdTurmas = 0;
							System.out.println("Minha posição do curso:" + result);
							qtdTurmas = ufc.getCurso(result).getTamanhoVetorTurma();
	
							for(int j = 0; j<qtdTurmas; j++) {
								contTurma++;
								System.out.println("\t\t\t"+ contTurma + " - " + ufc.getCurso(result).getTurma(j).getNumeroDaTurma());
								System.out.println("\t\tDeseja ver a média de todos os alunos desta turma?");
								System.out.println("\t\t[1] - Sim.");
								System.out.println("\t\t[0] - Não.");
								
								int veri = scanf.nextInt();
								if(veri == 1) {
									System.out.println("\t\tTurma:"+ ufc.getCurso(result).getTurma(j).getNumeroDaTurma()+"\n");
									System.out.println("\t\tMédia dos Alunos desta turma "+ ufc.getCurso(result).getTurma(j).toString()+":\n");
									
									for(int k = 0; k < ufc.getCurso(result).getTurma(j).getTamanhoAluno(); k++) {
										System.out.println(k+1 + "Aluno"+ufc.getCurso(result).getTurma(j).teste(k) );
									}
									break;
								}
								
							}
						}	
					}//FECHA
					else if(op2 > 4 || op2 < 0) {
						System.out.println("\t\tOpção digitada inválida, digite novamente!");
					}
				}
			}
			else if(op1 == 5){
				//System.out.println("\n\n\t\t[1] - Exibir dados da Instutuição.");
				
//				for(int i=0; i<ufc.getTamanhoVetor(); i++) {
//					System.out.println(ufc.toString());
//				}
				
//				System.out.println("\t\t[2] - Exibir dados dos Cursos.");
//				
//				for(int i=0; i<ufc.getTamanhoVetor(); i++) {
//					System.out.println(ufc.getCurso(i).toString2());
//				}
				
				System.out.println("\n\t\t==SISTEMA DE ALUNOS EM SUAS TURMAS==\n");
				for(int i=0; i<ufc.getTamanhoVetor(); i++) {
					
					for(int j=0; j<  ufc.getCurso(i).getTamanhoVetorTurma(); j++) {
							
						for(int k=0; k<  ufc.getCurso(i).getTurma(j).getTamanhoAluno(); k++) {
							
							System.out.println("" + ufc.getCurso(i).getTurma(j).toString());
						
						}
					}
				} 
			}
			else if(op1 > 5 || op1 < 0){
				System.out.println("\t\tOpção digitada inválida, digite novamente!");
			}
			else{
				System.out.println("\t\tAté mais!");
			}
	    }
	 
	    
	    ufc.gravarNoArquivo(arquivoAluno, contAluno);
	    
	    scanf.close();
	}

}