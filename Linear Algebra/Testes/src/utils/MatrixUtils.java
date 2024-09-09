package matrixgui.utils;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import matrixgui.model.AlertBox;
import matrixgui.model.Matrix;

import java.io.*;

/**
 * Class that has GUI- and IO-related methods
 */
public class MatrixUtils {

    /** Save matrix to the file
     * @param matrix    Matrix to save
     * @param name      Name of the file
     */
    public static void saveMatrix(Matrix matrix, String name) {
        try {
            FileOutputStream fos = new FileOutputStream(name + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(matrix);
            oos.close();
        } catch (IOException e) {
            AlertBox.display("Error", "Sorry, we could not save the matrix");
            e.printStackTrace();
        }
    }

    /** Loads matrix from the file
     * @param name      Name of the file
     */
    public static Matrix loadMatrix(String name) {
        Matrix result = Matrix.random();
        try {
            FileInputStream fis = new FileInputStream(name + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (Matrix) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            AlertBox.display("Error", "Sorry, we could not load the matrix. Loading random Matrix");
        }
        return result;
    }

    /**
     * Creates GridPane (GUI element) from the given matrix
     * @param matrix     Matrix to create GridPane from
     * @return           GridPane with appropriate rows and columns
     */
    public static GridPane createGridPaneFromMatrix(Matrix matrix) {
        GridPane gridPane = new GridPane();
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        for (int i = 0; i < matrix.getM(); i++) {
            for (int j = 0; j < matrix.getN(); j++) {
                TextField textField = new TextField();
                textField.setMaxWidth(70);
                gridPane.add(textField, j, i);
            }
        }

        return gridPane;
    }

    /**
     * Creates Matrix from the given GridPane
     * @param matrix    Matrix to fill
     * @param gridPane  GridPane to create Matrix from
     * @return          Matrix
     */
    public static Matrix createNewMatrixFromGridPane(Matrix matrix, GridPane gridPane) {
        Matrix newMatrix = new Matrix(matrix.getM(), matrix.getN());
        for (int i = 0; i < newMatrix.getM(); i++) {
            for (int j = 0; j < newMatrix.getN(); j++) {
                newMatrix.data[i][j] = Double.parseDouble(MatrixUtils.getGridPaneText(i, j, gridPane));
            }
        }
        return  newMatrix;
    }

    /**
     * Gets text of the specified child element {@link Node} of the GridPane
     * @param rows      Row of the node
     * @param columns   Column of the node
     * @param gridPane  GridPane to get text from
     * @return          Text from the specified child element
     */
    private static String getGridPaneText(int rows, int columns, GridPane gridPane) {
        TextField textField = (TextField) getNodeByRowColumnIndex(rows, columns, gridPane);
        return textField.getText();
    }

    /**
     * Gets child element {@link Node} of the GridPane at the specified position
     * @param row       Row of the node
     * @param column    Column of the node
     * @param gridPane  GridPane to get node from
     * @return          Specified node
     */
    private static Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }

    /**
     * Displays given Matrix on the specified GridPane
     * @param gridPane  GridPane to display Matrix on
     * @param matrix    Matrix to display
     */
    public static void displayMatrixOnGridPane(GridPane gridPane, Matrix matrix) {
        for (int i = 0; i < matrix.getM(); i++) {
            for (int j = 0; j < matrix.getN(); j++) {
                TextField textField = (TextField) MatrixUtils.getNodeByRowColumnIndex(i, j, gridPane);
                textField.setText(String.valueOf(matrix.data[i][j]));
            }
        }
    }

    /**
     * Creates small {@link Button} button with the specified text
     * @param name  Text to pu on the Button
     * @return      Small button
     */
    public static Button getButton(String name) {
        Button buttonMulti = new Button();
        buttonMulti.setWrapText(true);
        buttonMulti.setText(name);
        buttonMulti.setPadding(new Insets(0, 0, 0, 0));
        return buttonMulti;
    }


}
