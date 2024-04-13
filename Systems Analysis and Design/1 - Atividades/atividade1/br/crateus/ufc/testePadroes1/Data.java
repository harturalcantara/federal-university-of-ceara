package br.crateus.ufc.testePadroes1;

import java.util.Calendar;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	
	Data (int dia , int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public Integer getInt() {
		return Integer.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	}
	
	@Override
	public String toString() {
		return " Dia: " + dia + " Mes: " + mes + " Ano: " + ano;
	}
	
}
