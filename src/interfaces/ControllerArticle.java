package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.dao.GestionArticle;
import com.project.models.Article;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControllerArticle implements Initializable {

	@FXML
	MenuBar myMenuBar;
	@FXML
	TableView<Article> table;
	@FXML
	private TableColumn<Article,String> code;
	@FXML
	private TableColumn<Article, String> designations;
	@FXML
	private TableColumn<Article,String> famille;
	@FXML
	private TableColumn<Article, Article> Actions;
	
	GestionArticle Article = new GestionArticle();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
         showarticle();
	}

	public void showarticle() {
		final ObservableList<Article> data = FXCollections.observableArrayList(Article.GetArticletList()

		);
		// System.out.println( Mesure.GetMesureList_article());
		code.setCellValueFactory(new PropertyValueFactory<Article, String>("Code"));
		designations.setCellValueFactory(new PropertyValueFactory<Article, String>("designation"));
		famille.setCellValueFactory(new PropertyValueFactory<Article, String>("id_famille"));
		Actions.setCellFactory(param -> new TableCell<Article, Article>() {
			private final Button editButton = new Button("edit");
			private final Button deleteButton = new Button("delete");

			@Override
			protected void updateItem(Article article, boolean empty) {
				// super.updateItem(famille, empty);
				if (empty == true) {
					setGraphic(null);
					return;
				}
				deleteButton.setOnAction(event -> {
					Article getArticle = getTableView().getItems().get(getIndex());
					Article.deleteArticle(getArticle.getId());
					showarticle();

				});

				editButton.setOnAction(event -> {
					Article getArticle = getTableView().getItems().get(getIndex());
					Node node = (Node) event.getSource();
					Stage stage = (Stage) node.getScene().getWindow();
					stage.close();
					try {
						
						// Step 2
						HolderArticle holder = HolderArticle.getInstance();
						// Step 3
						holder.setArticle(getArticle);
						Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("interfaces/EditArticle.fxml"));
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

	public void ajouterArticle_click() throws IOException {

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("AjoutArticle.fxml"));
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
