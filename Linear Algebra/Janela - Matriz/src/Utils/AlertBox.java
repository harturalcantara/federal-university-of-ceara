package Utils;

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
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(100);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    
    //Exibe um alerta para o usuario, caso as matrizes tenha dimencoes diferentes.
    public static void displayIllegalMatrixDimensionWarning() { 
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Erro");
        window.setMinWidth(650);

        Label label = new Label();
        label.setText("Erro! As matrizes possuem dimenções diferentes!");
        
        Button closeButton = new Button("Fechar");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(100);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    
    //Exibe um aviso ao usuario caso ele deixe deixe de criar uma matriz, que e requisitada para uma operacao.
    public static void avisoMatrizVazia(char a) { 
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Aviso");
        window.setMinWidth(400);

        Label label = new Label();
        label.setText("Aviso, a sua matriz "+a+ " está vazia!");
        
        Button closeButton = new Button("Fechar");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(100);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    
    public static void avisoCampoVazio() { 
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Erro");
        window.setMinWidth(400);

        Label label = new Label();
        label.setText("Aviso, a operação necessita do preenchimento do campo ao lado!");
        
        Button closeButton = new Button("Fechar");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(100);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}