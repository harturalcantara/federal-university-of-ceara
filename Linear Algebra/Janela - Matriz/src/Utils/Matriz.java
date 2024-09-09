package Utils;

public class Matriz {
    int n = 2; //linha da matriz
    int m = 2; //coluna da matriz
    public double [][] mat; 
    
    public Matriz() {}
    
    public Matriz(int linha, int coluna) {
        this.n = linha;
        this.m = coluna;
        mat = new double[linha][coluna];
    }
    
    /**Operacoes das matrizes.*/
    
    public Matriz plus(Matriz B) { /* Okay */
        Matriz A = this;
        Matriz C = new Matriz(m, n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C.mat[i][j] = A.mat[i][j] + B.mat[i][j];
        return C;
    }
    
    public Matriz minus(Matriz B) { /* Okay */
        Matriz A = this;
        Matriz C = new Matriz(n, m);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) 
                C.mat[i][j] = A.mat[i][j] - B.mat[i][j];
        return C;
    }
    
    public Matriz times(Matriz B) { /* Okay */
        Matriz A = this;
        Matriz C = new Matriz(A.m, B.n);
        for (int i = 0; i < C.m; i++)
             for (int j = 0; j < C.n; j++)
                 for (int k = 0; k < A.n; k++)
                    C.mat[i][j] += (A.mat[i][k] * B.mat[k][j]);
        return C;
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
    
    //Imprimir o elementos da matriz. /*Ok - by hartur*/
    public void impMatriz(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + "\t");
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
    
    
    
    
    
    
    //Okay
    
    
    
    
    public static Matriz geraMatriz(Matriz matriz,double elementos) {
            Matriz A = matriz;

            //Scanner in = new Scanner(System.in);

            for(int i = 0; i < A.getM(); i++ ) {
                    for(int j = 0; j < A.getN(); j++) {
                            A.mat[i][j] = elementos;
                    //	System.out.println(A.mat[i][j]);
                    }
            }
            return  A;
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
	
	public Matriz multiplicarEscalar(Matriz A, double escalar) { // Okay
            for (int i = 0; i < A.getN(); i++) {
                for (int j = 0; j < A.getM(); j++) {
                        A.mat[i][j] = escalar * A.mat[i][j];
                }
            }
            return A;
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


	
	public double determinante(int i, double[][] mtr) {

		if (mtr.length == 2) {
			double deter = mtr[0][0] * mtr[1][1] - mtr[0][1] * mtr[1][0];
			return deter;
		}
		
		double deter = 0;
		for (int j = 0; j < mtr.length; j++) {
			double[][] temp = this.SubMatriz(i, j, mtr);
			deter = deter + Math.pow(-1, i + j) * (mtr[i][j] * this.determinante(0, temp));
		}
		return deter;
	}
	
	public double[][] matrizAdjunta(double[][] mtr) {

		double[][] tempAdjunta = new double[mtr.length][mtr.length];

		for (int i = 0; i < tempAdjunta.length; i++) {
			for (int j = 0; j < tempAdjunta.length; j++) {
				
				double[][] temp = this.SubMatriz(i, j, mtr);
				
				double elementoAdjunto = Math.pow(-1, i + j) * this.determinante(0, temp);

				tempAdjunta[i][j] = elementoAdjunto;
			}

		}
		return tempAdjunta;

	}

	public double[][] transposta(double[][] mtr) {

		double[][] tempTransposta = new double[mtr[0].length][mtr.length];

		for (int i = 0; i < tempTransposta.length; i++) {
			for (int j = 0; j < tempTransposta[0].length; j++) {
				tempTransposta[i][j] = mtr[j][i];

			}

		}

		return tempTransposta;

	}

	public double[][] inversa(double[][] mtr) {

		if (this.determinante(0, mtr) == 0) {
			double[][] d = null;
			return d;
		} else {
			double deter = this.determinante(0, mtr);
			double[][] adjunta = this.matrizAdjunta(mtr);
			double[][] transp = this.transposta(adjunta);
			double[][] tempInv = new double[transp.length][transp[0].length];

			for (int i = 0; i < transp.length; i++) {
				for (int j = 0; j < transp[0].length; j++) {
					tempInv[i][j] = transp[i][j] / deter;

				}

			}
			return tempInv;

		}
	}
	
	public double[][] matCofatora(double[][] matriz){
		
		
		return matriz;
	}
	
	private double[][] SubMatriz(int i, int j, double[][] matriz) { //matriz cofatora

		double[][] temp = new double[matriz.length - 1][matriz.length - 1];

		int count1 = 0;
		int count2 = 0;

		for (int k = 0; k < matriz.length; k++) {
			if (k != i) {
				count2 = 0;
				for (int l = 0; l < matriz.length; l++) {
					if (l != j) {
						temp[count1][count2] = matriz[k][l];
						count2++;
					}
				}
				count1++;
			}
		}
		return temp;
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
