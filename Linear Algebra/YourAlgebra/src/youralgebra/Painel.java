package youralgebra;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painel extends Application {
    private static Stage stage;
    
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLPainel.fxml")); //carrega FXML
        Scene scene = new Scene(root); //coloca o FXML em uma cena
        stage.setTitle("Painel");
        stage.setScene(scene); // Coloca a cena em uma janela
        stage.show(); //abre a janela
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Painel.stage = stage;
    }
    
}