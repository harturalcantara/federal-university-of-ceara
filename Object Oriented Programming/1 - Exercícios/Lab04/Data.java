class Data {
	int dia;
	int mes;
	int ano;

	Data(int dia, int mes, int ano){
		//CASO ESPECIAS DE FEVEREIRO
		if(dia < 30 && dia >0 && mes==2){
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
		//VAMOS CONSIDERA TODOS OS MESES COM 30 DIAS, EXCETO FEVEREIRO PQ E ESPECIAL. EM RELACAO AO ANO MENOS DE 3000.
		if (mes>0 && mes <13 && dia > 0 && dia <31 && mes != 02){
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
	}

	String formatar() {
		return dia + "/" + mes + "/" + ano;
	}

}