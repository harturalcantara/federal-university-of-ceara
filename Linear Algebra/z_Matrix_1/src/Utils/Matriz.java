package Utils;

import Sistema.AlertBox;

public class Matriz {
    private static final double EPSILON = 1e-8;
    private int n = 2; //linhas.
    private int m = 2; //colunas.
    public double [][] mat; // matriz
    
    public Matriz() {}
        
    public Matriz(int linha,int colun) {
        this.m = colun;
        this.n = linha;
        mat = new double[colun][linha];
    }
    
    public static Matriz geraMatriz(Matriz matriz, double elementos) {
        Matriz A = matriz;
        for(int i = 0; i < A.getM(); i++ ) {
                for(int j = 0; j < A.getN(); j++) {
                    A.mat[i][j] = elementos;
                //	System.out.println(A.mat[i][j]);
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

    /**Operacoes*/
    //metodo para pegar os termos indepedentes da funcao
    public double[] covertArray(Matriz A, double[] b) {
        
        for(int i = 0; i < A.getN(); i++ ) {
            b[i] = A.mat[i][0];
        }
        return  b;
    }
    public Matriz covertMatriz(Matriz A, double[] b) {
        
        for(int i = 0; i < A.getN(); i++ ) {
           A.mat[i][0] =  b[i];
        }
        return  A;
    }
    
    /*metodo gauss retorna um vetor com as solucoes.*/
    //public double[] metGauss(double[][] A, Matriz B) {
    public Matriz metGauss(double[][] A, Matriz B) {    
        double[] b = new double[B.getN()];
        b = covertArray(B, b);
        
        
        int n = b.length;

        for (int p = 0; p < n; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;

            // singular or nearly singular
            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new ArithmeticException("Matrix is singular or nearly singular");
            }

            // pivot within A and b
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return covertMatriz(B,x);
    }
    
    
}