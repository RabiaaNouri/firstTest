package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.dao.GestionArticle;
import com.project.dao.GestionPalette;
import com.project.models.Article;
import com.project.models.Palette;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerEditPalette  implements Initializable {
	Palette palette ;
	int id;
	public Palette getPalette() {
		return palette;
	}
	public void setPalette(Palette palette) {
		this.palette = palette;
	}
	@FXML 
	MenuBar myMenuBar;
	@FXML
	private TextField codetxt ;
	@FXML
	private TextField articletxt;
	@FXML
	private TextField poidstxt ;
	GestionPalette GP= new GestionPalette();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	//	System.out.println(famille.getIntitule());
		HolderPalette holder = HolderPalette.getInstance();
		  Palette p= holder.getPalette();
		 codetxt.setText(p.getCode());
		  
		 articletxt.setText(p.getId_article()+"");
		 poidstxt.setText(p.getPoids().toString());
		
		 id=p.getId();
		  
	}


	public void AnnulerPalette_click() throws IOException {
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
	   }
	   public void PaletteClick(ActionEvent event) throws IOException {
		      // System.out.println("Button Clicked!");
		      
		       Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacePalette.fxml"));
		       Scene tableViewScene = new Scene(tableViewParent);
		       
		       //This line gets the Stage information
		       Stage window = (Stage)myMenuBar.getScene().getWindow();
		       
		       window.setScene(tableViewScene);
		       window.show();
		  
		      
		   }
	   public void MesureClick(ActionEvent event) throws IOException {

		      
		       Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfaceMesure.fxml"));
		       Scene tableViewScene = new Scene(tableViewParent);
		       
		       //This line gets the Stage information
		       Stage window = (Stage)myMenuBar.getScene().getWindow();
		       
		       window.setScene(tableViewScene);
		       window.show();
		   
		      
		   }
	   public void  ModifierPalette_click() throws IOException {
		   
		   String newcode =codetxt.getText();
		   int newarticle =Integer.parseInt(articletxt.getText());
		   float newpoids =Float.parseFloat(poidstxt.getText());
		   Palette palette=new Palette(newcode,newpoids,newarticle);
		   GP.UpdatePalette(palette,id);
		   Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacePalette.fxml"));
	       Scene tableViewScene = new Scene(tableViewParent);
	       
	       //This line gets the Stage information
	       Stage window = (Stage)myMenuBar.getScene().getWindow();
	       
	       window.setScene(tableViewScene);
	       window.show();

	   }
	  

}
