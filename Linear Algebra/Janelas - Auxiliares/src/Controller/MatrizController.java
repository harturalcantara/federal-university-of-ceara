package Controller;

import Main.LinearAlgebra;
import Main.Matrizes;
import Main.Painel;
import Utils.AlertBox;
import Utils.Matriz;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MatrizController implements Initializable {
    private Matriz A;
    private Matriz B;
    private TextField text;

    @FXML
    GridPane panedet;
    @FXML
    Text textoname1;
    @FXML
    TextField det;
    @FXML
    Label label;
    
    
    @FXML
    private TextField txLinhaA;
    @FXML
    private TextField txColunaA;
    @FXML
    private TextField txLinhaB;
    @FXML
    private TextField txColunaB;
    @FXML
    private TextField txPotencia;
    @FXML
    private TextField txMultEscalar; 
    @FXML
    private GridPane paneA;
    @FXML
    private GridPane paneB;
    @FXML
    private GridPane paneC;
    @FXML
    private Button btSetA;
    @FXML
    private Button btSetB;
    @FXML 
    private Button btSomarMat;
    @FXML
    private Button btSubMat;
    @FXML
    private Button btMultMat;
    @FXML
    private Button btIdentidade;
    @FXML
    private Button btMultEscalar;
    @FXML
    private Button btPotenciaMat;
    @FXML
    private Button btTranpostaMat;
    @FXML
    private Button btDetMat;
    @FXML
    private Button btAdj;
    @FXML
    private Button btCofatora;
    @FXML
    private Button btInversaMat;
    @FXML
    private Button btVolta;
    @FXML
    private GridPane paneDet;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
//        if (txLinhaA.getText() == null || txColunaA.getText() == null) {
//                Alert alert = new Alert(AlertType.ERROR, "Erro! Campo da linha ou coluna esta vazio!");
//                alert.show();
//        }
		
        btSetA.setOnAction(new EventHandler<ActionEvent>() { // deve ser editado para qualquer tipo de matrizes */
            @Override
            public void handle(ActionEvent event) {
                A = new Matriz(Integer.parseInt(txLinhaA.getText()), Integer.parseInt(txColunaA.getText()));
                paneA = geraMatriz(A, paneA);
            }
        });
        
        btSetB.setOnAction(new EventHandler<ActionEvent>() { // deve ser editado para qualquer tipo de matrizes */
            @Override
            public void handle(ActionEvent event) {
                B = new Matriz(Integer.parseInt(txLinhaB.getText()), Integer.parseInt(txColunaB.getText()));
                paneB = geraMatriz(B, paneB);
            }
        });
        
        btSomarMat.setOnAction(new EventHandler<ActionEvent>() { /** Okay - by hartur*/
            @Override
            public void handle(ActionEvent arg0) {
                if(A == null){
                    System.out.println("Erro, matriz A está vazia! - btSomarMat");
                    AlertBox.avisoMatrizVazia('A');
                }
                else if(B == null){
                    System.out.println("Erro, matriz B está vazia! - btSomarMat");
                    AlertBox.avisoMatrizVazia('B');
                }
                else{
                    A = getElementos(A, paneA);
                    
                    
                    
                    
                    B = getElementos(B, paneB);
                    if (B.getM() != A.getM() || B.getN() != A.getN())
                        AlertBox.displayIllegalMatrixDimensionWarning();
                    else
                        Show(A.plus(B));
                }
            }
        });

        btSubMat.setOnAction(new EventHandler<ActionEvent>() { /** Okay - by hartur*/
            @Override
            public void handle(ActionEvent event) {
                if(A == null){
                    System.out.println("Erro, matriz A está vazia!- btSubMat");
                    AlertBox.avisoMatrizVazia('A');
                }
                else if(B == null){
                    System.out.println("Erro, matriz B está vazia!- btSubMat");
                    AlertBox.avisoMatrizVazia('B');
                }
                else{
                    A = getElementos(A, paneA);
                    B = getElementos(B, paneB);
                    if (B.getM() != A.getM() || B.getN() != A.getN())
                        AlertBox.displayIllegalMatrixDimensionWarning();
                    else
                        Show(A.minus(B));
                }
            }
        });
        
        btMultMat.setOnAction(new EventHandler<ActionEvent>() { /** Okay - by hartur*/
            @Override
            public void handle(ActionEvent arg0) {
                if(A == null){
                    System.out.println("Erro, matriz A está vazia! - btMultMat");
                    AlertBox.avisoMatrizVazia('A');
                }
                else if(B == null){
                    System.out.println("Erro, matriz B está vazia! - btMultMat");
                    AlertBox.avisoMatrizVazia('B');
                }
                else{
                    A = getElementos(A, paneA);
                    B = getElementos(B, paneB);
                    if (A.getM() != B.getN())
                        AlertBox.displayIllegalMatrixDimensionWarning();
                    else
                        Show(A.times(B));
                }
            }
        });
        
        
        btIdentidade.setOnAction(new EventHandler<ActionEvent>() { /** Okay - by hartur*/
            @Override
            public void handle(ActionEvent arg0) {
                 if(A == null){
                    System.out.println("Erro, matriz A está vazia!- btIdentidade");
                    AlertBox.avisoMatrizVazia('A');
                }
                else{
                    A = getElementos(A, paneA);
                    Show(A.identidade(A));
                }
            }
        });
        
        btMultEscalar.setOnAction(new EventHandler<ActionEvent>() { /** Okay - by hartur*/
            @Override
            public void handle(ActionEvent event) {
                if (A == null) {
                    System.out.println("Erro, matriz A está vazia!");
                    AlertBox.avisoMatrizVazia('A');
                } 
                else if(txMultEscalar.getText().isEmpty()){       
                    System.out.println("Erro, nao preencheram o escalar!");
                    AlertBox.display("Erro", "Erro, você deve preencher o campo ao lado com um escalar!");
                }
                else {
                    A = getElementos(A, paneA);
                    Show(A.multiplicarEscalar(A, Double.parseDouble(txMultEscalar.getText())));
                }
            }
        });        
        
        btPotenciaMat.setOnAction(new EventHandler<ActionEvent>() { /** Okay - by hartur*/
            @Override
            public void handle(ActionEvent arg0) {
                if(A == null){
                    System.out.println("Erro, matriz A está vazia! - btPotenciaMat");
                    AlertBox.display("Erro", "A matriz A está vázia!");
                }
                else if(txPotencia.getText().isEmpty()){                    
                    System.out.println("Erro, nao preencheram o expoente!");
                    AlertBox.display("Erro", "Erro, você deve preencher o campo ao lado com um expoente!");
                }
                else{
                    A = getElementos(A, paneA);
                    Show(A.potencia(A, Integer.parseInt(txPotencia.getText())));
                }
            }
        });
        
        btTranpostaMat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(A == null){
                    System.out.println("Erro, matriz A está vazia! - btTranpostaMat");
                    AlertBox.display("Erro", "A matriz A está vázia!");
                }
                A = getElementos(A, paneA);
                Show(A.transpose());
            }
        });
        
        btInversaMat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(A == null){
                    System.out.println("Erro, matriz A está vazia! - btInversaMat");
                    AlertBox.display("Erro", "A matriz 'A' está vázia!");
                }
                A = getElementos(A, paneA);
                Show(A.inversa(A.mat));
            }
        });
        
        btCofatora.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(A == null){
                    System.out.println("Erro, matriz A está vazia! - btInversaMat");
                    AlertBox.display("Erro", "A matriz 'A' está vázia!");
                }
                A = getElementos(A, paneA);
                Show(A.matrizAdjunta(A.mat));
            }
        });
        
        		
        btAdj.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(A == null){
                    System.out.println("Erro, matriz A está vazia! - btInversaMat");
                    AlertBox.display("Erro", "A matriz 'A' está vázia!");
                }
                A = getElementos(A, paneA);
                Show(A.transposta((A.matrizAdjunta(A.mat))));
            }
        });
        
        btDetMat.setOnAction(new EventHandler<ActionEvent>() { /** Okay - by hartur*/
            @Override
            public void handle(ActionEvent arg0) {
                if(A == null){
                    System.out.println("Erro, matriz A está vazia! - btDetMat");
                    AlertBox.display("Erro", "A matriz 'A' está vázia!");
                }
                A = getElementos(A, paneA);
                if (A.getN() != A.getM()){
                     System.out.println("Erro, A matriz 'A' não é quadrática! - btDet");
                       AlertBox.display("Erro", "A matriz 'A' não é quadrática!");
                }
                else{
                    det = new TextField();
                    det.setPrefWidth(120);
                    det.setPrefHeight(50);
                    det.setText("Det(A): "+ String.valueOf(A.matrixDeterminant(A.mat)));
                    paneDet.getChildren().clear();
                    paneDet.add(det, 0, 0);
                }
            }
        });
        
        btVolta.setOnMouseClicked((MouseEvent e)->{
            btVolta();
        });
        
        btVolta.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                btVolta();
        });
        
        
        
        
        
    }
        /*ideias:/
    //a funcao gerador deve criar matrizes nao quadraticas, Ideia: fazer outra funcoes para isso
        
        
    /** IMPORTANTE - ANOTACOES - Ainda a consertar
     * 1. As operacoes n devem ser apenas para matrizes quadraticas.
     */
        
	
    public void fechar() {
        Matrizes.getStage().close();
    }

    public void btVolta() {
        Painel p = new Painel();
        fechar();
        try {
            p.start(new Stage());

        } catch (Exception ex) {
            Logger.getLogger(PainelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    private int checkEntrada(){ //Funcao para alertar o 
//        if (txLinhaA.getText() == null || txColunaA.getText() == null) {
//            Alert alert = new Alert(AlertType.ERROR, "Erro! Campo da linha ou coluna esta vazio!");
//            alert.show();
//            return 1;
//        }
//        return 0;
//    }
    
    private Matriz getElementos(Matriz matriz, GridPane paneX) { // verificando. (obtem os elementos do gridPane.)
        for (int j = 0; j < matriz.getN(); j++) {
            for (int i = 0; i < matriz.getM(); i++) {
                if (!((TextField) paneX.getChildren().get(i * matriz.getN() + j)).getText().isEmpty()) {
                    matriz.mat[i][j] = Double.parseDouble(((TextField) paneX.getChildren().get(i * matriz.getN() + j)).getText());
                }
            }
        }
        return matriz;
    }
    
    
	private GridPane geraMatriz(Matriz matriz, GridPane paneX) {
		paneX.getChildren().clear();
		for (int i = 0; i < matriz.getN(); i++) {
			for (int j = 0; j < matriz.getM(); j++) {
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
		txLinhaA.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				txLinhaA = new TextField();
				txLinhaA.setPromptText("digite");
			}

		});
	}


	

	

	
	/*
	public Matriz converteMATdle(Matriz mtr ) { //Converte double[][] para um objeto Matriz	
		double[][] mAux = new double[mtr.mat.length][mtr.mat.length];
		
		for (int i = 0; i < mtr.length; i++) {
			for (int j = 0; j < mtr[0].length; j++) {
				mAux.mat[i][j] = mtr[i][j];

			}
			System.out.println();
		}
		return mAux;
	}*/
	
    public Matriz converteMATobj(double[][] mtr ) { /*Converte double[][] para um objeto Matriz*/
        Matriz mAux = new Matriz(mtr[0].length, mtr.length);
        for (int i = 0; i < mtr.length; i++) {
            for (int j = 0; j < mtr[0].length; j++) {
                mAux.mat[i][j] = mtr[i][j];
            }
            System.out.println();
        }
        return mAux;	
    }
    
    private void Show(double[][] matriz) {
		paneC.getChildren().clear();

		for (int i = 0; i < matriz[0].length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				text = new TextField();
				text.setPrefWidth(70);
				text.setPrefHeight(70);
				text.setText(String.valueOf(matriz[i][j]));
				paneC.add(text, i, j);
			}
		}
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
