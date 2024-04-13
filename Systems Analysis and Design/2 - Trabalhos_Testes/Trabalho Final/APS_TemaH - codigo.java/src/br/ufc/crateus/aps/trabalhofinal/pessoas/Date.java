package br.ufc.crateus.aps.trabalhofinal.pessoas;

import java.util.Calendar;

public class Date {
	private int mes;
	private int ano;
	private int dia;
	public Date(int dia,int mes,int ano) {
		if((dia > 0 && dia < 30) &&(mes > 0 && mes <= 12) && (ano > 0) ) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
		else {
			new IllegalAccessException("ERRO date invada!");
		}
	}
	
	@Override
	public String toString() {
		return   dia + "/" + mes + "/" + ano;
	}

	public int getDia() {
		return dia;
	}
	public int getMes() {
		return mes;
	}
	public int getAno() {
		return ano;
	}
	public Integer data() {
		return Integer.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		
	}
	
	

}
