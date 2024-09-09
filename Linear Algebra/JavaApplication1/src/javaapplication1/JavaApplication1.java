package javaapplication1;

import java.util.Scanner;

/** 
 *  Classe para testes do trabalho final de Algebra Linear.
 * 
 * @author hartur_alcantara*/

public class JavaApplication1 {
    
    
    
    // troca a linha i com linha k
    static void troca(double[][] A, int i, int k, int j) {
        int m = A[0].length - 1;
        double temp;
        for (int q = j; q <= m; q++) {
            temp = A[i][q];
            A[i][q] = A[k][q];
            A[k][q] = temp;
        }
    }

    // divisao de linha i por A[i][j] Ex A12/A11
    static void divide(double[][] A, int i, int j) {
        int m = A[0].length - 1; //tamanho da linha da matriz
        for (int q = j + 1; q <= m; q++) {
            A[i][q] /= A[i][j]; //divide o primeiro elemento da linha com os proximos
        }
        A[i][j] = 1;
    }

    // subtrai elemento com a multipliccaÃ§Ã£o de elementos de outra linha Ex A22 - (A21*A12)
    static void elimina(double[][] A, int i, int j) {
        int n = A.length - 1; //linhas
        int m = A[0].length - 1; // colunas
        for (int p = 1; p <= n; p++) {
            if (p != i && A[p][j] != 0) {
                for (int q = j + 1; q <= m; q++) {
                    A[p][q] -= A[p][j] * A[i][q];
                }
                A[p][j] = 0;
            }
        }
    }

    // imprimi Matriz
//	static void printMatrix(double[][] A) {
//		int n = A.length - 1;
//		int m = A[0].length - 1;
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++)
//				out.print(A[i][j] + "  ");
//			out.println();
//		}
//		out.println();
//		out.println();
//	}
    public static double[][] metGauss(double[][] A) {

        int i = 0;
        int j = 0;
        int k=0;
        int n=3;
        int m=3;
        while (i < n && j < m) { // while de leitura de toda a matriz

            // procura por valor 0 em cada loop
            k = i;
            while (k < n && A[k][j] == 0) {
                k++;
            }

            if (k < n) {

                // se k for diferente de i, troca linha i com linha k
                if (k != i) {
                    troca(A, i, k, j);
                }

                // se A[i][j] nao Ã© 1, divide linha i por A[i][j]
                if (A[i][j] != 1) {
                    divide(A, i, j);
                }
                //faz operacao para zerar as linhas
                elimina(A, i, j);
                i++;
            }
            j++;
        }
        return A;
    }
    
    	public double[] resolve(double a[][], double b[]) {
		int qtdLinhas = a.length;
		int qtdColunas = a[0].length;

		// Determinar o elemento pivô para a coluna atual e reorganizar as
		// linhas

		Pivo pivo = new Pivo();
		pivo.pivoParcial(a, b);

		// Transforma a matriz a[][] em uma matriz diagonal superior pela
		// subtração de um multiplo da linha abaixo dela. Faz o mesmo com a
		// matriz b[][].

		for (int i = 0; i < qtdLinhas; ++i) {
			b[i] /= a[i][i];
			for (int j = qtdColunas - 1; j >= i; --j) {
				a[i][j] /= a[i][i];
			}

			for (int k = i + 1; k < qtdLinhas; ++k) {
				b[k] -= a[k][i] * b[i];
				for (int m = i + 1; m < qtdColunas; ++m) {
					a[k][m] -= a[k][i] * a[i][m];
				}
			}
		}

		// Resolve a matriz b[] com substituição backward. Os elementos da
		// matriz a[][] foram previamente normalizados para 1.

		for (int i = qtdLinhas - 2; i >= 0; --i) {
			for (int j = i + 1; j < qtdLinhas; ++j) {
				b[i] -= a[i][j] * b[j];
			}
		}

		return b;
	}
    
    

    public static void main(String[] args) {

        System.out.println("Digite a matriz 1: ");
        double[][] mat1 = new double[2][3];
        
        receberMat(mat1);
        imprimir(mat1);
        mat1 = metGauss(mat1);
        System.out.println("Nova matriz");
        imprimir(mat1);
        
        
        //double[][] mat2 = new double[2][2];
        //double[][] mat3 = new double[2][2];

        //Scanner scanner = new Scanner(System.in);

        
        
        
        
        

           
        /*METODO GAUSS*/
    }

    //OBS: The matriz 1, get the result;
    public static void somaMatriz(Double[][] mat1, Double[][] mat2) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1.length; j++) {
                mat1[i][j] = mat1[i][j] + mat2[i][j];
            }
            System.out.println();
        }
    }

    public static void subMatriz(Double[][] mat1, Double[][] mat2) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1.length; j++) {
                mat1[i][j] = mat1[i][j] - mat2[i][j];
            }
            System.out.println();
        }
    }

    public static void matrizOposta(Double[][] mat1) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1.length; j++) {
                mat1[i][j] = mat1[i][j] * (-1);
            }
            System.out.println();
        }
    }

    public static void multMatriz(Double[][] mab, Double[][] mat1, Double[][] mat2) {

//        //for(int i =0; i < mat1.length; i++){
//          ///  for(int j=0; j < mat1.length; j++){
//             //   mat1[j][j] = mat1[i][j] * mat2[i][j];
//            }
//            System.out.println();
//        }
        double sm = 0;
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1.length; j++) {
                sm = 0;
                for (int k = 0; k < mat1.length; k++) {
                    sm = sm + (mat1[i][k] * mat2[k][j]);
                }
                mab[i][j] = sm;
            }
        }
    }

    public static void imprimir(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " - ");
            }
            System.out.println();
        }
    }
    
    public static void receberMat(double[][] mat) {
        Scanner scanf = new Scanner(System.in);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = scanf.nextInt();
            }
            System.out.println();
        }
    }

}
