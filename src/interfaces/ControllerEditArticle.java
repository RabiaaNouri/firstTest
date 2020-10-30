package interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.dao.GestionArticle;
import com.project.dao.GestionMesure;
import com.project.models.Article;
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

public class ControllerEditArticle implements Initializable{
	Article article ;
	int id;
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
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
	
	@FXML
	private TextField familletxt ;
	
	
	GestionArticle gm= new GestionArticle();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	//	System.out.println(famille.getIntitule());
		HolderArticle holder = HolderArticle.getInstance();
		  Article F= holder.getArticle();
		 codetxt.setText(F.getCode());
		  
		 designationtxt.setText(F.getDesignation());
		 mintxt.setText(F.getPoid_min().toString());
		 maxtxt.setText(F.getPoids_max().toString());
		 familletxt.setText(F.getId_famille()+"");
		 id=F.getId();
		  
	}


	public void AnnulerArticle_click() throws IOException {
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
	   public void  ModifierArticle_click() throws IOException {
		   
		   String newcode =codetxt.getText();
		   String newdesignation =designationtxt.getText();
		   int newfamille =Integer.parseInt(familletxt.getText());
		   Double newmin =Double.parseDouble(mintxt.getText());
		   Double newmax =Double.parseDouble(maxtxt.getText());
		   Article fam=new Article(newcode,newmax,newmin,newdesignation,newfamille);
		   gm.UpdateArticle(fam,id);
		   Parent tableViewParent = FXMLLoader.load(getClass().getResource("interfacesArticle.fxml"));
	       Scene tableViewScene = new Scene(tableViewParent);
	       
	       //This line gets the Stage information
	       Stage window = (Stage)myMenuBar.getScene().getWindow();
	       
	       window.setScene(tableViewScene);
	       window.show();

	   }
	  


}
