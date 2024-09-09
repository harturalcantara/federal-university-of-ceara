package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Matrizes extends Application{
    private static Stage stage;
    
    public static void main(String[] args){
        launch(args);
    }
        
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Matriz.fxml"));
        Scene scene = new Scene(root, 1680, 930);
        stage.setTitle("Matrizes");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Matrizes.stage = stage;
    }
    
}