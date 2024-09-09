package matrixgui.model;

//import static org.junit.Assert.*;

public class MatrixTest {
    //@org.junit.Test
    public void transpose() throws Exception {
        Double randomDouble = Matrix.createRandomDouble(1, 10000);
        double[][] d = {{ 1, randomDouble}, { 3, 4} };
        Matrix testMatrix = new Matrix(d);
        Matrix matrix = testMatrix.transpose();
        assertEquals(randomDouble, matrix.data[1][0], 0);
    }

    //@org.junit.Test
    public void plus() throws Exception {
        Double randomDouble = Matrix.createRandomDouble(1, 10000);
        double[][] d = {{ 1, 2}, {randomDouble, 4} };
        Matrix testMatrix = new Matrix(d);
        double[][] c = {{ 10, 98}, {randomDouble, 7} };
        Matrix testMatrixTwo = new Matrix(c);
        Matrix result = testMatrix.plus(testMatrixTwo);
        assertEquals(result.data[1][0], randomDouble + randomDouble, 0);
    }

//    @org.junit.Test
    public void minus() throws Exception {
        Double randomDouble = Matrix.createRandomDouble(1, 10000);
        double[][] d = {{ 1, 2}, {randomDouble, 3} };
        Matrix testMatrix = new Matrix(d);
        double[][] c = {{ 10, 98}, {7, randomDouble} };
        Matrix testMatrixTwo = new Matrix(c);
        Matrix result = testMatrix.minus(testMatrixTwo);
        assertEquals(result.data[1][0], randomDouble - testMatrixTwo.data[1][0], 0);
    }

//    @org.junit.Test
    public void timesNumber() throws Exception {
        Double randomDouble = Matrix.createRandomDouble(1, 10000);
        double[][] d = {{ 1, 2}, {145, 123} };
        Matrix testMatrix = new Matrix(d);
        Matrix result = testMatrix.timesNumber(randomDouble);
        assertEquals(result.data[1][1], testMatrix.data[1][1] * randomDouble, 0);
    }

    private void assertEquals(Double randomDouble, double d, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}