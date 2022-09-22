class Programa{
	
	public static void main(String[] args) {
		
		Turma turma = new Turma();

		Aluno aluno1 = new Aluno("hartur","cc");
		Aluno aluno2 = new Aluno("alimpio","cc");
		Aluno aluno3 = new Aluno("jvsouza","cc");
		Aluno aluno4 = new Aluno("jvlima","si");

		turma.adicionarAluno(aluno1);
		turma.adicionarAluno(aluno2);
		turma.adicionarAluno(aluno3);
		turma.adicionarAluno(aluno4);

	//SABENDO QUANTIDADE ALUNOS
		System.out.println ("Quantidade de alunos atualmente:"+ turma.quantidadeDeAluno());

	//Notas 1 pessoa
		aluno1.adicionarNota(7.0);
		aluno1.adicionarNota(7.0);
		aluno1.adicionarNota(7.0);
	//Notas 2 pessoa
		aluno2.adicionarNota(8.0);
		aluno2.adicionarNota(8.0);
		aluno2.adicionarNota(8.0);
	//Notas do Aluno3
		aluno3.adicionarNota(9.0);
		aluno3.adicionarNota(9.0);
		aluno3.adicionarNota(9.0);
	//Notas do Aluno4
		aluno4.adicionarNota(10.0);
		aluno4.adicionarNota(10.0);
		aluno4.adicionarNota(10.0);

	//Media do Aluno1
		System.out.println("Media do aluno1:"+aluno1.media());
	//Media geral da turma
		System.out.println ("Media geral da turma:"+turma.mediageral());
	//Buscando pelo nome do Aluno1
		System.out.println("Aluno foi:"+ turma.buscaPorNome("hartur"));
	//Buscando pelo Curso, se encotrar imprimira todos;
		System.out.println("Lista de alunos do curso de CC:");
		turma.buscaPorCurso("cc");
		System.out.println("Lista de alunos do Cursorso de SI:");
		turma.buscaPorCurso("si");
	//Buscando pelo curso e fazendo a media dos alunos daquele curso;
		System.out.println("Media do curso de CC:"+turma.mediaDoCurso("cc"));
	//ATUALIZANDO DADOS DO ALUNO1;
		turma.atualizar(aluno1,"RUTRAH","CC","403897");
		System.out.println(aluno1.nome);
		System.out.println(aluno1.curso);
		System.out.println(aluno1.matricula);
		
	//FUNCAO REMOVER
		System.out.println("REMOCAO DO ALUNO1 FOI:"+turma.remover(aluno1));
		System.out.println ("Quantidade de alunos atualmente:"+ turma.quantidadeDeAluno());
		//BUSCANDO NOVAMENTE O ALUNO REMOVIDO
		System.out.println("STATUS DO ALUNO: " + turma.buscaPorNome("hartur"));
		
	}	
}