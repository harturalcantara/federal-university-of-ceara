package lip_interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaGato extends Application  {

    public void  start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/lip_interface/TelaGato.fxml"));
        Scene scene = new Scene(root); 
        stage.setTitle("Gato");
        stage.setScene(scene); 
        stage.show(); 
    }
	
    public static void main(String[] args) {
    	launch(args);
    }
}
