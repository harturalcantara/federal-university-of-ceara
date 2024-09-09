package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class SampleController implements Initializable{
	DecimalFormat formato = new DecimalFormat("#.#");
	
	
	@FXML
	TextField linha;
	@FXML
	TextField Colu;
	@FXML
	private TextField linhaB;
	@FXML
	GridPane pane;
	@FXML
	GridPane paneB;
	@FXML
	GridPane paneC;
	
	private TextField text;
	@FXML
	static int m,n;
	public Matriz a;
	public Matriz b;
	public Matriz c;
	@FXML
	private Button setA;
	private Button setB;
	@FXML
	private Button sub;
	@FXML
	private Button mut;
	@FXML
	Button plus;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		setA.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				m = Integer.parseInt(linha.getText());
				n = Integer.parseInt(Colu.getText());
				a = new Matriz(m,n);
				geraMatrizA(a);
								
			}
			
		});
		
		sub.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Elementos(a);
				exibirMatriz(a.plus(a));
			}
		});

		
		
		
	}

	private void geraMatrizA(Matriz a) {
		pane.getChildren().clear();
		for(int i = 0; i < a.getM(); i++) {
			for(int j = 0; j < a.getN(); j++) {
				text = new TextField();
				text.setPrefWidth(70);
				text.setPrefHeight(70);
				pane.add(text, i, j);
			}
		}
	
	}

	private void Elementos(Matriz a) {
		for(int j = 0; j < a.getM(); j++) {
			for(int i = 0; i < a.getN(); i++) {
				
				if( !((TextField) pane.getChildren().get(i * a.getM() + j)).getText().isEmpty()) {
					a.mat[i][j] = Double.parseDouble(((TextField) pane.getChildren().get(i * a.getM() + j)).getText());
					
					
				}
				//System.out.println("M"+((TextField) pane.getChildren().get(i * a.getM() + j)).getText());
			}
		}
		
		
	}
	public void exibirMatriz(Matriz matriz) {
		paneC.getChildren().clear();
		
		for(int i = 0; i < matriz.getM(); i++) {
			for(int j = 0; j < matriz.getN(); j++) {
				text = new TextField();
				text.setPrefWidth(70);
				text.setPrefHeight(70);
				text.setText(String.valueOf(matriz.mat[i][j]));
				paneC.add(text, i, j);
			}
		}
	}

	
		
 

}
