package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.dao.GestionFamille;
import com.project.models.Famille;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MyController implements Initializable {
	@FXML
	MenuBar myMenuBar;
	@FXML
	private Button myButton;

	@FXML
	private TextField myTextField;
	@FXML
	private TableView<Famille> table;

	@FXML
	private TableColumn<Famille, String> code;
	@FXML
	private TableColumn<Famille, String> intitule;
	@FXML
	private TableColumn<Famille, Famille> Actions;

	GestionFamille fam = new GestionFamille();

	@FXML
	private void handleButtonAction(ActionEvent event) {
		System.out.println("You clicked me!");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		showFamille();

	}

	public void showFamille() {
		final ObservableList<Famille> data = FXCollections.observableArrayList(fam.GetFamilleList());
		code.setCellValueFactory(new PropertyValueFactory<Famille, String>("code"));
		intitule.setCellValueFactory(new PropertyValueFactory<Famille, String>("intitule"));
		Actions.setCellFactory(param -> new TableCell<Famille, Famille>() {
			private final Button editButton = new Button("edit");
			private final Button deleteButton = new Button("delete");

			@Override
			protected void updateItem(Famille famille, boolean empty) {
				// super.updateItem(famille, empty);
				if (empty == true) {
					setGraphic(null);
					return;
				}
				deleteButton.setOnAction(event -> {
					Famille getfamille = getTableView().getItems().get(getIndex());
					fam.deleteFamille(getfamille.getId());
					showFamille();

				});

				editButton.setOnAction(event -> {

					Famille getfamille = getTableView().getItems().get(getIndex());

					Node node = (Node) event.getSource();
					Stage stage = (Stage) node.getScene().getWindow();
					stage.close();
					try {
						// Step 2
						HolderFamille holder = HolderFamille.getInstance();
						// Step 3
						holder.setFamille(getfamille);
						Parent root = FXMLLoader
								.load(getClass().getClassLoader().getResource("interfaces/EditFamille.fxml"));

						// Step 4
						Scene scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
					} catch (IOException e) {
						System.err.println(String.format("Error: %s", e.getMessage()));
					}

				});

				HBox pane = new HBox(deleteButton, editButton);
				setGraphic(pane);
			}
		});

		table.setItems(data);

	}

	// When user click on myButton
	// this method will be called.
	public void familleclick(ActionEvent event) throws IOException {
		System.out.println("Button Clicked!");
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfaceFamille.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
		// System.out.println(event.getSource());

	}

	public void closeclick(ActionEvent event) {
		System.exit(0);

	}

	public void AjouetrFamill_click() throws IOException {

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjoutFamille.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();

	}

	public void articleclick(ActionEvent event) throws IOException {
		// System.out.println("Button Clicked!");

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacesArticle.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
		// System.out.println(event.getSource());

	}

	public void rapportclick(ActionEvent event) throws IOException {
		System.out.println("Button Clicked!");
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfaceRapport.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();

	}

	public void PaletteClick(ActionEvent event) throws IOException {
		// System.out.println("Button Clicked!");

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacePalette.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();

	}

	public void MesureClick(ActionEvent event) throws IOException {

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("InterfaceMesure.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();

	}

}