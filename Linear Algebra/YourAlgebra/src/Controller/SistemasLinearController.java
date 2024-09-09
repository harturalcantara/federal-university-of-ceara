/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SistemasLinearController  implements Initializable {

    @FXML
    private Button plus;

    @FXML
    private Button mut;

    @FXML
    private Button sub;

    @FXML
    private TextField linha;

    @FXML
    private TextField Colu;

    @FXML
    private Button setA;

    @FXML
    private Button setB;

    @FXML
    private GridPane paneB;

    @FXML
    private GridPane paneB1;

    @FXML
    private GridPane paneB11;

    @FXML
    void inicializar(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
