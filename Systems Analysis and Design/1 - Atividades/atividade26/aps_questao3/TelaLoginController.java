package aps_questao3;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginController implements Initializable{
	
    @FXML
    private Button btEntrar;

    @FXML
    private Button btSair;

    @FXML
    private TextField txSenha;

    @FXML
    private TextField txEntrar;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        
		btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
	        	System.out.println(txSenha.getText());
	        	
	        	int cod = Integer.parseInt(txSenha.getText());
	        	
	        	if(cod == Banco.getCodigoItau())
	        		logItau();
	        	else if(cod == Banco.getCodigoBradesco())
	        		logBradesco();
			}

        });
        
	}
	
    public void fechar(){
        App.getStage().close();
    }
	
    public void logBradesco(){
    	TelaBradesco p = new TelaBradesco();
        fechar();
        try {
             p.start(new Stage());
        } catch (Exception ex) {
             //Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    public void logItau(){
    	TelaItau p = new TelaItau();
        fechar();
        try {
             p.start(new Stage());
        } catch (Exception ex) {
             //Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
