package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.dao.GestionArticle;
import com.project.dao.GestionPalette;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjoutPalette implements Initializable{
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML 
	MenuBar myMenuBar;
	@FXML 
	private TextField codetxt ;
	@FXML
	private TextField poidstxt ;
	@FXML
	private TextField articletxt ;

	
	public void AnnulerPalette_click() throws IOException {
		System.out.println("Button Clicked!");
	       Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacePalette.fxml"));
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
	
	  
	    public void AjouterPalette_click() throws IOException {
	    	GestionPalette GP = new GestionPalette();
			String code3=codetxt.getText();
			String poids =poidstxt.getText(); 
	       String article  = articletxt.getText(); 
	    
	       
	       
			GP.insertion(code3,Float.parseFloat(poids) ,Integer.parseInt(article));
			 Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacePalette.fxml"));
		       Scene tableViewScene = new Scene(tableViewParent);
		     //This line gets the Stage information
		       Stage window = (Stage)myMenuBar.getScene().getWindow();
		       
		       window.setScene(tableViewScene);
		       window.show();
	    	
	    }
	

}
