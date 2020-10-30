package com.project.run;
import com.project.dao.GestionFamille;
import com.project.models.Famille;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class MyApplication extends Application {
	@Override
 public void start(Stage primaryStage) {
			try {
			
// Read file fxml and draw interface.
Parent root = FXMLLoader.load(getClass().getResource("/interfaces/InterfaceFamille.fxml"));
primaryStage.setTitle("");
primaryStage.setScene(new Scene(root));
primaryStage.show();

}
catch(Exception e) {
			e.printStackTrace();
			}}
	public static void main (String[] args ) {
		launch(args);
	}
}