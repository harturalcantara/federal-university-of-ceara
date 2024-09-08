package br.ufc.crateus.interfaceTela;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import br.ufc.crateus.modelMatrix.Matriz;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class SampleController implements Initializable {
	DecimalFormat formato = new DecimalFormat("#.#");

	/*
	 * variaveis de gets linhas e colunas das matriz
	 */
	@FXML
	HBox detboxA;
	@FXML
	HBox detboxB;
	@FXML
	TextField linha;
	@FXML
	TextField Colu;
	@FXML
	TextField linhaB;
	@FXML
	TextField colunaB;
	@FXML
	GridPane pane;
	@FXML
	GridPane paneB;
	@FXML
	GridPane paneC;
	@FXML
	Text textoname1;
	@FXML
	TextField textoname;
	@FXML
	TextField expoente;
	@FXML
	TextField det;

	private TextField text;
	private Matriz a;
	private Matriz b;

	/*
	 * botoes de operacoes
	 */
	@FXML
	private Button setA;
	@FXML
	private Button setB;
	@FXML
	private Button sub;
	@FXML
	private Button mut;
	@FXML
	private Button plus;
	@FXML
	private Button identidade;
	@FXML
	private Button mutescalar;
	@FXML
	private Button potencia;
	@FXML
	private Button transposta;
	@FXML
	Label label;
	@FXML
	private Button determinate;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (linha.getText() == null && Colu.getText() == null) {
			Alert alert = new Alert(AlertType.ERROR, "ERRO 404 !!");

			alert.show();
		}
		setA.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				a = new Matriz(Integer.parseInt(linha.getText()), Integer.parseInt(Colu.getText()));

				pane = geraMatriz(a, pane);

			}

		});
		setB.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				b = new Matriz(Integer.parseInt(linhaB.getText()), Integer.parseInt(colunaB.getText()));
				paneB = geraMatriz(b, paneB);
			}

		});

		sub.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				a = getElementos(a, pane);
				b = getElementos(b, paneB);
				Show(a.minus(b));
			}
		});
		mut.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				a = getElementos(a, pane);
				b = getElementos(b, paneB);
				Show(a.times(b));
			}

		});
		plus.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				a = getElementos(a, pane);
				b = getElementos(b, paneB);
				Show(a.plus(b));
			}

		});
		identidade.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				a = getElementos(a, pane);
				Show(a.identidade(a));

			}

		});
		mutescalar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Show(a.multiplicarEscalar(a, Double.parseDouble(textoname.getText())));
			}

		});
		potencia.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				a = getElementos(a, pane);

				Show(a.potencia(a, Integer.parseInt(expoente.getText())));
			}

		});
		transposta.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				a = getElementos(a, pane);
				Show(a.transpose());

				// System.out.println("" + a.determinante(0, a));

			}

		});
		determinate.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
			if(Integer.parseInt(det.getText()) == 1) {
				det.clear();
			
				
			
				a = getElementos(a, pane);
				det = new TextField();
				det.setText(String.valueOf(a.matrixDeterminant(a.mat)));
				detboxA.getChildren().add(det);
				// det.clear();
				b = getElementos(b, paneB);
				textoname = new TextField();

				textoname.setText(String.valueOf(b.matrixDeterminant(b.mat)));
				detboxB.getChildren().add(textoname);
				}

			}

		});

	}

	private GridPane geraMatriz(Matriz matriz, GridPane paneX) {
		paneX.getChildren().clear();
		for (int i = 0; i < matriz.getM(); i++) {
			for (int j = 0; j < matriz.getN(); j++) {
				text = new TextField();
				text.setPrefWidth(70);
				text.setPrefHeight(70);
				paneX.add(text, i, j);
			}
		}
		return paneX;

	}

	@FXML
	public void inicializar() {
		linha.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				linha = new TextField();
				linha.setPromptText("digite");
			}

		});
	}

	private Matriz getElementos(Matriz matriz, GridPane paneX) {
		for (int j = 0; j < matriz.getM(); j++) {
			for (int i = 0; i < matriz.getN(); i++) {

				if (!((TextField) paneX.getChildren().get(i * matriz.getM() + j)).getText().isEmpty()) {
					matriz.mat[i][j] = Double
							.parseDouble(((TextField) paneX.getChildren().get(i * matriz.getM() + j)).getText());

				}
				// System.out.println("M"+((TextField) pane.getChildren().get(i * a.getM() +
				// j)).getText());
			}
		}
		return matriz;

	}

	private void Show(Matriz matriz) {
		paneC.getChildren().clear();

		for (int i = 0; i < matriz.getM(); i++) {
			for (int j = 0; j < matriz.getN(); j++) {
				text = new TextField();
				text.setPrefWidth(70);
				text.setPrefHeight(70);
				text.setText(String.valueOf(matriz.mat[i][j]));
				paneC.add(text, i, j);
			}
		}
	}

}