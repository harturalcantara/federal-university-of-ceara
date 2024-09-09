package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PageOne extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		try {
			
						
		
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Controle.fxml"));

			//StackPane root = new StackPane();
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		arg0.centerOnScreen();
		arg0.setTitle("Algebra Linear");
		arg0.setScene(scene);
		arg0.show();

		
		
	}
	catch(Exception e) {
				e.printStackTrace();
	}
		
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
