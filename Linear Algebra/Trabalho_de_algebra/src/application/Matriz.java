package application;

import java.util.Scanner;







public class Matriz {
	
	
	int m = 2;
	int n = 2;
	double [][] mat; 
	public Matriz() {
		
	}
	public Matriz(int colun,int linha) {
		this.m =colun;
		this.n= linha;
		mat = new double[colun][linha];
	}
	/*public static Matriz geraMatriz(Integer m1,Integer m2) {
		Matriz A = new Matriz(m1,m2);
		
		Scanner in = new Scanner(System.in);
		
		for(int i = 0; i < m1; i++ ) {
			for(int j = 0; j < m2; j++) {
				A.mat[i][j] = in.nextDouble();
			}
		}
		return  A;
	}*/
	
	public void mostraMatriz(Matriz m){
		for(int i = 0; i < m.mat.length; i++) {
			for(int j = 0; j < m.mat.length; j++) {
				System.out.print(m.mat[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public int getM() {
		return m;
	}
	public int getN() {
		return n;
	}
	
	public Matriz plus(Matriz B) {
        Matriz A = this;
        if (B.m != A.m || B.n != A.n) {
           // AlertBox.displayIllegalMatrizDimensionWarning();
        }
        Matriz C = new Matriz(m, n);
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    C.mat[i][j] = A.mat[i][j] + B.mat[i][j];
        return C;
    }
	public Matriz times(Matriz B) {
        Matriz A = this;
        if (A.n != B.m) {
           // AlertBox.displayIllegalMatrizDimensionWarning();
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
        
        if (B.m != A.m || B.n != A.n) {
           // AlertBox.displayIllegalMatrizDimensionWarning();
        }
        Matriz C = new Matriz(m, n);
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    C.mat[i][j] = A.mat[i][j] - B.mat[i][j];

        return C;
    }
	public static double matrixDeterminant (double[][] matriz) {
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
	
	
	

}
