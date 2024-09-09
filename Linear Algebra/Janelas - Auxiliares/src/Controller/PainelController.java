/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.GramSchmitd;
import Main.LinearAlgebra;
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

import Main.Matrizes;
import Main.Painel;
import Main.SistemaLineares;


public class PainelController implements Initializable {

    @FXML
    private Button btMatrizes;
    @FXML
    private Button btSisLine;
    @FXML
    private Button btGram;
    @FXML
    private Button btVolta;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
        btMatrizes.setOnMouseClicked((MouseEvent e)->{
            logMatrizes();
        });
        
        btMatrizes.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                logMatrizes();
        });
        
        btSisLine.setOnMouseClicked((MouseEvent e)->{
            logSistema();
        });
        
        btSisLine.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                logSistema();
        });
        btGram.setOnMouseClicked((MouseEvent e)->{
            logGram();
        });
        
        btGram.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                logGram();
        });
        btVolta.setOnMouseClicked((MouseEvent e)->{
            btVolta();
        });
        
        btVolta.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER)
                btVolta();
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
    
    public void logGram(){
        GramSchmitd p = new GramSchmitd();
        fechar();
        try {
             p.start(new Stage());
             
        } catch (Exception ex) {
             Logger.getLogger(PainelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void logSistema(){
        SistemaLineares p = new SistemaLineares();
        fechar();
        try {
             p.start(new Stage());
        } catch (Exception ex) {
             Logger.getLogger(PainelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void btVolta(){
        LinearAlgebra p = new LinearAlgebra();
        fechar();
        try {
             p.start(new Stage());
             
        } catch (Exception ex) {
             Logger.getLogger(PainelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
