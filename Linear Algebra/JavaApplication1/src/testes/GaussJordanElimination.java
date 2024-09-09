package testes;

public class GaussJordanElimination {
    private static final double EPSILON = 1e-8;

    private final int N;      // N-by-N system
    private double[][] a;     // N-by-N+1 augmented matrix

    // Gauss-Jordan elimination with partial pivoting
    public GaussJordanElimination(double[][] A, double[] b) {
        
        N = b.length;

        // build augmented matrix
        a = new double[N][N+N+1];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = A[i][j];

        // only need if you want to find certificate of infeasibility (or compute inverse)
        for (int i = 0; i < N; i++)
            a[i][N+i] = 1.0;

        for (int i = 0; i < N; i++) a[i][N+N] = b[i];

        solve();

        assert check(A, b);
    }

    private void solve() {

        // Gauss-Jordan elimination
        for (int p = 0; p < N; p++) {
            // show();

            // find pivot row using partial pivoting
            int max = p;
            for (int i = p+1; i < N; i++) {
                if (Math.abs(a[i][p]) > Math.abs(a[max][p])) {
                    max = i;
                }
            }

            // exchange row p with row max
            swap(p, max);

            // singular or nearly singular
            if (Math.abs(a[p][p]) <= EPSILON) {
                continue;
                // throw new RuntimeException("Matrix is singular or nearly singular");
            }

            // pivot
            pivot(p, p);
        }
        // show();
    }

    // swap row1 and row2
    private void swap(int row1, int row2) {
        double[] temp = a[row1];
        a[row1] = a[row2];
        a[row2] = temp;
    }


    // pivot on entry (p, q) using Gauss-Jordan elimination
    private void pivot(int p, int q) {

        // everything but row p and column q
        for (int i = 0; i < N; i++) {
            double alpha = a[i][q] / a[p][q];
            for (int j = 0; j <= N+N; j++) {
                if (i != p && j != q) a[i][j] -= alpha * a[p][j];
            }
        }

        // zero out column q
        for (int i = 0; i < N; i++)
            if (i != p) a[i][q] = 0.0;

        // scale row p (ok to go from q+1 to N, but do this for consistency with simplex pivot)
        for (int j = 0; j <= N+N; j++)
            if (j != q) a[p][j] /= a[p][q];
        a[p][q] = 1.0;
    }

    // extract solution to Ax = b
    public double[] primal() {
        double[] x = new double[N];
        for (int i = 0; i < N; i++) {
            if (Math.abs(a[i][i]) > EPSILON)
                x[i] = a[i][N+N] / a[i][i];
            else if (Math.abs(a[i][N+N]) > EPSILON)
                return null;
        }
        return x;
    }

    // extract solution to yA = 0, yb != 0
    public double[] dual() {
        double[] y = new double[N];
        for (int i = 0; i < N; i++) {
            if ( (Math.abs(a[i][i]) <= EPSILON) && (Math.abs(a[i][N+N]) > EPSILON) ) {
                for (int j = 0; j < N; j++)
                    y[j] = a[i][N+j];
                return y;
            }
        }
        return null;
    }

    // does the system have a solution?
    public boolean isFeasible() {
        return primal() != null;
    }

