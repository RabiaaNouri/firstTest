package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.dao.GestionArticle;
import com.project.dao.GestionPalette;
import com.project.models.Article;
import com.project.models.Palette;

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

public class ControllerPalette  implements Initializable{
	@FXML
	MenuBar myMenuBar;
	@FXML
	TableView<Palette> table;
	@FXML
	private TableColumn<Palette,String> codetxt;
	@FXML
	private TableColumn<Palette, String> poidstxt;
	@FXML
	private TableColumn<Palette,String> articletxt;
	@FXML
	private TableColumn<Palette, Palette> Actionstxt;
	
	GestionPalette GM = new GestionPalette();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
         showpalette();
	}

	public void showpalette() {
		final ObservableList<Palette> data = FXCollections.observableArrayList(GM.GetPaletteList()

		);
		// System.out.println( Mesure.GetMesureList_article());
		codetxt.setCellValueFactory(new PropertyValueFactory<Palette, String>("Code"));
		poidstxt.setCellValueFactory(new PropertyValueFactory<Palette, String>("poids"));
		articletxt.setCellValueFactory(new PropertyValueFactory<Palette, String>("id_article"));
		Actionstxt.setCellFactory(param -> new TableCell<Palette, Palette>() {
			private final Button editButton = new Button("edit");
			private final Button deleteButton = new Button("delete");

			@Override
			protected void updateItem(Palette palette, boolean empty) {
				// super.updateItem(famille, empty);
				if (empty == true) {
					setGraphic(null);
					return;
				}
				deleteButton.setOnAction(event -> {
					Palette getPalette = getTableView().getItems().get(getIndex());
					GM.deletePalette(getPalette.getId());
					showpalette();

				});

				editButton.setOnAction(event -> {
					Palette getPalette = getTableView().getItems().get(getIndex());
					Node node = (Node) event.getSource();
					Stage stage = (Stage) node.getScene().getWindow();
					stage.close();
					try {
						
						// Step 2
						HolderPalette holder = HolderPalette.getInstance();
						// Step 3
						holder.setPalette(getPalette);
						Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("interfaces/EditPalette.fxml"));
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

	public void closeclick(ActionEvent event) {
		System.exit(0);

	}

	public void ajouterPalette_click() throws IOException {

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjoutPalette.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) myMenuBar.getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();

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
