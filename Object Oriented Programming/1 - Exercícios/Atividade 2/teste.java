class Teste{

	public static void main(String[] args) {
		Turma turma = new Turma();
		Aluno alu = new Aluno();
		alu.curso = "cc";
		alu.nome = "HarLimpi2*JV";
		turma.adicionarAluno(alu);
		alu.adicionarNota(10.0);
		alu.adicionarNota(8.0);
		alu.adicionarNota(9.3);
		System.out.println (alu.media());
		System.out.println (turma.quantidadeDeAluno());
		System.out.println (turma.media());
		System.out.println (turma.buscaPorNome("HarLimpi2*JV"));
		turma.buscaPorCurso("si");
	}
}