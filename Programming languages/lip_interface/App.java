package lip_interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application  {
	static Stage stage;
	
	
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/lip_interface/TelaLogin.fxml"));
        Scene scene = new Scene(root); 
        stage.setTitle("Painel");
        stage.setScene(scene); 
        stage.show();
        setStage(stage);
    }
	
    public static void main(String[] args) {
    	launch(args);
    }
    
    public static Stage getSta() {
        return stage;
    }

    public static void setStage(Stage stage) {
    	App.stage = stage;
    }
}
