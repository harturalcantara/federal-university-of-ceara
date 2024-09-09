package application;


import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SampleController implements Initializable {
    
    public double[][] matriz;
    
    @FXML
    private GridPane paneA;
    @FXML
    private Button btSetSistema;
    
    
    
    
    
    
    
    
    @FXML
    private TextField linha;
    @FXML
    private TextField coluna;
        
    
    
    
        Gauss g = new Gauss();
	Matriz a;
	Button set;

	@FXML
	private GridPane paney;
	@FXML
	private GridPane paneb;
	@FXML
	private GridPane panec;

	private TextField cell;

	@FXML
	private VBox caixa;
	@FXML
	private HBox box;
	@FXML
	private TextField estudo;
	@FXML
	private Button bntEtapas;


	@FXML
	private Button bntEtapasGaussJordan;



	DecimalFormat formato = new DecimalFormat("#.#");
        
        @FXML
	private Button bntGauss;
	@FXML
	private Button btGaussJordan;
        
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btSetSistema.setOnAction(new EventHandler<ActionEvent>() { //verificando
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Click - Botao definir sistema!");

                //verificao se linha e coluna sao nulos
                GerarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paneA);
                System.out.println("oi");
                GerarSistema(Integer.parseInt(linha.getText()), 0, paney);
            }
        });
        
        bntGauss.setOnAction(new EventHandler<ActionEvent>() { //verificando

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Click - Botao operacao Gauss!");
                matriz = getElementos(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paneA);
                System.out.println("PARO!");

                
                
                
                
                
                
                
                Sistemas s = new Sistemas();
                    s.gauss(matriz,
                                    montarVetor(Integer.parseInt(coluna.getText()), Integer.parseInt(linha.getText()), paney));
                    exibirSistema(g.getMatr(), panec);
                    exibirVetor(g.getB(), paneb);
                    exibirSolucao(g.getX(), estudo);

                    JOptionPane.showMessageDialog(null, s.estudoSistema(matriz,
                                    montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney)));
            }

        });
		btGaussJordan.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				matriz = getElementos(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paneA);
				Sistemas s = new Sistemas();

				s.gaussJordan(matriz,
						montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney));

				exibirSistema(g.getMatr(), panec);
				exibirVetor(g.getB(), paneb);
				exibirSolucao(g.getX(), estudo);

				JOptionPane.showMessageDialog(null, s.estudoSistema(matriz,
						montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney)));

			}

		});
		bntEtapas.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				matriz = montarSistema(Integer.parseInt(coluna.getText()), Integer.parseInt(linha.getText()), paneA);
				Sistemas s = new Sistemas();
				s.gauss(matriz,
						montarVetor(Integer.parseInt(coluna.getText()), Integer.parseInt(linha.getText()), paney));
				Stage primary = new Stage();
				StackPane pane;
				pane = s.getPane();
				pane.setStyle("-fx-background-color: Gray");
				Scene sc = new Scene(pane, 300, 300);
				primary.setScene(sc);
				TelaEtapas tela = new TelaEtapas();
				try {
					tela.start(primary);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
		bntEtapasGaussJordan.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				matriz = montarSistema(Integer.parseInt(coluna.getText()), Integer.parseInt(linha.getText()), paneA);
				Sistemas s = new Sistemas();
				s.gaussJordan(matriz,
						montarVetor(Integer.parseInt(coluna.getText()), Integer.parseInt(linha.getText()), paney));
				Stage primary = new Stage();
				StackPane pane;
				pane = s.getPane();
				pane.setStyle("-fx-background-color: Gray");
				Scene sc = new Scene(pane, 300, 300);
				primary.setScene(sc);
				TelaEtapas tela = new TelaEtapas();
				try {
					tela.start(primary);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}
    
    //-- Definir matriz dos coeficientes e termos indepedentes.
    private void GerarSistema(int linhaA, int colunaA, GridPane paneX) {
        paneX.getChildren().clear();
        if(colunaA != 0)
            for (int i = 0; i < linhaA; i++) {
                for (int j = 0; j < colunaA; j++) {
                    cell = new TextField();
                    cell.setPrefWidth(70);
                    cell.setPrefHeight(70);
                    paneX.add(cell, j, i);
                }
            }
        for(int i = 0; i < linhaA; i++) {
            cell = new TextField();
            cell.setPrefWidth(70);
            cell.setPrefHeight(70);
            paneX.add(cell, 0, i);
        }
    }
     
    
    
     private double[][] getElementoss(int linha, int coluna, GridPane paneX) { // verificando. (obtem os elementos do gridPane.)
        double[][] matriz = new double[linha][coluna];
        
        System.out.println( "info:" + ( (TextField) paneX.getChildren().get(2)).getText() );
        
        
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                
                System.out.println( ( (TextField) paneX.getChildren().get(j * linha + i)).getText() );
                
//                if (! ((TextField) paneX.getChildren().get(j * linha + i)).getText().isEmpty()) {
//                    System.out.println(i + "  -  " + j);
//                    System.out.println( Double.parseDouble(((TextField) paneX.getChildren().get(j * linha + i)).getText()) );  
//                
//                matriz[j][i] = Double.parseDouble(((TextField) paneX.getChildren().get(j * linha + i)).getText());
//                //System.out.println(matriz[i][j]);
//                }
            }
        }
        System.out.println("VAI DAR PROBLEMA");
        impMatriz(matriz);
       
        return matriz;
    }
    
    private Matriz getElementosMat(Matriz matriz, GridPane paneX) { // verificando. (obtem os elementos do gridPane.)
        for (int j = 0; j < matriz.getN(); j++) {
            for (int i = 0; i < matriz.getM(); i++) {
                if (!((TextField) paneX.getChildren().get(i * matriz.getN() + j)).getText().isEmpty()) {
                    matriz.mat[i][j] = Double.parseDouble(((TextField) paneX.getChildren().get(i * matriz.getN() + j)).getText());
                }
            }
        }
        return matriz;
    }
    
    
    
    
    
    
    private double[][] getElementos(int linha, int coluna, GridPane paneX) {

        double[][] matrix = new double[linha][coluna];
        
        for (int j = 0; j < linha; j++) {
            for (int i = 0; i < coluna; i++) {

                if (!((TextField) paneX.getChildren().get(i * linha + j)).getText().isEmpty()) {

                    matrix[i][j] = Double.parseDouble(((TextField) paneX.getChildren().get(i * linha + j)).getText());

                }
                System.out.println("M" + ((TextField) paneA.getChildren().get(i * coluna
                        + j)).getText());
            }
        }
        impMatriz(matrix);
        System.out.println("VAI DAR PROBLEMA");
        return matrix;

    }
    
    

    
        //Imprimir o elementos da matriz.
    public void impMatriz(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
        //definir a matriz dos termos indepedentes --DESNECESSARIO
//    private void GerarTermos(int colunaB, GridPane panej) {
//        int j = 0;
//        panej.getChildren().clear();
//        for (int i = 0; i < colunaB; i++) {
//            cell = new TextField();
//            cell.setPrefWidth(70);
//            cell.setPrefHeight(70);
//            panej.add(cell, j, i);
//        }
//    }
        
        
        
        
        
        
        
        
        
        
        
        
	private double[] montarVetor(int linha, int coluna, GridPane gp) {

		double[] vetor = new double[coluna];

		for (int i = 0; i < coluna; i++) {
			if (!((TextField) gp.getChildren().get(i)).getText().isEmpty())
				vetor[i] = Double.parseDouble(((TextField) gp.getChildren().get(i)).getText());

		}
		return vetor;
	}

	private double[][] montarSistema(int linha, int coluna, GridPane gp) {

		double[][] sistema = new double[linha][coluna];

		for (int j = 0; j < coluna; j++) {
			for (int i = 0; i < linha; i++) {
				if (!((TextField) gp.getChildren().get(j * coluna + i)).getText().isEmpty())
					sistema[i][j] = Double.parseDouble(((TextField) gp.getChildren().get(j * coluna + i)).getText());
			}
		}

		return sistema;
	}

	

	private void exibirSolucao(double[] solucao, TextField tfS) {
                tfS.setText("");
		String s = "{ ";
		for (int i = 0; i < solucao.length; i++) {
			s += formato.format(solucao[i]) + ",";
		}
		s += " }";

		tfS.setText(s);
		s = "";
	}
        


	private void exibirSistema(double[][] sistema, GridPane gp) {
		gp.getChildren().clear();
		for (int i = 0; i < sistema[0].length; i++) {
			for (int j = 0; j < sistema.length; j++) {
				cell = new TextField();
				cell.setPrefWidth(70);
				cell.setPrefHeight(70);
				cell.setText(String.valueOf(sistema[i][j]));
				gp.add(cell, j, i);
			}

		}

	}

	private void exibirVetor(double[] vetor, GridPane gp) {
		gp.getChildren().clear();
		for (int i = 0; i < vetor.length; i++) {
			cell = new TextField();
			cell.setPrefWidth(70);
			cell.setPrefHeight(70);
			cell.setText(String.valueOf(vetor[i]));
			gp.add(cell, 0, i);
		}

	}

}
