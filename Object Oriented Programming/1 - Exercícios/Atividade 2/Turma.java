class Turma{
	
	int qtdAlunos =0;
	Aluno[] aluno = new Aluno[100] ;

	void adicionarAluno(Aluno alun){
		aluno[qtdAlunos++] = alun;
			
	}
	int quantidadeDeAluno(){
		return qtdAlunos;
	}
	double media(){
		double soma =0;
		for (int i = 0; i < qtdAlunos ; i++ ) {
			soma += aluno[i].media();
		}
		return soma / qtdAlunos;
	}
	String buscaPorNome(String name){
		for (int i = 0; i < qtdAlunos ; i++ ){
			if (aluno[i].nome == name) {
				return "O aluno esta no banco de dados";
			}
		}
		return "O aluno nao esta presente no nosso banco de dados";
	}
	void buscaPorCurso(String curse){
		for (int i = 0; i < qtdAlunos ; i++ ){
			if (aluno[i].curso == curse) {
				System.out.println(aluno[i].nome);
			}
		}
		return;
	}

}	