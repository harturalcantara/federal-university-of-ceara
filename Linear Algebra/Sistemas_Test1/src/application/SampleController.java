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
        DecimalFormat formato = new DecimalFormat("#.#");
	Gauss g = new Gauss();
	Matriz a;
	Button set;
	
	@FXML
	private GridPane pane;
	@FXML
	private GridPane paney;
	@FXML
	private GridPane paneb;
	@FXML
	private GridPane panec;

	private TextField cell;
	@FXML
	private TextField linha;
	@FXML
	private TextField coluna;
	@FXML
	private VBox caixa;
	@FXML
	private HBox box;
	@FXML
	private TextField estudo;
	@FXML
	private Button bntEtapas;
	@FXML
	private Button bntsetSistema;
	@FXML
	private Button bntGauss;
	@FXML
	private Button btGaussJordan;
	@FXML
	private Button bntEtapasGaussJordan;


	@Override
	public void initialize(URL location, ResourceBundle resources) {

            bntsetSistema.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    GerarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);
                    GerarTermos(Integer.parseInt(coluna.getText()), paney);
                    matriz = montarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);
                    
//                System.out.println("Click - Botao definir sistema!");
//                //verificao se linha e coluna sao nulos
//                GerarSistemaA(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);
//                System.out.println("oi");
//                GerarSistemaA(Integer.parseInt(linha.getText()), 0, paney);
                    
                    
                }

            });
		
		bntGauss.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				matriz = getElementos(Integer.parseInt(coluna.getText()), Integer.parseInt(linha.getText()), pane);
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
                    System.out.println("Click - btGaussJordan!");
                    //verificao das linha e colunas no textfilds
                    
                    matriz = getElementos(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);
                    System.out.println("MATRIZ ATUAL");
                    mostrarMatriz(matriz);
                    Sistemas s = new Sistemas();
                    
                    try {
                        
                        //matriz = s.GaussJordan(matriz);

                        System.out.println("");
                        
                        double vetor[] = {15,10,11};
                         double vetor1[] = {11,10,15};
                        GaussJordanElimination sist = new GaussJordanElimination(matriz, vetor1);
                        matriz = sist.a;
                        System.out.println("MATRIZ ESCALONADA");
                        System.out.println(sist.n);
                        mostrarMatriz(sist.a);
                        
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    /*exibirSistema(g.getMatr(), panec);
				exibirVetor(g.getB(), paneb);
				exibirSolucao(g.getX(), estudo);
				

				JOptionPane.showMessageDialog(null, s.estudoSistema(matriz,
						montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney)));
                     */
                }

            });
		bntEtapas.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

                                
				matriz = montarSistema(Integer.parseInt(coluna.getText()), Integer.parseInt(linha.getText()), pane);
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

				matriz = montarSistema(Integer.parseInt(coluna.getText()), Integer.parseInt(linha.getText()), pane);
				Sistemas s = new Sistemas();
				try {
					s.GaussJordan(matriz);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
        
        	public double[][] transposta(double[][] mtr) {

		double[][] tempTransposta = new double[mtr[0].length][mtr.length];

		for (int i = 0; i < tempTransposta.length; i++) {
			for (int j = 0; j < tempTransposta[0].length; j++) {
				tempTransposta[i][j] = mtr[j][i];

			}

		}

		return tempTransposta;

	}
        //-- Definir matriz dos coeficientes e termos indepedentes.
    private void GerarSistemaA(int linhaA, int colunaA, GridPane paneX) {
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
        
        
        
    
    /*Imprimir a matriz recebida.*/
    public void mostrarMatriz(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
        
        

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
				//System.out.println("fff"+sistema[i][j]);
			}
		}

		return sistema;
		
	}

    private double[][] getElementos(int linha, int coluna, GridPane paneX) {
        double[][] matrix = new double[linha][coluna];
        for (int j = 0; j < linha; j++) {
            for (int i = 0; i < coluna; i++) {
                if (!((TextField) paneX.getChildren().get(i * linha + j)).getText().isEmpty()) {
                    matrix[j][i] = Double.parseDouble(((TextField) paneX.getChildren().get(i * linha + j)).getText());
                }
                //System.out.println("M"+((TextField) pane.getChildren().get(i * coluna +
                //j)).getText());
            }
        }
        return matrix;
    }

	private void exibirSolucao(double[] solucao, TextField tfS) {
		tfS.setText("");
		String s = "{";
		for (int i = 0; i < solucao.length; i++) {
			s += formato.format(solucao[i]) + ",";
		}
		s += "}";

		tfS.setText(s);
		s = "";
	}

	private void GerarSistema(int linhaA, int colunaA, GridPane panex) {
		panex.getChildren().clear();
		for (int i = 0; i < linhaA; i++) {
			for (int j = 0; j < colunaA; j++) {
				cell = new TextField();
				cell.setPrefWidth(70);
				cell.setPrefHeight(70);
				panex.add(cell, i, j);
			}

		}

	}

	private void GerarTermos(int colunaB, GridPane panej) {
		int i = 0;
		panej.getChildren().clear();

		for (int j = 0; j < colunaB; j++) {
			cell = new TextField();
			cell.setPrefWidth(70);
			cell.setPrefHeight(70);
			panej.add(cell, i, j);
		}
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