    // print the tableaux
    private void show() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%8.3f ", a[i][j]);
            }
            System.out.printf("| ");
            for (int j = N; j < N+N; j++) {
                System.out.printf("%8.3f ", a[i][j]);
            }
            System.out.printf("| %8.3f\n", a[i][N+N]);
        }
        System.out.println();
    }


    // check that Ax = b or yA = 0, yb != 0
    private boolean check(double[][] A, double[] b) {

        // check that Ax = b
        if (isFeasible()) {
            double[] x = primal();
            for (int i = 0; i < N; i++) {
                double sum = 0.0;
                for (int j = 0; j < N; j++) {
                     sum += A[i][j] * x[j];
                }
                if (Math.abs(sum - b[i]) > EPSILON) {
                    System.out.println("not feasible");
                    System.out.printf("b[%d] = %8.3f, sum = %8.3f\n", i, b[i], sum);
                   return false;
                }
            }
            return true;
        }

        // or that yA = 0, yb != 0
        else {
            double[] y = dual();
            for (int j = 0; j < N; j++) {
                double sum = 0.0;
                for (int i = 0; i < N; i++) {
                     sum += A[i][j] * y[i];
                }
                if (Math.abs(sum) > EPSILON) {
                    System.out.println("invalid certificate of infeasibility");
                    System.out.printf("sum = %8.3f\n", sum);
                    return false;
                }
            }
            double sum = 0.0;
            for (int i = 0; i < N; i++) {
                sum += y[i] * b[i];
            }
            if (Math.abs(sum) < EPSILON) {
                System.out.println("invalid certificate of infeasibility");
                System.out.printf("yb  = %8.3f\n", sum);
                return false;
            }
            return true;
        }
    }


    public static void test(double[][] A, double[] b) {
        GaussJordanElimination gaussian = new GaussJordanElimination(A, b);
        if (gaussian.isFeasible()) {
            System.out.println("Solution to Ax = b");
            double[] x = gaussian.primal();
            for (int i = 0; i < x.length; i++) {
                System.out.printf("%10.6f\n", x[i]);
            }
        }
        else {
            System.out.println("Certificate of infeasibility");
            double[] y = gaussian.dual();
            for (int j = 0; j < y.length; j++) {
                System.out.printf("%10.6f\n", y[j]);
            }
        }
        System.out.println();
    }


    // 3-by-3 nonsingular system
    public static void test1() {
        double[][] A = {
            { 0, 1,  1 },
            { 2, 4, -2 },
            { 0, 3, 15 }
        };
        double[] b = { 4, 2, 36 };
        test(A, b);
    }

    // 3-by-3 nonsingular system
    public static void test2() {
        double[][] A = {
            {  1, -3,   1 },
            {  2, -8,   8 },
            { -6,  3, -15 }
        };
        double[] b = { 4, -2, 9 };
        test(A, b);
    }

    // 5-by-5 singular: no solutions
    // y = [ -1, 0, 1, 1, 0 ]
    public static void test3() {
        double[][] A = {
            {  2, -3, -1,  2,  3 },
            {  4, -4, -1,  4, 11 },
            {  2, -5, -2,  2, -1 },
            {  0,  2,  1,  0,  4 },
            { -4,  6,  0,  0,  7 },
        };
        double[] b = { 4, 4, 9, -6, 5 };
        test(A, b);
    }

    // 5-by-5 singluar: infinitely many solutions
    public static void test4() {
        double[][] A = {
            {  2, -3, -1,  2,  3 },
            {  4, -4, -1,  4, 11 },
            {  2, -5, -2,  2, -1 },
            {  0,  2,  1,  0,  4 },
            { -4,  6,  0,  0,  7 },
        };
        double[] b = { 4, 4, 9, -5, 5 };
        test(A, b);
    }

    // 3-by-3 singular: no solutions
    // y = [ 1, 0, 1/3 ]
    public static void test5() {
        double[][] A = {
            {  2, -1,  1 },
            {  3,  2, -4 },
            { -6,  3, -3 },
        };
        double[] b = { 1, 4, 2 };
        test(A, b);
    }

    // 3-by-3 singular: infinitely many solutions
    public static void test6() {
        double[][] A = {
            {  1, -1,  2 },
            {  4,  4, -2 },
            { -2,  2, -4 },
        };
        double[] b = { -3, 1, 6 };
        test(A, b);
    }

    // sample client
    public static void main(String[] args) {

        try                { test1();             }
        catch(Exception e) { e.printStackTrace(); }
        System.out.println("--------------------------------");
        
        try                { test2();             }
        catch(Exception e) { e.printStackTrace(); }
        System.out.println("--------------------------------");
        /*
        try                { test3();             }
        catch(Exception e) { e.printStackTrace(); }
        System.out.println("--------------------------------");

        try                { test4();             }
        catch(Exception e) { e.printStackTrace(); }
        System.out.println("--------------------------------");

        try                { test5();             }
        catch(Exception e) { e.printStackTrace(); }
        System.out.println("--------------------------------");

        try                { test6();             }
        catch(Exception e) { e.printStackTrace(); }
        System.out.println("--------------------------------");
        */
        /*
        // N-by-N random system (likely full rank)
        int N = Integer.parseInt(args[0]);
        double[][] A = new double[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = StdRandom.uniform(1000);
        double[] b = new double[N];
        for (int i = 0; i < N; i++)
            b[i] = StdRandom.uniform(1000);
        test(A, b);

        System.out.println("--------------------------------");
        */
        /*
        // N-by-N random system (likely infeasible)
        A = new double[N][N];
        for (int i = 0; i < N-1; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = StdRandom.uniform(1000);
        for (int i = 0; i < N-1; i++) {
            double alpha = StdRandom.uniform(11) - 5.0;
            for (int j = 0; j < N; j++) {
                A[N-1][j] += alpha * A[i][j];
            }
        }
        b = new double[N];
        for (int i = 0; i < N; i++)
            b[i] = StdRandom.uniform(1000);
        test(A, b);

            */
    }
}