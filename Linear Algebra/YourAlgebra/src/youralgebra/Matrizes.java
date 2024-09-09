package youralgebra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author hartu
 */


public class Matrizes extends Application{
    
    private static Stage stage;
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/matrix_display.fxml"));
        primaryStage.setTitle("MatrixCalculator");
        setStageParams(primaryStage);
        primaryStage.setScene(createScene(root));
        primaryStage.show();
    }

    public static void setStageParams(Stage primaryStage) {
        primaryStage.setMaxWidth(1600);
        primaryStage.setMaxHeight(800);
    }

    
    public static Scene createScene(Parent root) {
        Scene scene = new Scene(root, 1600, 800);
        return scene;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Matrizes.stage = stage;
    }
}
