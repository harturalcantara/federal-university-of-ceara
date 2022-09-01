package lip_interface;


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
    private TextField txEntrar;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        
		btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
	        	System.out.println("alou");
				System.out.println(txEntrar.getText());
	        	
	        	String cod = txEntrar.getText();
	        	
	        	if(cod.equals("Cachorro")) {
	        		System.out.println("CACHORRO");
	        		logCachorro();
	        	}
	        	else if(cod.equals("Gato")) {
	        		System.out.println("GATO");
	        		logGato();
	        	}
	        	else if(cod.equals("Galinha")) {
	        		System.out.println("GALINHA");
	        		logGalinha();
	        	}
			}

        });
        
	}
	
    public void fechar(){
        App.getSta().close();
    }
	
    public void logCachorro(){
    	TelaCachorro p = new TelaCachorro();
        fechar();
        try {
             p.start(new Stage());
        } catch (Exception ex) {
             //Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void logGato(){
    	TelaGato p = new TelaGato();
        fechar();
        try {
             p.start(new Stage());
        } catch (Exception ex) {
             //Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void logGalinha(){
    	TelaGalinha p = new TelaGalinha();
        fechar();
        try {
             p.start(new Stage());
        } catch (Exception ex) {
             //Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
