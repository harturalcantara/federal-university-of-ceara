package matrixgui.model;

import java.io.Serializable;
import java.util.Random;

/**
 * Class that is programming representation of the regular mathematical matrix
 * with most common used mathematical methods
 */
final public class Matrix implements Serializable {
    private final int M;
    private final int N;
    public final double[][] data;

    public int getM() {
        return M;
    }

    public int getN() {
        return N;
    }

    public double[][] getData() {
        return data;
    }

    /**
     * Constructor to create empty matrix with specified dimension
     * @param M   Number of rows
     * @param N   Number of columns
     */
    public Matrix(int M, int N) {
        if (M > 7 || N > 7) {
            AlertBox.displayIllegalMatrixDimensionWarning();
        }
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }

    /**
     * Constructor to create matrix based on 2-dim array
     * @param data  Dimensions with data
     */
    public Matrix(double[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                this.data[i][j] = data[i][j];
    }

    /**
     * Creates new Matrix from given Matrix
     * @param A  Matrix to copy from
     */
    private Matrix(Matrix A) {
        this(A.data);
    }


    /**
     * Creates Matrix with random numbers based on the specified dimension
     * @param rows      Number of rows
     * @param columns   Number of columns
     * @return          Matrix with random numbers with specified dimension
     */
    public static Matrix randomWithReservedState(int rows, int columns) {
        Random random = new Random();
        Matrix A = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                double result = createRandomDouble(1, 100);
                A.data[i][j] = result;
            }
        return A;
    }

    /**
     * Creates Matrix with random numbers from 2 to 6 dimensions
     * @return Matrix with random numbers from 2 to 6 dimensions
     */
    public static Matrix random() {
        Random random = new Random();
        int M = (int) createRandomDouble(2, 7);
        int N = (int) createRandomDouble(2, 7);
        Matrix A = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                double result = createRandomDouble(1, 100);
                A.data[i][j] = result;
            }
        return A;
    }

    /**
     * Creates random double number based on the specified range
     * @param start   Start of the range
     * @param end     End of the range
     * @return        Random double number based on the specified range
     */
    public static double createRandomDouble(int start, int end) {
        double randomDouble = new Random().nextDouble();
        return start + (randomDouble * (end - start));
    }


    /**
     * Creates transposed Matrix
     * @return transposed Matrix
     */
    public Matrix transpose() {
        Matrix A = new Matrix(N, M);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[j][i] = this.data[i][j];
        return A;
    }

    /**
     * Performs matrices math addition
     * @param B    Matrix to add
     * @return     Resulted Matrix
     */
    public Matrix plus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) {
            AlertBox.displayIllegalMatrixDimensionWarning();
        }
        Matrix C = new Matrix(M, N);
            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++)
                    C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }


    /**
     * Performs matrices math subtraction
     * @param B     Matrix to subtract
     * @return      Resulted Matrix
     */
    public Matrix minus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) {
            AlertBox.displayIllegalMatrixDimensionWarning();
        }
        Matrix C = new Matrix(M, N);
            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++)
                    C.data[i][j] = A.data[i][j] - B.data[i][j];

        return C;
    }

    /**
     * Performs matrices math multiplication
     * @param B     Matrix to multiply
     * @return      Resulted Matrix
     */
    public Matrix times(Matrix B) {
        Matrix A = this;
        if (A.N != B.M) {
            AlertBox.displayIllegalMatrixDimensionWarning();
        }
        Matrix C = new Matrix(A.M, B.N);
            for (int i = 0; i < C.M; i++)
                for (int j = 0; j < C.N; j++)
                    for (int k = 0; k < A.N; k++)
                        C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
    }

    /**
     * Performs matrices scalar multiplication
     * @param digit     Scalar
     * @return          Resulted Matrix
     */
    public Matrix timesNumber(double digit) {
        Matrix A = new Matrix(this.M, this.N);
        for (int i = 0; i < A.M; i++)
            for (int j = 0; j < A.N; j++)
                A.data[i][j] = this.data[i][j] * digit;
        return A;
    }

    /**
     * Calculates the biggest sum of each rows in the Matrix
     * @param A     Matrix to calculate
     * @return      Biggest sum of the row
     */
    public static double biggestInline(Matrix A) {
        double sum = 0;
        double sumLine = 0;
        for (int i = 0; i < A.M; i++) {
            for (int j = 0; j < A.N; j++) {
                sum = sum + A.data[i][j];
            }
            if (sumLine < sum) {
                sumLine = sum;
            }
            sum = 0;
        }
        return sumLine;
    }

    /**
     * Method to show matrix in the standard output (testing purposes)
     */
    public void show() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%9.4f ", data[i][j]);
            System.out.println();
        }
    }
}