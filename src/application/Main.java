package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	 private Stage stage;
	 private Scene scene;
	 private Parent root;

	@Override
	public void start(Stage arg0) throws Exception {
		// stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        arg0.setScene(scene);
        arg0.show();
		arg0.setTitle("Sports Management System");
		//MySQLHandler m = new MySQLHandler();
		//m.deleteaRow("Surgery");

		}
	 public static void main(String[] args) {
		 Application.launch(args);
	    }
}
