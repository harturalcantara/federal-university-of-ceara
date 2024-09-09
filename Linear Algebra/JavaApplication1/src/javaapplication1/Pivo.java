/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author hartu
 */
public class Pivo {

	private double temp;
	private double tempLinha[];
	private int i, j = 0, m, qtdLinhas;

	public void pivoParcial(double a[][], double b[]) {
		qtdLinhas = a.length;

		// Determinar o elemento pivô para a coluna atual e reorganizar as
		// linhas

		m = j;
		for (i = j + 1; i < qtdLinhas; ++i) {
			if (Math.abs(a[i][j]) > Math.abs(a[m][j])) {
				m = i;
			}
		}
		if (m != j) {
			tempLinha = a[j];
			a[j] = a[m];
			a[m] = tempLinha;
			temp = b[j];
			b[j] = b[m];
			b[m] = temp;
		}
		return;
	}

}