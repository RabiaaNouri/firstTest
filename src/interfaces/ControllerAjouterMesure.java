package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.dao.GestionFamille;
import com.project.dao.GestionMesure;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerAjouterMesure  implements Initializable{
	
	ObservableList<String>TypePalette =FXCollections.observableArrayList("P001","P002");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void Initialize() {
		((ChoiceBox) TypePalette).setItems(TypePalette);
		((ChoiceBox) TypePalette).setValue("00");
	}
	@FXML 
	MenuBar myMenuBar;
	@FXML 
	private TextField palettech ;
	@FXML
	private TextField codetxt ;
	@FXML
	private TextField valeurtxt ;
	
	public void AnnulerMesure_click() throws IOException {
		System.out.println("Button Clicked!");
	       Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfaceMesure.fxml"));
	       Scene tableViewScene = new Scene(tableViewParent);
	     //This line gets the Stage information
	       Stage window = (Stage)myMenuBar.getScene().getWindow();
	       
	       window.setScene(tableViewScene);
	       window.show();
	      // System.out.println(event.getSource());
	}
	public void familleclick(ActionEvent event) throws IOException {
	       System.out.println("Button Clicked!");
	       Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfaceFamille.fxml"));
	       Scene tableViewScene = new Scene(tableViewParent);
	     //This line gets the Stage information
	       Stage window = (Stage)myMenuBar.getScene().getWindow();
	       
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
	       
	       //This line gets the Stage information
	       Stage window = (Stage)myMenuBar.getScene().getWindow();
	       
	       window.setScene(tableViewScene);
	       window.show();
	      // System.out.println(event.getSource());
	      
	   }
	  public void rapportclick(ActionEvent event) throws IOException {
		   System.out.println("Button Clicked!");
	       Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfaceRapport.fxml"));
	       Scene tableViewScene = new Scene(tableViewParent);
	     //This line gets the Stage information
	       Stage window = (Stage)myMenuBar.getScene().getWindow();
	       
	       window.setScene(tableViewScene);
	       window.show();
	      // System.out.println(event.getSource());
	      
	       
	       
	      
	      
	      
	   }
	  public void PaletteClick(ActionEvent event) throws IOException {
	      // System.out.println("Button Clicked!");
	      
	       Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacePalette.fxml"));
	       Scene tableViewScene = new Scene(tableViewParent);
	       
	       //This line gets the Stage information
	       Stage window = (Stage)myMenuBar.getScene().getWindow();
	       
	       window.setScene(tableViewScene);
	       window.show();
	      // System.out.println(event.getSource());
	      
	   }
	   public void MesureClick(ActionEvent event) throws IOException {
		      // System.out.println("Button Clicked!");
		      
		       Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfaceMesure.fxml"));
		       Scene tableViewScene = new Scene(tableViewParent);
		       
		       //This line gets the Stage information
		       Stage window = (Stage)myMenuBar.getScene().getWindow();
		       
		       window.setScene(tableViewScene);
		       window.show();
		      // System.out.println(event.getSource());
		      
		   }
	
	  
	    public void AjouterMesure_click() throws IOException {
	    	GestionMesure GM = new GestionMesure ();
			String code3=codetxt.getText();
			String valeur2 =valeurtxt.getText(); 
			String palette2 =palettech.getText(); 
			GM.insertion(code3,Float.parseFloat(valeur2),Integer.parseInt(palette2));
			 Parent tableViewParent = FXMLLoader.load(getClass().getResource("InterfaceMesure.fxml"));
		       Scene tableViewScene = new Scene(tableViewParent);
		     //This line gets the Stage information
		       Stage window = (Stage)myMenuBar.getScene().getWindow();
		       
		       window.setScene(tableViewScene);
		       window.show();
	    	
	    }
	

}
