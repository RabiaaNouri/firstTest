package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.db.DataBaseConnection;
import com.project.models.Palette;

public class GestionPalette  extends DataBaseConnection{
	Connection con ;
	ResultSet rs ;
	Palette P;
	GestionArticle GA=new GestionArticle();
	public GestionPalette() {
		con=connexionDB();
	}
	 public void insertion(String code, Float poids ,int id_article){
	        try {
	            PreparedStatement stmt= con.prepareStatement("insert into Palette  (code,poid,id_article ) values(?,?,?)");
	            stmt.setString(1,code);
	            stmt.setFloat(2, poids);
	            stmt.setInt(3,id_article);
	         
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        } 
	 }
	 public ArrayList<Palette > GetPaletteList(){
	    	try {
	        	String sql = "SELECT * FROM Palette";
	           Statement st = con.createStatement();
	        	rs = st.executeQuery(sql);
	        	ArrayList<Palette> list_palette = new ArrayList<>();
	        	while(rs.next()) {
	        		Palette p = new  Palette (rs.getInt("id_palette"),rs.getString("code"),rs.getFloat("poid"),rs.getInt("id_article"));
	        		list_palette.add(p);
	        	}        	

	        	return list_palette;
	    	} catch ( SQLException ex) {
	    		System.out.println(ex);
	    		return null;
	    	}
	 }
	 
	 
	 public ArrayList<Palette> GetPaletteListArticle(String code){
		 int id=GA.getArticleIDByCode(code);
	    	try {
	        	String sql = "SELECT * FROM Palette WHERE id_article="+id;
	        	
	           Statement st = con.createStatement();
	        	rs = st.executeQuery(sql);
	        	ArrayList<Palette> list_palette = new ArrayList<>();
	        	while(rs.next()) {
	        		Palette p = new  Palette (rs.getInt("id_palette"),rs.getString("code"),rs.getFloat("poid"),rs.getInt("id_article"));
	        		list_palette.add(p);
	        	}        	

	        	return list_palette;
	    	} catch ( SQLException ex) {
	    		System.out.println(ex);
	    		return null;
	    	}
	 }
	 
	 
	 
	 public void deletePalette(int id) {
	    	try {
	    		PreparedStatement stmt = con.prepareStatement("DELETE FROM Palette WHERE id_palette = ? ");
	    		stmt.setInt(1, id);
	    		stmt.executeUpdate();
	    	} catch( SQLException ex) {
	    		System.out.println(ex);
	    	}
	    }
	   
		  public void UpdatePalette(Palette a, int id) {
		    	try {
		    		PreparedStatement stmt = con.prepareStatement("UPDATE palette SET code = ? , poid= ? , id_article= ? where id_palette =?");
		    	
		    		stmt.setString(1, a.getCode());
		    		stmt.setFloat(2, a.getPoids());
		    		stmt.setFloat(3, a.getId_article());
		    		stmt.setInt(4, id);
		    		stmt.executeUpdate();
		    	} catch(SQLException ex) {
		    		System.out.println(ex);
		    	}
		    }
		  public Palette getPaletteById(int  id){
		        try { 
		        	PreparedStatement      stmt = con.prepareStatement("SELECT * FROM Palette WHERE id_palette = ? ");
		            stmt.setInt(1, id);
		            rs = stmt.executeQuery();
		            while(rs.next()) {
		             P = new Palette(rs.getInt("id"),rs.getString("code"),rs.getFloat("poids"),rs.getInt("id_palette"));
		            }
		            return  P ;
		        } catch (SQLException ex) {
		            return null;
		        }
		    }
		  
	   

}
