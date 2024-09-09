/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author hartu
 */
public class MatrizesController implements Initializable {
    static ArrayList<GridPane> Matrixes = new ArrayList<GridPane>();
    int Colums, Rows;
    //Lista com as matrizes reais
    static ArrayList<Double[][]> matrixList = new ArrayList<Double[][]>();
    static ArrayList<ArrayList<TextField>> textList = new ArrayList<ArrayList<TextField>>();
    static ArrayList<Integer> rowsList = new ArrayList<Integer>();
    static ArrayList<Integer> columnsList = new ArrayList<Integer>();

    public static GridPane matrixPane;
    static int matrixQnt = 0;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public static GridPane fill(int rows, int columns, int posX, int posY){
	Double[][] realMatrix = new Double[10][10];
	ArrayList<TextField> textBoxs = new ArrayList<TextField>();        
	matrixPane = new GridPane();
	matrixPane.setMaxSize(250, 250);
	for(int x = 0; x < rows; x++){
	    for(int y = 0; y < columns; y++){
                Random rand = new Random();
                Double rand1 = Double.valueOf(rand.nextInt(2));
                realMatrix[x][y] = rand1;

                TextField tf = new TextField();
                tf.setPrefHeight(25);
                tf.setPrefWidth(25);
                tf.setAlignment(Pos.CENTER_RIGHT);
                tf.setStyle("-fx-font: 10 times; -fx-base: #1b56b7; -fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1; -fx-focus-color: Blue");
                tf.setEditable(true);
                tf.setText(""+rand1);

                matrixPane.setRowIndex(tf,x);
                matrixPane.setColumnIndex(tf,y);    
                matrixPane.getChildren().addAll(tf);
                textBoxs.add(tf);
            }
	}    
	Matrixes.add(matrixPane);
	rowsList.add(rows);
	columnsList.add(columns);
	matrixPane.setTranslateX(posX);
	matrixPane.setTranslateY(posY);
	matrixQnt++;
	textList.add(textBoxs);
	matrixList.add(realMatrix);
        return matrixPane;
    }
    
}
