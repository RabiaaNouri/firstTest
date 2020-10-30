package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.db.DataBaseConnection;
import com.project.models.Famille;

public class GestionFamille  extends DataBaseConnection {
	Connection con ;
	ResultSet rs;
	Famille fa ;
	public GestionFamille() {
		con =connexionDB();
	}
	 public void insertion(String code, String intitule ){
	        try {
	            PreparedStatement stmt= con.prepareStatement("insert into Famille  (code,intitule) values(?,?)");
	            stmt.setString(1,code);
	            stmt.setString(2, intitule);
	         
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	        	System.out.println(ex);
	        } 
	 }
	 
	
	 public ArrayList<Famille> GetFamilleList(){
	    	try {
	        	String sql = "SELECT * FROM Famille";
	           Statement st = con.createStatement();
	        	rs = st.executeQuery(sql);
	        	ArrayList<Famille> list_famille= new ArrayList<>();
	        	while(rs.next()) {
	        		Famille f = new  Famille (rs.getInt("id_famille"),rs.getString("code"),rs.getString ("intitule"));
	        		list_famille.add(f);
	        	}        	

	        	return list_famille;
	    	} catch ( SQLException ex) {
	    		System.out.println(ex);
	    		return null;
	    	}
	 }
	 public ArrayList<String> GetFamilleListCode(){
	    	try {
	        	String sql = "SELECT * FROM Famille";
	           Statement st = con.createStatement();
	        	rs = st.executeQuery(sql);
	        	ArrayList<String> list_famille= new ArrayList<>();
	        	while(rs.next()) {
	        		String f = rs.getString("code");
	        		list_famille.add(f);
	        	}        	

	        	return list_famille;
	    	} catch ( SQLException ex) {
	    		System.out.println(ex);
	    		return null;
	    	}
	 }
	 public void deleteFamille  (int id) {
	    	try {
	    		PreparedStatement stmt = con.prepareStatement("DELETE FROM famille WHERE id_famille = ? ");
	    		stmt.setInt(1, id);
	    		stmt.executeUpdate();
	    	} catch( SQLException ex) {
	    		System.out.println(ex);
	    	}
	    }
	 
	 public void UpdateFamille(Famille f, int id) {
	    	try {
	    		PreparedStatement stmt = con.prepareStatement("UPDATE famille  SET  code = ? , intitule= ? WHERE  id_famille=?" );
	    		stmt.setString(1, f.getCode());
	    		stmt.setString(2, f.getIntitule());
	    		stmt.setInt(3,id);
	    		
	    		stmt.executeUpdate();
	    	} catch(SQLException ex) {
	    		ex.printStackTrace();
	    	}
	    }
	 public Famille getFamilleById(int  id){
	        try { 
	        	PreparedStatement      stmt = con.prepareStatement("SELECT * FROM Famille WHERE id_famille = ? ");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();
	            while(rs.next()) {
	             fa = new Famille(rs.getInt("id_famille"),rs.getString("code"),rs.getString("intitule"));
	            }
	            return  fa ;
	        } catch (SQLException ex) {
	            return null;
	        }
	    }
	  
	 public String getFamilleBycode(String  code){
		 String f = "";
	        try { 
	        	
	        	PreparedStatement      stmt = con.prepareStatement("SELECT * FROM Famille WHERE code LIKE ? ");
	            stmt.setString(1, code);
	            rs = stmt.executeQuery();
	            while(rs.next()) {
	             f =rs.getInt("id_famille")+"";
	            }
	            return  f ;
	        } catch (SQLException ex) {
	            return null;
	        }
	    }
	  
	

}

