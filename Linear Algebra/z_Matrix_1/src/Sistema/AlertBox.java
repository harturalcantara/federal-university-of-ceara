package Sistema;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(650);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close");
        //closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(100);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void displayIllegalMatrixDimensionWarning() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Error");
        window.setMinWidth(650);

        Label label = new Label();
        label.setText("matrizes de dimencoes diferentes");
        Button closeButton = new Button("Fechar");
        //closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(100);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}