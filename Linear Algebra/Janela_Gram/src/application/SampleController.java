package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class SampleController implements Initializable {

    DecimalFormat formato = new DecimalFormat("#.##");
    public double[][] matriz;

    @FXML
    private GridPane pane;
    @FXML
    private GridPane paneC;
    @FXML
    private TextField cell;
    @FXML
    private TextField coluna;
    @FXML
    private TextField linha;
    @FXML
    private Button btSetVetor;
    @FXML
    private Button btBaseOrtogonalizada;
    @FXML
    private Button btBaseOrtonormalizacao;
    @FXML
    private Button btVolta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btSetVetor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                GerarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);

            }
        });

        btBaseOrtogonalizada.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("CLICK - btBaseOrtogonalizada!");
                matriz = montarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);

                Gram g = new Gram(matriz);

                exibirSistema(g.algorith2(), paneC);

            }
        });
        btBaseOrtonormalizacao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("CLICK - btBaseOrtonormalizacao!");
                matriz = montarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);

                Gram g = new Gram(matriz);

                exibirSistema(g.algorith(), paneC);
            }
        });

    }

    private void GerarSistema(int linhaA, int colunaA, GridPane panex) {
        panex.getChildren().clear();
        for (int i = 0; i < linhaA; i++) {
            for (int j = 0; j < colunaA; j++) {
                cell = new TextField();
                cell.setPrefWidth(70);
                cell.setPrefHeight(70);

                panex.add(cell, j, i);

            }
            panex.setVgap(20);

        }

    }

    private void exibirSistema(double[][] sistema, GridPane panex) {
        panex.getChildren().clear();
        for (int i = 0; i < sistema[0].length; i++) {
            for (int j = 0; j < sistema.length; j++) {
                cell = new TextField();
                cell.setPrefWidth(70);
                cell.setPrefHeight(70);

                cell.setText(String.valueOf(formato.format(sistema[i][j])));
                panex.add(cell, j, i);
            }
            panex.setVgap(20);

        }

    }

    private double[][] montarSistema(int linha, int coluna, GridPane gp) {

        double[][] sistema = new double[linha][coluna];

        for (int j = 0; j < coluna; j++) {
            for (int i = 0; i < linha; i++) {
                if (!((TextField) gp.getChildren().get(i * coluna + j)).getText().isEmpty()) {
                    sistema[i][j] = Double.parseDouble(((TextField) gp.getChildren().get(i * coluna + j)).getText());
                }
                //System.out.println("fff" + sistema[i][j]);
            }
        }

        return sistema;

    }

}
