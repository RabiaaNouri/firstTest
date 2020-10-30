package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.dao.GestionArticle;
import com.project.dao.GestionFamille;
import com.project.dao.GestionMesure;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerAjoutArticle  implements Initializable{
	@FXML 
	MenuBar myMenuBar;
	@FXML 
	private TextField mintxt ;
	@FXML
	private TextField codetxt ;
	@FXML
	private TextField maxtxt ;
	@FXML
	private TextField designationtxt ;
	private String famille;
	@FXML
	private ChoiceBox<String> familletxt ;
	GestionFamille GF = new GestionFamille ();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 ObservableList<String> famillelist = FXCollections.observableArrayList(GF.GetFamilleListCode());
		  familletxt.setItems(famillelist);
		  familletxt.getSelectionModel().select(0);
		  famille=famillelist.get(0);
		  familletxt.getSelectionModel().selectedIndexProperty().addListener(
	    	         (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
	    	        	 famille=GF.getFamilleBycode(""+famillelist.get(new_val.intValue()));
	    	        
	    	      });
	}
	

	
	public void AnnulerArticle_click() throws IOException {
		System.out.println("Button Clicked!");
	       Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacesArticle.fxml"));
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
	
	  
	    public void AjouterArticle_click() throws IOException {
	    	GestionArticle GM = new GestionArticle();
			String code3=codetxt.getText();
			String designation =designationtxt.getText(); 
	       String poid_min  = mintxt.getText(); 
	       String poid_max  = maxtxt.getText(); 
	       
	       
			GM.insertion(code3,Float.parseFloat(poid_min),Float.parseFloat(poid_max) ,designation,Integer.parseInt(famille));
			 Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacesArticle.fxml"));
		       Scene tableViewScene = new Scene(tableViewParent);
		     //This line gets the Stage information
		       Stage window = (Stage)myMenuBar.getScene().getWindow();
		       
		       window.setScene(tableViewScene);
		       window.show();
	    	
	    }
	
}
