package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LinearAlgebra extends Application {
    static Stage stage;
    
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/LinearAlgebra.fxml")); //carrega FXML
        Scene scene = new Scene(root, 1680, 930); //coloca o FXML em uma cena
        stage.setTitle("LinearAlgebra");
        stage.setScene(scene); // Coloca a cena em uma janela
        stage.setResizable(false);
        stage.show(); //abre a janela
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        LinearAlgebra.stage = stage;
    }
    
}
