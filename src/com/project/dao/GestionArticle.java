package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.db.DataBaseConnection;
import com.project.models.Article;

public class GestionArticle  extends DataBaseConnection{
	Connection con ;
	ResultSet rs;
	Article ar;
	Statement st;
	public GestionArticle() {
		con = connexionDB();
	}
	
	 public void insertion(String code, double d ,double e,String designation, int id_fam){
	        try {
	        	
	            PreparedStatement stmt= con.prepareStatement("insert into application.dbo.article  (code,poids_max,poids_min,designation,id_famille) values(?,?,?,?,?)");
	            
	            stmt.setString(1,code);
	            stmt.setDouble(2, d);
	            stmt.setDouble(3,e);
	            stmt.setString(4,designation);
	            stmt.setInt(5,id_fam);
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        } 
	    }
	
	
	 public ArrayList<Article > GetArticletList(){
	    	try {
	    		
	        	String sql = "SELECT * FROM application.dbo.article";
	            st = con.createStatement();
	        	rs = st.executeQuery(sql);
	        	ArrayList<Article> list_article = new ArrayList<Article>();
	        	while(rs.next()) {
	        		Article cl = new  Article (rs.getInt("id_article"),rs.getString("code"),rs.getDouble("poids_max"),rs.getDouble("poids_min"),rs.getString("designation"),rs.getInt("id_famille"));
	        		list_article.add(cl);
	        	}        	

	        	return list_article;
	    	} catch ( SQLException ex) {
	    		 ex.printStackTrace();
	    		return null;
	    	}
	 }
	 
	 public ArrayList<String> GetArticletListCode(){
	    	try {
	    		//System.out.println(con.toString());
	        	String sql = "SELECT * FROM application.dbo.article";
	            st = con.createStatement();
	        	rs = st.executeQuery(sql);
	        	ArrayList<String> list_article = new ArrayList<String>();
	        	while(rs.next()) {
	        		String cl = rs.getString("code");
	        		list_article.add(cl);
	        	}        	

	        	return list_article;
	    	} catch ( SQLException ex) {
	    		 ex.printStackTrace();
	    		return null;
	    	}
	 }
	 
	 public void deleteArticle(int id) {
	    	try {
	    		PreparedStatement stmt = con.prepareStatement("DELETE FROM application.dbo.article WHERE id_article = ? ");
	    		stmt.setInt(1, id);
	    		stmt.executeUpdate();
	    	} catch( SQLException ex) {
	    		System.out.println(ex);
	    	}
	    }
	   
	  public void UpdateArticle(Article a, int id) {
	    	try {
	    		PreparedStatement stmt = con.prepareStatement("UPDATE application.dbo.article  SET  code = ? , poids_max= ?, poids_min = ? ,designation=?,id_famille=? WHERE id_article = ? ");
	    		//stmt.setInt(1, a.getId());
	    		stmt.setString(1, a.getCode());
	    		stmt.setDouble(2, a.getPoids_max());
	    		stmt.setDouble(3, a.getPoid_min());
	    		stmt.setString(4, a.getDesignation());
	    		stmt.setInt(5, a.getId_famille());
	    		stmt.setInt(6,id);
	    		stmt.executeUpdate();
	    	} catch(SQLException ex) {
	    		System.out.println(ex);
	    	}
	    }
	  
	  public Article getArticleById(int  id){
	        try { 
	        	PreparedStatement      stmt = con.prepareStatement("SELECT * FROM application.dbo.article WHERE id_article = ? ");
	            stmt.setInt(1, id);
	            rs = stmt.executeQuery();
	            while(rs.next()) {
	             ar = new Article(rs.getInt("id_article"),rs.getString("code"),rs.getDouble("poids_max"),rs.getDouble("poids_min"),rs.getString("designation"));
	            }
	            return  ar ;
	        } catch (SQLException ex) {
	            return null;
	        }
	    }
	  public String getArticleByCode(String code){
	        try { 
	        	PreparedStatement      stmt = con.prepareStatement("SELECT * FROM application.dbo.article WHERE code LIKE ? ");
	            stmt.setString(1, code);
	            rs = stmt.executeQuery();
	            String min_max="";
	            while(rs.next()) {
	           //  ar = new Article(rs.getInt("id"),rs.getString("code"),rs.getDouble("poids_max"),rs.getDouble("poids_min"),rs.getString("designation"));
	         // System.out.println(ar);
	            	min_max=""+rs.getDouble("poids_max")+"#"+rs.getDouble("poids_min");
	            }
	            return  min_max ;
	        } catch (SQLException ex) {
	            return null;
	        }
	    }
	  public int getArticleIDByCode(String code){
	        try { 
	        	PreparedStatement      stmt = con.prepareStatement("SELECT * FROM application.dbo.article WHERE code LIKE ? ");
	            stmt.setString(1, code);
	            rs = stmt.executeQuery();
	            int id=0;
	            while(rs.next()) {
	           //  ar = new Article(rs.getInt("id_article"),rs.getString("code"),rs.getDouble("poids_max"),rs.getDouble("poids_min"),rs.getString("designation"));
	         // System.out.println(ar);
	            	id=rs.getInt("id_article");
	            }
	            return  id ;
	        } catch (SQLException ex) {
	            return 0;
	        }
	    }
	
	

}
