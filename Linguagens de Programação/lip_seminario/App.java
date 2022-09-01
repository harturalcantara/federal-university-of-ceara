package lip_seminario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App {
	
	public static void main(String args[]) {
		Teste p = new Teste();
	    p.facaAnimalComer(new Cachorro());
	    p.facaAnimalComer(new Gato());
	    p.facaAnimalComer(new Galinha());
	}
	
}

