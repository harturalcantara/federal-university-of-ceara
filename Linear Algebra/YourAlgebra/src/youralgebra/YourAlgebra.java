package youralgebra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author hartu
 */
public class YourAlgebra extends Application {
    static Stage stage;
    
    
    
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/FXMLYourAlgebra.fxml")); //carrega FXML
        Scene scene = new Scene(root); //coloca o FXML em uma cena
        stage.setTitle("YourAlgebra");
        stage.setScene(scene); // Coloca a cena em uma janela
        stage.show(); //abre a janela
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        YourAlgebra.stage = stage;
    }
    
}
