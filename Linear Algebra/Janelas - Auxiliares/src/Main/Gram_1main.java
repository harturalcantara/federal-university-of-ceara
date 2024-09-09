package Main;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Gram_1main extends Application {
    private static Stage stage;
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        try {
            Parent root = (BorderPane) FXMLLoader.load(getClass().getResource("/View/PassosGauss.fxml"));
            Scene scene = new Scene(root, 300, 400); 
            //scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
            stage.setScene(scene);
            //stage.setResizable(false);
            stage.show();
            setStage(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Gram_1main.stage = stage;
    }
    

}
