package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Main.Painel;
import Main.LinearAlgebra;
import Utils.AlertBox;



public class LinearAlgebraController implements Initializable {

    @FXML
    private Button btEntrar;
    @FXML
    private Button btSair;
    @FXML
    private Button btInfo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btEntrar.setOnMouseClicked((MouseEvent e) -> {
            logPainel();
        });

        btEntrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                logPainel();
        });
        
        
        btInfo.setOnMouseClicked((MouseEvent e) -> {
            AlertBox.display("INFORMAÇÕES", "DESENVOLVEDORES FÁBIO SANTOS E HARTUR ALCÂNTARA"+"\n"
                    + "PROJETO DEDICADO A DISCIPLINA DE ÁLGEBRA LINEAR SEMESTRE 2018.2!");
        });

        btInfo.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                AlertBox.display("Erro", "A matriz 'A' está vázia!");
        });
        
        btSair.setOnMouseClicked( (MouseEvent e)->{
            fechar();
        });  
        
        btSair.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                fechar();
        });   
    }

    public void fechar() {
        LinearAlgebra.getStage().close();
    }

    public void logPainel() {
        Painel p = new Painel();
        fechar();
        try {
            p.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(LinearAlgebraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
