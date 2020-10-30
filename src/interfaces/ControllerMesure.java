package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.dao.GestionMesure;
import com.project.models.Mesure;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControllerMesure implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showmesure();
		// TODO Auto-generated method stub

	}

	@FXML
	MenuBar myMenuBar;
	@FXML
	private TableColumn<Mesure, String> code;
	@FXML
	private TableColumn<Mesure, String> valeur;
	@FXML
	private TableColumn<Mesure, Mesure> action;
	@FXML
	private TableColumn<Mesure, String> palette;
	@FXML
	private TableColumn<Mesure, String> article;
	@FXML
	TableView<Mesure> table;
	@FXML
	private Button myButton;

	GestionMesure Mesure = new GestionMesure();

	@FXML
	private void handleButtonAction(ActionEvent event) {
		System.out.println("You clicked me!");

	}

	public void showmesure() {
		final ObservableList<Mesure> data = FXCollections.observableArrayList(Mesure.GetMesureList_article()

		);
		// System.out.println( Mesure.GetMesureList_article());
		code.setCellValueFactory(new PropertyValueFactory<Mesure, String>("Code"));
		valeur.setCellValueFactory(new PropertyValueFactory<Mesure, String>("Valeur"));
		palette.setCellValueFactory(new PropertyValueFactory<Mesure, String>("id_palette"));
		article.setCellValueFactory(new PropertyValueFactory<Mesure, String>("id_article"));
		action.setCellFactory(param -> new TableCell<Mesure, Mesure>() {
			private final Button editButton = new Button("edit");
			private final Button deleteButton = new Button("delete");

			@Override
			protected void updateItem(Mesure mesure, boolean empty) {
				// super.updateItem(famille, empty);
				if (empty == true) {
					setGraphic(null);
					return;
				}
				deleteButton.setOnAction(event -> {
					Mesure getMesure = getTableView().getItems().get(getIndex());
					Mesure.deleteMesure(getMesure.getId());
					showmesure();

				});

				editButton.setOnAction(event -> {
					Mesure getMesure = getTableView().getItems().get(getIndex());

					Node node = (Node) event.getSource();
					Stage stage = (Stage) node.getScene().getWindow();
					stage.close();
					try {
						// Step 2
						HolderMesure holder = HolderMesure.getInstance();
						// Step 3
						holder.setMesure(getMesure);
						Parent root = FXMLLoader
								.load(getClass().getClassLoader().getResource("interfaces/EditMesure.fxml"));

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

	public void AjouterMesure_click() throws IOException {

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjouterMesure.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();

	}

	public void AnnulerFamilleClick() throws IOException {
		System.out.println("Button Clicked!");
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfaceMesure.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
		// System.out.println(event.getSource());

	}

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
		// System.out.println(event.getSource());

	}

	public void PaletteClick(ActionEvent event) throws IOException {
		// System.out.println("Button Clicked!");

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacePalette.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
		// System.out.println(event.getSource());

	}

	public void MesureClick(ActionEvent event) throws IOException {
		// System.out.println("Button Clicked!");

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfaceMesure.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
		// System.out.println(event.getSource());

	}

}
