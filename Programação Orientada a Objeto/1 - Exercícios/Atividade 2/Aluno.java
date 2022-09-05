class Aluno {

	String nome;
	String matricula;
	String curso;
	double[] notas = new double[3];
	int quantidadeDeNotas=0;

	void adicionarNota(double nota){
		notas[quantidadeDeNotas++]=nota;
	}
	double media(){
		int soma = 0;
		for(int i=0 ; i< quantidadeDeNotas; i++){
			soma += notas[i];
		}
		return soma/quantidadeDeNotas;
	}

}