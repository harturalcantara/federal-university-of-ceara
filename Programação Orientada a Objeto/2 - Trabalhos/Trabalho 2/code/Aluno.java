class Aluno {
	//ATRIBUTOS
	String nome;
	String matricula;
	String curso;
	double[] notas = new double[3];
	int quantidadeDeNotas=0;
	boolean status;

	//METODOS;
	Aluno(String nome,String curso){
		this.nome = nome;
		this.curso = curso;
		this.status = true;
	}
	//ADICIONANDO NOTAS AO ALUNO - OK;
	void adicionarNota(double nota){
		notas[quantidadeDeNotas++]=nota;
	}

	//CALCULANDO MEDIA DESTE ALUNO - OK;
	double media(){
		double soma = 0;
		for(int i=0 ; i< quantidadeDeNotas; i++){
			soma += notas[i];
		}
		return soma/quantidadeDeNotas;
	}

}