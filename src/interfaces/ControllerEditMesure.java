package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.dao.GestionFamille;
import com.project.dao.GestionMesure;
import com.project.models.Famille;
import com.project.models.Mesure;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerEditMesure  implements Initializable {

	Mesure mesure;
	int id;
	public Mesure getMesure() {
		return mesure;
	}
	public void setFamille(Mesure mesure) {
		this.mesure = mesure;
	}
	@FXML 
	MenuBar myMenuBar;
	
	@FXML 
	TextField codetxt;
	@FXML 
	TextField valeurtxt;
	@FXML 
	TextField palettetxt;
	GestionMesure gm= new GestionMesure();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	//	System.out.println(famille.getIntitule());
		HolderMesure holder = HolderMesure.getInstance();
		  Mesure F= holder.getMesure();
		  System.out.println(F);
		  String code2="";
		  int palette2=0;
		  Float valeur2=(float) 0.0;
		  if(F != null) {
			  code2 =F.getCode();
			  valeur2=F.getValeur();
			  palette2=F.getId_palette();
			  id=F.getId();
		  }
		 
		  codetxt.setText(code2);
		  
		 valeurtxt.setText(valeur2.toString());
		 palettetxt.setText(palette2+"");
		 
		  
	}


	public void AnnulerMesureClick() throws IOException {
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
	   public void  enregistrerMesureClick() throws IOException {
		   
		   String newcode =codetxt.getText();
		   float newvaleur =Float.parseFloat(valeurtxt.getText());
		   int newPalette =Integer.parseInt(palettetxt.getText());
		   Mesure fam=new Mesure(newcode,newvaleur,newPalette);
		   gm.UpdateMesure(fam,id);
		   Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfaceMesure.fxml"));
	       Scene tableViewScene = new Scene(tableViewParent);
	       
	       //This line gets the Stage information
	       Stage window = (Stage)myMenuBar.getScene().getWindow();
	       
	       window.setScene(tableViewScene);
	       window.show();

	   }
	  

	
}
