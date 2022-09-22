class FuncionarioMain{
	public static void main(String[] args){


		Funcionario pessoa = new Funcionario("HARTUR");
		Data dtPessoa = new Data(5,6,2000);

		//pessoa.setNome("Hartur Alcantara");
		pessoa.setDepartamento("Ciencia da Computacao");
		pessoa.setRG("2008169676-5");
		pessoa.setData(dtPessoa);
		pessoa.setStatus(true);

		System.out.println("NOME:"+pessoa.getNome());
		System.out.println("DEPARTAMENTO:"+pessoa.getDepartamento());
		System.out.println("RG:"+ pessoa.getRG());
		System.out.println("STATUS:"+pessoa.getStatus());
		System.out.println("DATA DE NASCIMENTO:"+pessoa.getData().formatar());
		System.out.println("INDENTIFICADOR:"+ pessoa.getIdUnico());

		Funcionario pessoa1 = new Funcionario("ALIMPIO");
		Funcionario pessoa2 = new Funcionario("JVSOUZA");
		Funcionario pessoa3 = new Funcionario("CCARVALHO");
		Funcionario pessoa4 = new Funcionario("TALISON");

		System.out.println("INDENTIFICADOR PESSOA1:"+ pessoa1.getIdUnico());
		System.out.println("INDENTIFICADOR PESSOA2:"+ pessoa2.getIdUnico());
		System.out.println("INDENTIFICADOR PESSOA3:"+ pessoa3.getIdUnico());
		System.out.println("INDENTIFICADOR PESSOA4:"+ pessoa4.getIdUnico());

		System.out.println("INDENTIFICADOR PESSOA1 NOVAMENTE:"+ pessoa1.getIdUnico());

		Empresa java = new Empresa();
		java.adicionar(pessoa);
		java.setNome("JAVA DEITEL");
		java.setCNPJ("CIENCIA DA COMP");
		System.out.println("Nome da Empresa:"+java.getNome());
		System.out.println("CNPJ da Empresa:"+java.getCNPJ());
		System.out.println("QTS FUNCIONARIOS:"+ java.getRegistroFuncionarios());
		System.out.println("QTD DE FUNCIONARISO ATIVOS:"+java.getFuncionariosAtivos());
		System.out.println("--EMPREGADOS NA EMPRESA NOME E SALARIO:");
		java.getMostraEmpregados();
		System.out.println("--FUNCIONARIO ESTA NA EMPRESA:");
		java.getContem(pessoa);

     
	}
}