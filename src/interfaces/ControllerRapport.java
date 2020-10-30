package interfaces;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.project.dao.GestionArticle;
import com.project.dao.GestionPalette;
import com.project.models.Article;
import com.project.models.Palette;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 public class ControllerRapport  implements Initializable {
	
	@FXML
	private LineChart<?,?>  charts;
	@FXML 
	MenuBar myMenuBar;
	@FXML
	private NumberAxis y;
	@FXML 
	private CategoryAxis x;
	
	
	@FXML
	ChoiceBox<String> articletxt ;
	String a="";
	String[] arrOfStr;
    XYChart.Series series = new XYChart.Series();
    XYChart.Series series3 = new XYChart.Series();
    XYChart.Series series2 = new XYChart.Series();
    ArrayList<Palette> p;
GestionArticle GA = new GestionArticle();
GestionPalette GP = new GestionPalette();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		charts.setAnimated(false);
		  ObservableList<String> articles = FXCollections.observableArrayList(GA.GetArticletListCode());
		  articletxt.setItems(articles);
		  articletxt.getSelectionModel().select(0);
        charts.setTitle("Rapport article (palette % mesure) % poids min/max ");
        a = GA.getArticleByCode(""+articles.get(0));
        arrOfStr = a.split("#", 2);
        p=GP.GetPaletteListArticle(""+articles.get(0));
       System.out.println(p);
     for(int i=0;i<p.size();i++) {
    	 series.getData().add(new XYChart.Data(p.get(i).getCode(),Double.parseDouble(arrOfStr[1])));
    	 series3.getData().add(new XYChart.Data(p.get(i).getCode(),Double.parseDouble(arrOfStr[0])));
    	 series2.getData().add(new XYChart.Data(p.get(i).getCode(),p.get(i).getPoids()));
     }
    
      charts.getData().addAll(series,series2,series3);
      articletxt.getSelectionModel().selectedIndexProperty().addListener(
    	         (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
    	        	 
    	        	 series.getData().clear();
    	        	 series3.getData().clear();
    	        	 series2.getData().clear();
    	        	 charts.getData().remove(series);
    	        	 charts.getData().remove(series2);
    	        	 charts.getData().remove(series3);
    	            a = GA.getArticleByCode(""+articles.get(new_val.intValue()));
    	             arrOfStr = a.split("#", 2);
    	              p=GP.GetPaletteListArticle(""+articles.get(new_val.intValue()));
    	            
    	           for(int i=0;i<p.size();i++) {
    	          	 series.getData().add(new XYChart.Data(p.get(i).getCode(),Double.parseDouble(arrOfStr[1])));
    	          	 series3.getData().add(new XYChart.Data(p.get(i).getCode(),Double.parseDouble(arrOfStr[0])));
    	          	 series2.getData().add(new XYChart.Data(p.get(i).getCode(),p.get(i).getPoids()));
    	           }
    	            charts.getData().addAll(series,series2,series3);
    	      });
	}
	public void familleclick(ActionEvent event) throws IOException {
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

}
