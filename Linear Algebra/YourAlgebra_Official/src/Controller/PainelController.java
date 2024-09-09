/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import youralgebra.Calculadora;
import youralgebra.Matrizes;
import youralgebra.Painel;


/**
 * FXML Controller class
 *
 * @author hartu
 */
public class PainelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button btCalculator;
    @FXML private Button btMatrizes;
    @FXML private Button btSisLine;
    @FXML private Button btBack;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btCalculator.setOnMouseClicked((MouseEvent e)->{
            logCalculator();
        });
        
        btCalculator.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                logCalculator();
        });
        
        btMatrizes.setOnMouseClicked((MouseEvent e)->{
            logMatrizes();
        });
        
        btMatrizes.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                logMatrizes();
        });
    }    
    
    public void fechar(){
        Painel.getStage().close();
    }
    
    public void logMatrizes(){
        Matrizes p = new Matrizes();
        fechar();
        try {
             p.start(new Stage());
             
        } catch (Exception ex) {
             Logger.getLogger(PainelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void logCalculator(){
        Calculadora p = new Calculadora();
        fechar();
        try {
             p.start(new Stage());
        } catch (Exception ex) {
             Logger.getLogger(PainelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
