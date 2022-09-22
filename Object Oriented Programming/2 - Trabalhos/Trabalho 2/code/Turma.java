class Turma{
	//ATRIBUTOS
	int qtdAlunos =0;
	Aluno[] aluno = new Aluno[100] ;

	//METODOS

	//ADICIONAR ALUNO - OK;
	void adicionarAluno(Aluno alun){
		aluno[qtdAlunos++]= alun;
	}
	
	//RETORNA A QUANTIDA DE ALUNOS - OK;
	int quantidadeDeAluno(){
		return qtdAlunos;
	}

	//RETORNA A MEDIA GERAL DA TURMA - OK;
	double mediageral(){
		double soma =0;
		for (int i = 0; i < qtdAlunos ; i++ ) {
			soma += aluno[i].media();
		}
		return soma/qtdAlunos;
	}
	//BUSCANDO POR NOME DE UM ALUNO - OK;
	boolean buscaPorNome(String name){
		for (int i = 0; i < qtdAlunos; i++) {
			if (aluno[i].nome == name && aluno[i].status==true) {
				return true;
			}
		}
		return false;
	}

	//BUSCANDO ALUNO PELO CURSO - OK; (OBS: boolean CONSERTADO)
	void buscaPorCurso(String curse){
		for (int i = 0; i < qtdAlunos ; i++ ){
			if (aluno[i].curso == curse && aluno[i].status==true) {
				System.out.println(aluno[i].nome);
			}
		}
	}
	//TIRANDO A MEDIA DO CURSO PASSADO COMO PARAMETRO; - OK
	double mediaDoCurso(String curse){
		double soma = 0.0;
		int cont = 0;
		for (int i = 0; i < qtdAlunos ; i++ ){
			if (aluno[i].curso.equals(curse)) {
				soma += aluno[i].media();
				cont++;
			}
		}
		return soma/cont;
	}
	//METODO ATUALIZAR OS DADOS DO ALUNO - OK
	void atualizar(Aluno alun,String name,String curse,String mat){
		alun.nome = name;
		alun.curso = curse;
		alun.matricula = mat;
	}
	//REMOVER ALUNO - OK
	boolean remover(Aluno alu){
		alu.status=false;
		qtdAlunos--;
		return true;		
	}
	/*OBS:A FUNCAO REMOVER FAZ COM QUE O STATUS DO ALUNO SEJA FALSO OU SEJA 
	SE USA ALGUM METODOS BUSCA ELE NAO SERA EXIBIDO NOVAMENTE! SE FOR ACESSADO
	DIRETAMENTE IRA MOSTRAR O NOME E OS ADEMAIS...!
	
}	