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

    DecimalFormat formato = new DecimalFormat("#.#");

    public double[][] matriz;
    Gauss g = new Gauss();
    FatoracaoLU falu = new FatoracaoLU();
    Button set;

    @FXML
    private TextField txSolucaoL;
    @FXML
    private GridPane pane;
    @FXML
    private GridPane paneL;
    @FXML
    private GridPane paneU;
    @FXML
    private GridPane paney;
    @FXML
    private GridPane paneb;
    @FXML
    private GridPane panec;
    @FXML
    private TextField cell;
    @FXML
    private TextField linha;
    @FXML
    private TextField coluna;
    @FXML
    private TextField estudo;
    @FXML
    private TextField estudoy;
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
    @FXML
    private Button bnftLu;
    @FXML
    private Button btPostoCoeficientes;
    @FXML
    private Button btPostoAmpliada;
    @FXML
    private TextField txPosto;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        bntsetSistema.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                limpaGridPanes();
                GerarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);
                GerarTermos(Integer.parseInt(linha.getText()), paney);
            }
        });

        bntGauss.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                limpaGridPanes();

                matriz = montarSistema(Integer.parseInt(coluna.getText()), Integer.parseInt(linha.getText()), pane);
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
                limpaGridPanes();

                matriz = montarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);

                Sistemas s = new Sistemas();
                s.gaussJordan(matriz,
                        montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney));
                exibirSistema(g.getMatr(), panec);
                exibirVetor(g.getB(), paneb);

                JOptionPane.showMessageDialog(null, s.estudoSistema(matriz,
                        montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney)));
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
                s.gaussJordan(matriz,
                        montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney));
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

        bnftLu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                limpaGridPanes();

                matriz = montarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);

                Sistemas s = new Sistemas();
                s.fatoracaoLU(matriz, montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney));
                exibirSistema(falu.getL(), paneL);
                exibirSistema(falu.getU(), paneU);

                //exibirSolucao(falu.getX(), estudo); //solucao gauss e gauss jordan
                exibirSolucao(falu.getX(), txSolucaoL);
                exibirSolucao(falu.getY(), estudoy);
            }
        });

        btPostoCoeficientes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                limpaGridPanes();

                matriz = montarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);

                Sistemas s = new Sistemas();
                s.gaussJordan(matriz,
                        montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney));
                exibirSistema(g.getMatr(), panec);
                exibirVetor(g.getB(), paneb);

                JOptionPane.showMessageDialog(null, s.estudoSistema(matriz,
                        montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney)));
                
                //System.out.println("Posto: " + s.postoCoeficientes(g.getMatr()));
                txPosto.setText("Posto coeficientes: " + s.postoCoeficientes(g.getMatr()));
            }
        });
        
        btPostoAmpliada.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                limpaGridPanes();

                matriz = montarSistema(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), pane);

                Sistemas s = new Sistemas();
                s.gaussJordan(matriz,
                        montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney));
                exibirSistema(g.getMatr(), panec);
                exibirVetor(g.getB(), paneb);

                JOptionPane.showMessageDialog(null, s.estudoSistema(matriz,
                        montarVetor(Integer.parseInt(linha.getText()), Integer.parseInt(coluna.getText()), paney)));
                
                //System.out.println("Posto: " + s.postoAmpliada(g.getMatr(),g.getB()));
                txPosto.setText("Posto ampliada: " + s.postoAmpliada(g.getMatr(),g.getB()));
            }
        });
        
        
        
        
        
    }
    private void limpaGridPanes(){
        paneL.getChildren().clear(); //limpa resultado
        paneU.getChildren().clear(); //limpa resultado
        panec.getChildren().clear(); //limpa matriz
        paneb.getChildren().clear(); //limpa vetor
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
				if (!((TextField) gp.getChildren().get(i * coluna + j)).getText().isEmpty())
					sistema[i][j] = Double.parseDouble(((TextField) gp.getChildren().get(i * coluna + j)).getText());
				System.out.println("fff" + sistema[i][j]);
			}
		}

		return sistema;

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
				panex.add(cell, j, i);
			}

		}

	}

    private void GerarTermos(int linha, GridPane paneX) {
        paneX.getChildren().clear();
        for (int j = 0; j < linha; j++) {
            cell = new TextField();
            cell.setPrefWidth(70);
            cell.setPrefHeight(70);
            paneX.add(cell, 0, j);
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

		}

	}

	private void exibirVetor(double[] vetor, GridPane paney) {
		paney.getChildren().clear();
		for (int i = 0; i < vetor.length; i++) {
			cell = new TextField();
			cell.setPrefWidth(70);
			cell.setPrefHeight(70);
			cell.setText(String.valueOf(vetor[i]));
			paney.add(cell, 0, i);
		}

	}

}
