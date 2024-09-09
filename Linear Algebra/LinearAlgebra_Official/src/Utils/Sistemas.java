package Utils;

import java.text.DecimalFormat;
import javafx.fxml.FXML;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Sistemas {
    Gauss g = new Gauss();
    FatoracaoLU falu = new FatoracaoLU();
    DecimalFormat formato = new DecimalFormat("#.#");
    StackPane pane;
    VBox caixa = new VBox();
    HBox box = new HBox();
    VBox caixa2 = new VBox();
    HBox box2 = new HBox();
    GridPane paneAux = new GridPane();
    GridPane paneAux2 = new GridPane();

    //MECHEND VBOX
    @FXML
    private VBox VboxA;
        
	public void gauss(double[][] matr, double[] b) {
		try {
			int n = matr[0].length; // linhas
			int m = matr.length; // colunas

			double mult = 0, soma = 0;
			double[] x = new double[n];

			System.out.println("Matriz recebida:");
//			auxExibir(matr);
			for (int k = 0; k < n; k++) {

				System.out.println("------------");
				for (int i = k + 1; i < m; i++) {
					mult = matr[i][k] / matr[k][k];

					System.out.println("------------");
					for (int j = k; j < n; j++) {
						matr[i][j] = matr[i][j] - mult * matr[k][j];
					}
					b[i] = b[i] - mult * b[k];
					// auxExibir(matr);
					// System.out.println("Operacao feita: " + "L"+(i+1) + " - "+"("+ mult+" *
					// "+"L"+(k+1)+")");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException ex) {
					}
					impSistema(matr, b);
					// dorme por 5
					// segs
					// Matriz mAux = new Matriz(matr[0].length, matr.length );
					// mAux.mat = matr;
					// SampleController p = new SampleController();
					// p.ShowD(matr);
				}

			}
			impSistema(matr, b);
			// auxExibir(matr);
			x[n - 1] = b[m - 1] / matr[m - 1][n - 1];
			for (int i = n - 1; i >= 0; i--) {
				soma = 0;
				for (int j = i + 1; j < n; j++) {
					soma = soma + matr[i][j] * x[j];
				}
				x[i] = (b[i] - soma) / matr[i][i];
				// auxExibir(matr);
				// System.out.println("------------");

			}
			g.setMatr(matr);
			g.setB(b);
			g.setX(x);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/** MOSTRAR MATRIZ */
	public void mostrarMatriz(double[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void gaussJordan(double[][] matr, double[] b) {
		impSistema(matr, b);

		for (int i = 0; i <= b.length - 1; i++) {
			double d, c = 0;
			d = matr[i][i];
			if (Double.isNaN(matr[i][i]) != true) {
				g.setMatr(matr);
				g.setB(b);
			}

			for (int s = 0; s <= b.length - 1; s++) {
				matr[i][s] = ((matr[i][s]) / d);
				if (Double.isNaN(matr[i][s]) == true) {
					matr[i][s] = 0;

					return;

				}

			}
			b[i] = ((b[i]) / d);
			if (Double.isNaN(b[i]) == true) {
				return;
			}

			for (int l = 0; l <= b.length - 1; l++) {
				if (i != l) {
					c = matr[l][i];
					for (int y = 0; y <= b.length - 1; y++) {
						matr[l][y] = matr[l][y] - c * matr[i][y];
						if (Double.isNaN(matr[l][y]) == true) {
							matr[l][y] = 0;

							return;

						}

					}
					b[l] = b[l] - c * b[i];
					if (Double.isNaN(b[l]) == true) {
						b[l] = 0;
						return;

					}
					// g.setB(b);
				}

				impSistema(matr, b);
				System.out.println();

			}
			impSistema(matr, b);

		}

		// g.setMatr(matr);

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

	public void fatoracaoLU(double[][] matr, double[] b) {
		try {
			int m = matr.length;
			int n = matr[0].length;
			double soma = 0;
			double[][] l = new double[m][m];
			double[][] u = matr;
			double[] x = new double[n];
			double[] y = new double[m];

			for (int j = 0; j < n; j++) {
				for (int i = j + 1; i < m; i++) {
					l[i][j] = u[i][j] / u[j][j];
					for (int k = j + 1; k < n; k++) {
						u[i][k] = u[i][k] - l[i][j] * u[j][k];
					}
					u[i][j] = 0;
				}
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					if (i == j) {
						l[i][j] = 1;
					}
				}
			}

			y[0] = b[0] / l[0][0];

			for (int i = 1; i < m; i++) {
				soma = 0;
				for (int j = 0; j < i; j++) {
					soma = soma + l[i][j] * y[j];
				}
				y[i] = (b[i] - soma) / l[i][i];
			}

			x[n - 1] = y[m - 1] / u[m - 1][n - 1];
			for (int i = n - 1; i >= 0; i--) {
				soma = 0;
				for (int j = i + 1; j < n; j++) {
					soma = soma + u[i][j] * x[j];
				}
				x[i] = (y[i] - soma) / u[i][i];
			}

			falu.setL(l);
			falu.setU(u);
			falu.setX(x);
			falu.setY(y);

		} catch (Exception e) {
		}
	}

	public String estudoSistema(double[][] matr, double[] b) {
		int m = matr.length;
		int n = matr[0].length;
		int nulo = 0, lnula1 = 0, lnula2 = 0;
		double mult = 0;

		for (int k = 0; k < n; k++) {
			for (int i = k + 1; i < m; i++) {
				mult = matr[i][k] / matr[k][k];
				for (int j = k; j < n; j++) {
					matr[i][j] = matr[i][j] - mult * matr[k][j];
				}
				b[i] = b[i] - mult * b[k];
			}
		}

		for (int i = 0; i < m; i++) {
			nulo = 0;
			for (int j = 0; j < n; j++) {
				if (matr[i][j] == 0) {
					nulo++;
				}
			}
			if (nulo == n) {
				lnula1++;
			}

		}
		for (int i = 0; i < m; i++) {
			nulo = 0;
			for (int j = 0; j < n; j++) {
				if (matr[i][j] == 0 && b[i] == 0) {
					nulo++;
				}
			}
			if (nulo == n) {
				lnula2++;
			}
		}

		int posto1 = m - lnula1, posto2 = m - lnula2;

		if (posto1 == posto2 && posto1 == n) {
			return "Sistema Possível e Determinado";
		} else if (posto1 == posto2 && posto1 < n) {
			return "Sistema Possível e Indeterminado";
		} else if (posto1 != posto2) {
			return "Sistema Impossível";
		}
		return "Sistema Impossível";
	}
         
    private void impSistema(double[][] mtr, double[] vet) {

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

        box.getChildren().add(paneAux);
        //box.get
    }

	public StackPane getPane() {
		caixa.setAlignment(Pos.BASELINE_LEFT);
		caixa.getChildren().add(box);

		pane = new StackPane();
		pane.setAlignment(Pos.BASELINE_LEFT);
		pane.getChildren().add(caixa);
		return pane;

	}
        
        /*n testada*/
        public double[][] corverteAmpliada(double[][] mtr, int linha, int coluna, double[] array) {
            
            double[][] mat = new double[linha][coluna+1];
            int k=0;
            for (int i = 0; i < linha; i++) {
                for (int j = 0; j < coluna+1; j++) {
                    mat[i][j] = mtr[i][j];
                    if(j == coluna){
                        mat[i][j] = array[k];
                        k++;
                    }
                }
            }
            return mat;
        }
        
    public int postoCoeficientes(double[][] mtr) {
        int p = mtr[0].length, cont;
        
        for (int i = 0; i < mtr[0].length; i++) {
            cont=0;
            for (int j = 0; j < mtr.length; j++) {
                if (mtr[i][j] == 0) {
                    cont++;
                }
            }

            if (cont == mtr.length) {
                p--;
                
            }
            //System.out.println(cont);
        }

        return p;

    }
    public int postoAmpliada(double[][] mtr, double[] arr) {
        int p = mtr[0].length, cont;
        int k = 0;
        System.out.println("SISTEMA RECEBIDO:");
        impSistema(mtr, arr);
        for (int i = 0; i < mtr[0].length; i++) {
            cont = 0;
            for (int j = 0; j < mtr.length + 1; j++) {
                if (j == mtr.length) {
                    if (arr[k] == 0) {
                        cont++;
                        k++;
                    } 
                }
                else if (mtr[i][j] == 0) {
                    cont++;
                }

            }
            if (cont == mtr.length + 1) {
                p--;
            }
            
        }
        return p;
    }
    

}
