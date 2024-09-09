package application;

public class GaussJordanElimination {
	private static final double EPSILON = 1e-8;

         int n; // n-by-n system
	 double[][] a; // n-by-(n+1) augmented matrix

	// Gauss-Jordan elimination with partial pivoting
	/**
	 * Solves the linear system of equations <em>Ax</em> = <em>b</em>, where
	 * <em>A</em> is an <em>n</em>-by-<em>n</em> matrix and <em>b</em> is a length
	 * <em>n</em> vector.
	 *
	 * @param A the <em>n</em>-by-<em>n</em> constraint matrix
	 * @param b the length <em>n</em> right-hand-side vector
	 */
	public GaussJordanElimination(double[][] A, double[] b) {
		n = b.length;

		// build augmented matrix
		a = new double[n][n + n + 1];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = A[i][j];

		// only needed if you want to find certificate of infeasibility (or compute
		// inverse)
		for (int i = 0; i < n; i++)
			a[i][n + i] = 1.0;

		for (int i = 0; i < n; i++)
			a[i][n + n] = b[i];

		solve();

		assert certifySolution(A, b);
	}

	private void solve() {

		// Gauss-Jordan elimination
		for (int p = 0; p < n; p++) {
			 //show(); 

			// find pivot row using partial pivoting
			int max = p;
			for (int i = p + 1; i < n; i++) {
				if (Math.abs(a[i][p]) > Math.abs(a[max][p])) {
					max = i;
				}
				

				 //show();
			}
			print(a);

			// exchange row p with row max
			swap(p, max);

			// singular or nearly singular
			if (Math.abs(a[p][p]) <= EPSILON) {
				continue;
				// throw new ArithmeticException("Matrix is singular or nearly singular");

			}
			 print(a);
			// pivot
			pivot(p, p);


		}
		 show();
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
		for (int i = 0; i < n; i++) {
			double alpha = a[i][q] / a[p][q];
			for (int j = 0; j <= n + n; j++) {
				if (i != p && j != q)
					a[i][j] -= alpha * a[p][j];
			//	System.out.print(" " + a[i][j] + " ");

			}
			System.out.println();
		}

		// zero out column q
		for (int i = 0; i < n; i++) {
			if (i != p)
				a[i][q] = 0.0;

			// scale row p (ok to go from q+1 to n, but do this for consistency with simplex
			// pivot)
			for (int j = 0; j <= n + n; j++) {
				if (j != q)

					a[p][j] /= a[p][q];

				a[p][q] = 1.0;
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * Returns a solution to the linear system of equations <em>Ax</em> =
	 * <em>b</em>.
	 * 
	 * @return a solution <em>x</em> to the linear system of equations <em>Ax</em> =
	 *         <em>b</em>; {@code null} if no such solution
	 */
	public double[] primal() {
		double[] x = new double[n];
		for (int i = 0; i < n; i++) {
			if (Math.abs(a[i][i]) > EPSILON)
				x[i] = a[i][n + n] / a[i][i];
			else if (Math.abs(a[i][n + n]) > EPSILON)
				return null;
		}
		return x;
	}

	/**
	 * Returns a solution to the linear system of equations <em>yA</em> = 0,
	 * <em>yb</em> &ne; 0.
	 * 
	 * @return a solution <em>y</em> to the linear system of equations <em>yA</em> =
	 *         0, <em>yb</em> &ne; 0; {@code null} if no such solution
	 */
	public double[] dual() {
		double[] y = new double[n];
		for (int i = 0; i < n; i++) {
			if ((Math.abs(a[i][i]) <= EPSILON) && (Math.abs(a[i][n + n]) > EPSILON)) {
				for (int j = 0; j < n; j++)
					y[j] = a[i][n + j];
				return y;
			}
		}
		return null;
	}

	private void print(double[][] matr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matr[j][i] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Returns true if there exists a solution to the linear system of equations
	 * <em>Ax</em> = <em>b</em>.
	 * 
	 * @return {@code true} if there exists a solution to the linear system of
	 *         equations <em>Ax</em> = <em>b</em>; {@code false} otherwise
	 */
	public boolean isFeasible() {
		return primal() != null;
	}

	// print the tableaux
	private void show() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%8.3f ", a[i][j]);
			}
			System.out.printf("| ");
			for (int j = n; j < n + n; j++) {
				/// System.out.printf("%8.3f ", a[i][j]);
			}
			System.out.printf("| %8.3f\n", a[i][n + n]);
		}
		System.out.println();
	}

	// check that Ax = b or yA = 0, yb != 0
	private boolean certifySolution(double[][] A, double[] b) {

		// check that Ax = b
		if (isFeasible()) {
			double[] x = primal();
			for (int i = 0; i < n; i++) {
				double sum = 0.0;
				for (int j = 0; j < n; j++) {
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
			for (int j = 0; j < n; j++) {
				double sum = 0.0;
				for (int i = 0; i < n; i++) {
					sum += A[i][j] * y[i];
				}
				if (Math.abs(sum) > EPSILON) {
					System.out.println("invalid certificate of infeasibility");
					System.out.printf("sum = %8.3f\n", sum);
					return false;
				}
			}
			double sum = 0.0;
			for (int i = 0; i < n; i++) {
				sum += y[i] * b[i];
			}
			if (Math.abs(sum) < EPSILON) {
				System.out.println("invalid certificate of infeasibility");
				System.out.printf("yb = %8.3f\n", sum);
				return false;
			}
			return true;
		}
	}
}
