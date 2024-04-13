package br.crateus.ufc.teste1;

import java.util.ArrayList;
import java.util.List;

public class EstadioCopa {
	private int T;
	private int N;
	private List <Times> times = new ArrayList<Times>();
	
	public int getT() {
		return this.T;
	}
	public int getN() {
		return this.N;
	}
	
	public void setT(int T) {
		this.T = T;
	}
	public void setN(int N) {
		this.N = N;
	}
	public List <Times> getTimes() {
		return times;
	}
	public void setTimes(List <Times> times) {
		this.times = times;
	}
}
