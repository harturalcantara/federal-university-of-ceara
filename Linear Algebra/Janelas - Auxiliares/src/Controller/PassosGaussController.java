package Controller;

import Main.LinearAlgebra;
import Main.Painel;
import Utils.Gram;
import Main.GramSchmitd;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class PassosGaussController implements Initializable {
    
    
     private GridPane paneAux;
    
    @FXML
    private GridPane paneA;
    


    @FXML
    private TextField cell;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
    
    
    private void adicionarEscalonamento(double[][] mtr, double[] vet) {

        for (int i = 0; i < mtr.length; i++) {
            for (int j = 0; j < mtr[0].length; j++) {
                if (Double.isNaN(mtr[i][j]) == true) {
                    mtr[i][j] = 0;
                }

                System.out.print(mtr[i][j] + " ");
                paneAux = createGridPaneFromMatrix(mtr, vet);

            }

            System.out.print("xxxx + " + vet[i]);

            System.out.println();
        }
        
        paneA.getChildren().add(paneAux);
        
        //box.getChildren().add(paneAux);

    }
    
    private GridPane createGridPaneFromMatrix(double[][] matrix, double[] vet) {
		GridPane panec = new GridPane();
		panec.getChildren().clear();

		TextField cell;
		panec.setPadding(new Insets(20, 30, 30, 20));
		panec.setVgap(2);
		panec.setHgap(2);
		panec.setAlignment(Pos.BASELINE_LEFT);

		int k;
		for (int i = 0; i < matrix[0].length; i++) {
			k = 0;
			for (int j = 0; j < matrix.length; j++) {
				cell = new TextField();
				cell.setPrefWidth(60);
				cell.setPrefHeight(50);
				cell.setText(String.valueOf(matrix[i][j]));

				panec.add(cell, j, i);
				k = j;
				// System.out.println(((TextField)(panec.getChildren().get(i*matrix[0].length+j))).getText());
			}
			cell = new TextField();
			cell.setPrefWidth(60);
			cell.setPrefHeight(50);
			cell.setText(String.valueOf(vet[i]));
			panec.add(cell, k + 1, i);

		}

		return panec;
	}
    
    
    
    
//    	public StackPane getPane() {
//		caixa.setAlignment(Pos.BASELINE_LEFT);
//		caixa.getChildren().add(box);
//
//		pane = new StackPane();
//		pane.setAlignment(Pos.BASELINE_LEFT);
//		pane.getChildren().add(caixa);
//		return pane;
//
//	}
    
    
    
    
    
    
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

                cell.setText(String.valueOf(sistema[i][j]));
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
    
    public void fechar(){
        GramSchmitd.getStage().close();
        
    }
    
    public void btVolta(){
        Painel p = new Painel();
        fechar();
        try {
             p.start(new Stage());
             
        } catch (Exception ex) {
             Logger.getLogger(PainelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
    
}
