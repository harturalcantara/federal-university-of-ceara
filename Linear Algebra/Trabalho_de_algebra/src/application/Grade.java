package application;

import java.util.Scanner;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.scene.Node;

public class Grade {
	
	protected static GridPane geraMatriz(Matriz matriz,GridPane pane) {
		//pane.getChildren().clear();
		for(int i = 0; i < matriz.getM(); i++) {
			for(int j = 0; j < matriz.getN(); j++) {
				TextField text = new TextField();
				text.setPrefWidth(70);
				text.setPrefHeight(70);
				pane.add(text, i, j);
			}
		}
	
		return pane;
	}
	private static String getGridPaneText(int rows, int columns, GridPane gridPane) {
	        TextField textField = (TextField) getNodeByRowColumnIndex(rows, columns, gridPane);
	        return textField.getText();
	 }
	 public static Matriz createNewMatrixFromGridPane(Matriz matrix, GridPane gridPane) {
		 
	        Matriz newMatrix = new Matriz(matrix.getM(), matrix.getN());
	        for (int i = 0; i < newMatrix.getM(); i++) {
	            for (int j = 0; j < newMatrix.getN(); j++) {
	                newMatrix.mat[i][j] = Double.parseDouble(Grade.getGridPaneText(i, j, gridPane));
	            }
	        }
	        return  newMatrix;
	  }

	public static void displayMatrixOnGridPane(GridPane gridPane, Matriz matriz) {
        for (int i = 0; i < matriz.getM(); i++) {
            for (int j = 0; j < matriz.getN(); j++) {
                TextField textField = (TextField) Grade.getNodeByRowColumnIndex(i, j, gridPane);
                textField.setText(String.valueOf(matriz.mat[i][j]));
            }
        }
    }


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
	 
	 public static Button getButton(String name) {
	        Button buttonMulti = new Button();
	        buttonMulti.setWrapText(true);
	        buttonMulti.setText(name);
	        buttonMulti.setPadding(new Insets(0, 0, 0, 0));
	        return buttonMulti;
	    }


}
