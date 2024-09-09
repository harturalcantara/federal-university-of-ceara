package Utils;

/**
 *
 * @author hartur alcantara
 */
public class Gauss {
    
    private static final double EPSILON = 1e-8;
    
    /*metodo para pegar os termos indepedentes da funcao*/
    public double[] covertArray(Matriz A, double[] b) {
        
        for(int i = 0; i < A.getN(); i++ ) {
            b[i] = A.mat[i][0];
        }
        return  b;
    }
    
    /*metodo gauss retorna um vetor com as solucoes.*/
    public double[] metGauss(double[][] A, double[] b) {
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
        return x;
    }
    
    
    
	private int qtdLinhas, qtdColunas;

	public double[] resolve(double a[][], double b[]) {
		qtdLinhas = a.length;
		qtdColunas = a[0].length;

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
}