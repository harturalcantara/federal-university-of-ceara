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



public class LinearAlgebraController implements Initializable {

    @FXML
    private Button btEntrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btEntrar.setOnMouseClicked((MouseEvent e) -> {
            logPainel();
        });

//        btEntrar.setOnKeyPressed((KeyEvent e)->{
//            if(e.getCode() == KeyCode.ENTER)
//                logPainel();
//        });
//        
//        btSair.setOnMouseClicked( (MouseEvent e)->{
//            fechar();
//        });  
//        
//        btSair.setOnKeyPressed((KeyEvent e)->{
//            if(e.getCode() == KeyCode.ENTER)
//                fechar();
//        });   
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
