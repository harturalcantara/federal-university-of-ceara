package matrixgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Main class that extends {@link Application} in order for JavaFX to work
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method that gets resources and launch the main scene
     *
     * @param primaryStage  Primary Stage to display a scene
     * @throws Exception   throws Exception if there is no resources provided
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/layouts/matrix_display.fxml"));
        primaryStage.setTitle("MatrixCalculator");
        setStageParams(primaryStage);
        primaryStage.setScene(createScene(root));
        primaryStage.show();
    }

    /**
     * Set default stage width and height
     *
     * @param primaryStage  Primary Stage to display a scene
     */
    public static void setStageParams(Stage primaryStage) {
        primaryStage.setMaxWidth(1600);
        primaryStage.setMaxHeight(800);
    }

    /**
     * Creates default scene
     *
     * @param root  FXML resource for the Scene
     * @return      Scene to display
     */
    public static Scene createScene(Parent root) {
        Scene scene = new Scene(root, 1600, 800);
        return scene;
    }

}
