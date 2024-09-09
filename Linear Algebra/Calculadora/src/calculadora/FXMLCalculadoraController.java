package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Aprendendo JavaFx
 *
 * @author hartu
 */

public class FXMLCalculadoraController implements Initializable {

    double value1 = 0;
    double value2 = 0;
    double result = 0;
    String operacao = "";

    @FXML private TextField telaTextField;
    @FXML private Button resetaButton;
    @FXML private Button seteButton;
    @FXML private Button quatroButton;
    @FXML private Button umButton;
    @FXML private Button zeroButton;
    @FXML private Button oitoButton;
    @FXML private Button cincoButton;
    @FXML private Button doisButton;
    @FXML private Button pontoButton;
    @FXML private Button divisaoButton;
    @FXML private Button noveButton;
    @FXML private Button seisButton;
    @FXML private Button tresButton;
    @FXML
    private Button multiplicacaoButton;
    @FXML
    private Button subtracaoButton;
    @FXML
    private Button somaButton;
    @FXML
    private Button igualButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        umButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + "1");
            }
        });

        doisButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + "2");
            }
        });
        tresButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + "3");
            }
        });
        quatroButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + "4");
            }
        });
        cincoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + "5");
            }
        });
        seisButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + "6");
            }
        });
        seteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + "7");
            }
        });
        oitoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + "8");
            }
        });
        noveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + "9");
            }
        });
        zeroButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + "0");
            }
        });
        
        pontoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText(telaTextField.getText() + ".");
            }
        });
        
        /** Operacoes*/
        somaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                value1 = Double.parseDouble(telaTextField.getText());
                telaTextField.setText("");
                operacao = "+";

            }
        });
        subtracaoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                value1 = Double.parseDouble(telaTextField.getText());
                telaTextField.setText("");
                operacao = "-";

            }
        });
        multiplicacaoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                value1 = Double.parseDouble(telaTextField.getText());
                telaTextField.setText("");
                operacao = "*";

            }
        });
        divisaoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                value1 = Double.parseDouble(telaTextField.getText());
                telaTextField.setText("");
                operacao = "/";

            }
        });
        
        resetaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                telaTextField.setText("");
                value1 = 0;
                value2 = 0;
                operacao = "";

            }
        });
        
       igualButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                value2 = Double.parseDouble(telaTextField.getText());
                switch(operacao){
                    case "+":
                        result = value1 + value2;
                        telaTextField.setText(String.valueOf(result));
                        break;
                    case "-":
                        result = value1 - value2;
                        telaTextField.setText(String.valueOf(result));
                        break;
                    case "*":
                        result = value1 * value2;
                        telaTextField.setText(String.valueOf(result));
                        break;
                    case "/":
                        result = value1 / value2;
                        telaTextField.setText(String.valueOf(result));
                        break;
                }
                operacao = "";
                value1 = 0;
                value2 = 0;
            }
        });
    }
}
