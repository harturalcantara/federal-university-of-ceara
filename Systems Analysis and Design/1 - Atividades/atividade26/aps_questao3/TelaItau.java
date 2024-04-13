package aps_questao3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaItau extends Application  {

    public void  start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/aps_questao3/TelaItau.fxml"));
        Scene scene = new Scene(root); 
        stage.setTitle("Bem vindo ao Itau!");
        stage.setScene(scene); 
        stage.show(); 
    }
	
    public static void main(String[] args) {
    	launch(args);
    }
}
