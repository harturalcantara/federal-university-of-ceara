package Sistema;


import Utils.Matriz;
import Utils.Gauss;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;



public class SistemasLinearController  implements Initializable {
    private static final double EPSILON = 1e-8;
    private TextField text;
    private Matriz matA;
    private Matriz matB;
    
    @FXML private TextField tfLinha;
    @FXML private TextField tfColuna;
    @FXML private Button btSetSistema;
    @FXML private Button btGauss;
    @FXML private Button btGaussJordan;
    @FXML private GridPane gpTermoA;
    @FXML private GridPane gpTermoB;
    @FXML private GridPane gpTermoC;
    

    @FXML private Button btVoltar;
    
    @FXML
    private Button btPostoAmpli;

    @FXML
    private Button btFartoracaoLU;
    
    
    @FXML
    private GridPane paneB;


    @FXML
    private GridPane paneB1;

    @FXML
    private GridPane paneB12;

    @FXML
    private GridPane paneB11;

    @FXML
    void inicializar(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        if (tfLinha.getText() == null && tfColuna.getText() == null) { //Errado
            Alert alert = new Alert(AlertType.ERROR, "ERRO 404 !!");
            alert.show();
        }
               
        btSetSistema.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                matA = new Matriz(Integer.parseInt(tfLinha.getText()), Integer.parseInt(tfColuna.getText()));
                matB = new Matriz(Integer.parseInt(tfLinha.getText()), 1);
                gpTermoA = geraMatriz(matA, gpTermoA);
                gpTermoB = geraMatriz(matB, gpTermoB);
            }
        });
        

        
        btGauss.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                    matA = getElementos(matA, gpTermoA);
                    matB = getElementos(matB, gpTermoB);
                    //double []vetorB = new double[];
                    //vetorB  = covertArray(matB, vetorB);

                    Show( matA.metGauss(matA.mat, matB ) );
            }

        });
        /*
        btGaussJordan.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                    matA = getElementos(matA, gpTermoA);
                    matB = getElementos(matB, gpTermoB);
                    
                    //double b[] = convertArray(matB, b);
                    
                    
                    //Show( a.plus(b) );
            }

        });*/
        
        
    }
       
    
    private Matriz getElementos(Matriz matriz, GridPane paneX) {
        for (int j = 0; j < matriz.getM(); j++) {
            for (int i = 0; i < matriz.getN(); i++) {
                
                if (!((TextField) paneX.getChildren().get(i * matriz.getM() + j)).getText().isEmpty()) {
                    
                    matriz.mat[i][j] = Double.parseDouble(((TextField) paneX.getChildren().get(i * matriz.getM() + j)).getText());
                    
                }
                // System.out.println("M"+((TextField) pane.getChildren().get(i * a.getM() +
                // j)).getText());
            }
        }
        return matriz;
    }
    
    private GridPane geraMatriz(Matriz matriz, GridPane paneX) {
        paneX.getChildren().clear();
        for (int i = 0; i < matriz.getM(); i++) {
            for (int j = 0; j < matriz.getN(); j++) {
                text = new TextField();
                text.setPrefWidth(30);
                text.setPrefHeight(30);
                paneX.add(text, i, j);
            }
        }
        return paneX;
    }
    
    private void Show(Matriz matriz) {
	gpTermoC.getChildren().clear();

        for (int i = 0; i < matriz.getM(); i++) {
                for (int j = 0; j < matriz.getN(); j++) {
                    text = new TextField();
                    text.setPrefWidth(70);
                    text.setPrefHeight(70);
                    text.setText(String.valueOf(matriz.mat[i][j]));
                    gpTermoC.add(text, i, j);
                }
        }
    }
    
    private void ShowVet(double []matriz) {
	gpTermoC.getChildren().clear();

        //for (int i = 0; i < matriz.getM(); i++) {
                for (int j = 0; j < matriz.length; j++) {
                    text = new TextField();
                    text.setPrefWidth(50);
                    text.setPrefHeight(50);
                    text.setText(String.valueOf(matriz[j]));
                    gpTermoC.add(text, 0, j); // public void add(Node child, int columnIndex, int rowIndex);
                }
        //}
    }
}
