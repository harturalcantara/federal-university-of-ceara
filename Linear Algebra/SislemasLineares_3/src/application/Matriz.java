package application;



public class Matriz {
	
	int n = 2; //linhas.
	int m = 2; //colunas.
	
	public double [][] mat; 
	public Matriz() {}
	
	public Matriz(int linha, int colun) {
		this.n= linha;
		this.m =colun;
		mat = new double[linha][colun];
	}
	
	public static Matriz geraMatriz(Matriz matriz) {
		Matriz A = matriz;
		
		for(int i = 0; i < A.getM(); i++ ) {
			for(int j = 0; j < A.getN(); j++) {
				A.mat[i][j] = 1;
			}
		}
		return  A;
	}
	
	public void mostraMatriz(Matriz m){
		for(int i = 0; i < m.mat.length; i++) {
			for(int j = 0; j < m.mat.length; j++) {
				System.out.print(m.mat[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public int getN() {
		return n;
	}
	
	public int getM() {
		return m;
	}

	public Matriz plus(Matriz B) { /*Metodo para somar matrizes - Okay.*/
        Matriz A = this;
        Matriz C = new Matriz(m, n);
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    C.mat[i][j] = A.mat[i][j] + B.mat[i][j];
        return C;
    }
	
	public Matriz times(Matriz B) { /*Metodo para multiplicas matrizes. - verificar*/
        
		Matriz A = this;
        if (A.n != B.m) {
            //AlertBox.displayIllegalMatrixDimensionWarning();
        }
        Matriz C = new Matriz(A.m, B.n);
            for (int i = 0; i < C.m; i++)
                for (int j = 0; j < C.n; j++)
                    for (int k = 0; k < A.n; k++)
                        C.mat[i][j] += (A.mat[i][k] * B.mat[k][j]);
        return C;
    }
	public Matriz minus(Matriz B) {
		Matriz A = this;
        
          Matriz C = new Matriz(n, m);
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    C.mat[i][j] = A.mat[i][j] - B.mat[i][j];

        return C;
    }
	public double matrixDeterminant (double[][] matriz) {
		double temporary[][];
		double result = 0;

		if (matriz.length == 1) {
			result = matriz[0][0];
			return (result);
		}

		if (matriz.length == 2) {
			result = ((matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]));
			return (result);
		}

		for (int i = 0; i < matriz[0].length; i++) {
			temporary = new double[matriz.length - 1][matriz[0].length - 1];

			for (int j = 1; j < matriz.length; j++) {
				for (int k = 0; k < matriz[0].length; k++) {
					if (k < i) {
						temporary[j - 1][k] = matriz[j][k];
					} else if (k > i) {
						temporary[j - 1][k - 1] = matriz[j][k];
					}
				}
			}

			result += matriz[0][i] * Math.pow (-1, (double) i) * matrixDeterminant (temporary);
		}
		return (result);
	}
	public Matriz multiplicarEscalar(Matriz B, double escalar) {
		
		
		for (int i = 0; i < B.mat.length; i++) {
			for (int j = 0; j < B.mat[0].length; j++) {
				B.mat[i][j] = escalar * B.mat[i][j];
			}
		}
		return B;
	}
	public Matriz identidade(Matriz A) {
		for (int i = 0; i < A.mat.length; i++) {
			for (int j = 0; j < A.mat[0].length; j++) {
				A.mat[i][j] = 0;
				if (i == j) {
					A.mat[i][j] = 1;
				}
			}
		}
		return A;
	}

	public Matriz potencia(Matriz matr, int exp) {
		int i = 0;
		Matriz aux;
		aux = matr.times(matr);

		if (exp == 0)
			return identidade(matr);
		else if (exp == 1)
			return matr;
		else if (exp == 2)
			return aux;
		else if (exp > 2) {
			while (i < (exp - 2)) {
				aux = aux.times(matr);
				i++;
			}
		}
		return aux;
	}
	/*
	public Matriz inversa(Matriz mtr) {

		//if (this.determinante(0, mtr) == 0) {
			Matriz d = null;
			return d;
		//} else {
			//double deter = this.determinante(0, mtr);
			//double[][] adjunta = this.matrizAdjunta(mtr);
			//double[][] transp = this.transposta(adjunta);
			//double[][] tempInv = new double[transp.length][transp[0].length];

			//for (int i = 0; i < transp.length; i++) {
				//for (int j = 0; j < transp[0].length; j++) {
				//	tempInv[i][j] = transp[i][j] / deter;

				}

			//}
			//return tempInv;

		//}
	//}*/
	 public Matriz transpose() {
	        Matriz A = new Matriz(n, m);
	        for (int i = 0; i < m; i++)
	            for (int j = 0; j < n; j++)
	                A.mat[j][i] = this.mat[i][j];
	        return A;
	    }
	 public double determinante(int i, Matriz mtr) {

			if (mtr.mat.length == 2) {
				double deter = mtr.mat[0][0] * mtr.mat[1][1] - mtr.mat[0][1] * mtr.mat[1][0];

				return deter;
			}

			else {
				double deter = 0;

				for (int j = 0; j < mtr.mat.length; j++) {
					Matriz temp = this.SubMatriz(i, j, mtr);

					deter = deter + Math.pow(-1, i + j) * mtr.mat[i][j] * this.determinante(0, temp);

				}

				return deter;
			}

		}
	 private Matriz SubMatriz(int i, int j, Matriz matriz) {

			Matriz temp = new Matriz(matriz.mat.length - 1, matriz.mat.length -1);

			int count1 = 0;
			int count2 = 0;

			for (int k = 0; k < matriz.mat.length; k++) {
				if (k != i) {
					count2 = 0;
					for (int l = 0; l < matriz.mat.length; l++) {
						if (l != j) {
							temp.mat[count1][count2] = matriz.mat[k][l];

							count2++;
						}

					}

					count1++;
				}

			}

			return temp;

		}
	
	
	
	

}
