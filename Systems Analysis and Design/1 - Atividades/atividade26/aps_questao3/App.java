package aps_questao3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application  {
	static Stage stage;
	
	
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/aps_questao3/TelaLogin.fxml"));
        Scene scene = new Scene(root); 
        stage.setTitle("Sistema de bancos");
        stage.setScene(scene); 
        stage.show();
        setStage(stage);
    }
	
    public static void main(String[] args) {
    	launch(args);
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
    	App.stage = stage;
    }
}
