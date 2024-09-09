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

public class SampleController implements Initializable{
	Button set;
	@FXML
	GridPane paneb;
	GridPane panec;
	Matriz mat;
	TextField cell;
	int i = 0;
	
	DecimalFormat formato = new DecimalFormat("#.#");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mat = new Matriz(3,3);
		mat = Matriz.geraMatriz(mat);
		double [] v = new double[3];
		
		v[0] = 0;
		v[1] = 0;
		v[2] = 0;
		
		mat.mat[0][0] = 1;
		mat.mat[0][1] = -2;
		mat.mat[0][2] = 1;
		
		mat.mat[1][0] = 2;
		mat.mat[1][1] = -1;
		mat.mat[1][2] = 4;
		
		mat.mat[2][0] = 3;
		mat.mat[2][1] = -2;
		mat.mat[2][2] = 2;
		
		Sistemas s = new Sistemas();
		//s.gauss(mat.mat, v, paneb);
		gauss(mat.mat, v, paneb);
		//Show(mat);
		
		//paneb = Sistemas.kks(paneb);
		//mat = montarSistema(3,3, paneb);
		//exibirSistema(mat, panec);
		//panec = geraMatriz(mat, panec);
		//mat = getElementos(mat, paneb);
		
	}
	
        void exe(double mat[][]){
            ShowD(mat);
        }
	
	Gauss g = new Gauss();
	public void gauss(double[][] matr, double[] b, GridPane pane) {
		try {
			int n = matr[0].length; //linhas
			int m = matr.length; //colunas
			
			double mult = 0, soma = 0;
			double[] x = new double[n];
			
			System.out.println("Matriz recebida:");
			auxExibir(matr);
			
			for (int k = 0; k < n; k++) {

				System.out.println("------------");
				for (int i = k + 1; i < m; i++) {
                                        exe(matr);
					mult = matr[i][k] / matr[k][k];
					
					System.out.println("------------");
					for (int j = k; j < n; j++) {
                                            matr[i][j] = matr[i][j] - mult * matr[k][j];
					}
					b[i] = b[i] - mult * b[k];
                                        
					auxExibir(matr);
					System.out.println("Operacao feita: " + "L"+(i+1) + " - "+"("+ mult+" * "+"L"+(k+1)+")");
					//ShowD(matr);
					try { Thread.sleep (5000); } catch (InterruptedException ex) {} //dorme por 5 segs
					//Matriz mAux = new Matriz(matr[0].length, matr.length);
					//mAux.mat = matr;
					// SampleController p = new SampleController();
					//Show(mAux);
					//Matriz p = converteMAT(matr);
                                        //System.out.println("MATRIZ NOVA ");
                                        //auxExibir(p.mat);
					
				}
				
			
			}
	
			auxExibir(matr);
			x[n - 1] = b[m - 1] / matr[m - 1][n - 1];
			for (int i = n - 1; i >= 0; i--) {
				soma = 0;
				for (int j = i + 1; j < n; j++) {
					soma = soma + matr[i][j] * x[j];
				}
				x[i] = (b[i] - soma) / matr[i][i];
				//auxExibir(matr);
				//System.out.println("------------");
				
			}
			g.setMatr(matr);
			g.setB(b);
			g.setX(x);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public Matriz converteMAT(double[][] mtr ) {
		Matriz mAux = new Matriz(mtr[0].length, mtr.length);
		for (int i = 0; i < mtr.length; i++) {
			for (int j = 0; j < mtr[0].length; j++) {
				mAux.mat[i][j] = mtr[i][j];

			}
			System.out.println();
		}
		return mAux;
	}
	
	
	public void auxExibir(double[][] mtr) {
		for (int i = 0; i < mtr.length; i++) {
			for (int j = 0; j < mtr[0].length; j++) {
				System.out.print(mtr[i][j] + " ");

			}
			System.out.println();
		}
	}
	
	
	private Matriz getElementos(Matriz matriz, GridPane paneX) {
		for (int j = 0; j < matriz.getN(); j++) {
			for (int i = 0; i < matriz.getM(); i++) {

				if (!((TextField) paneX.getChildren().get(i * matriz.getN() + j)).getText().isEmpty()) {
					matriz.mat[i][j] = Double
							.parseDouble(((TextField) paneX.getChildren().get(i * matriz.getN() + j)).getText());

				}
				// System.out.println("M"+((TextField) pane.getChildren().get(i * a.getM() +
				// j)).getText());
			}
		}
		return matriz;

	}
	
	private void ShowD(double[][] matriz) {
		paneb.getChildren().clear();
                
		for (int i = 0; i < matriz[0].length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				cell = new TextField();
				cell.setPrefWidth(70);
				cell.setPrefHeight(70);
				cell.setText(String.valueOf(matriz[i][j]));
				paneb.add(cell, j, i);
			}
		}
	}
	
	private void Show(Matriz matriz) {
		paneb.getChildren().clear();

		for (int i = 0; i < matriz.getN(); i++) {
			for (int j = 0; j < matriz.getM(); j++) {
				cell = new TextField();
				cell.setPrefWidth(70);
				cell.setPrefHeight(70);
				cell.setText(String.valueOf(matriz.mat[i][j]));
				paneb.add(cell, j, i);
			}
		}
	}
	



	
	private GridPane geraMatriz(Matriz matriz, GridPane paneX) {
		paneX.getChildren().clear();
		for (int i = 0; i < matriz.getN(); i++) {
			for (int j = 0; j < matriz.getM(); j++) {
				cell = new TextField();
				cell.setPrefWidth(70);
				cell.setPrefHeight(70);
				paneX.add(cell, i, j);
			}
		}
		return paneX;

	}


		
}
