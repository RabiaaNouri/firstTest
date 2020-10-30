package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.db.DataBaseConnection;
import com.project.models.Mesure;

public class GestionMesure extends DataBaseConnection{
 Connection con;
ResultSet rs,rs2;

Mesure m;

public GestionMesure() {
	con=connexionDB();
}



public void insertion(String code, Float valeur,int id_palette){
    try {
        PreparedStatement stmt= con.prepareStatement("insert into Mesure (code,valeur,id_palette) values(?,?,?)");
       
        stmt.setString(1,code);
        stmt.setString(2,valeur.toString());
        stmt.setInt(3, id_palette);
        stmt.executeUpdate();
    } catch (SQLException ex) {
    	ex.printStackTrace();
    } 
}



public ArrayList< Mesure> GetMesureList(){
	try {
    	String sql = "SELECT * FROM Mesure";
       Statement st = con.createStatement();
    	rs = st.executeQuery(sql);
    	ArrayList<Mesure> list_Mesure = new ArrayList<>();
    	while(rs.next()) {
    		m = new  Mesure (rs.getInt("id_mesure"),rs.getString("code"),rs.getFloat("valeur"),rs.getInt("id_palette"));
    		list_Mesure.add(m);
    	}        	

    	return list_Mesure;
	} catch ( SQLException ex) {
		System.out.println(ex);
		return null;
	}
}
public ArrayList< Mesure> GetMesureList_article(){
	try {
    	String sql = "SELECT * FROM Mesure";
       Statement st = con.createStatement();
    	rs = st.executeQuery(sql);
    	ArrayList<Mesure> list_Mesure = new ArrayList<>();
    	while(rs.next()) {
    		int id_pal=rs.getInt("id_palette");
    		
    		String sql2 = "SELECT * FROM palette ";
    		
    	       Statement st2 = con.createStatement();
    	       
    	    	rs2 = st2.executeQuery(sql2);
    	    	rs2.next();
    		m = new  Mesure (rs.getInt("id_mesure"),rs.getString("code"),rs.getFloat("valeur"),id_pal,rs2.getInt("id_article"));
    		list_Mesure.add(m);
    	}        	

    	return list_Mesure;
	} catch ( SQLException ex) {
		System.out.println(ex);
		return null;
	}
}


public void deleteMesure(int id) {
   	try {
   		PreparedStatement stmt = con.prepareStatement("DELETE FROM Mesure WHERE id_mesure= ? ");
   		stmt.setInt(1, id);
   		stmt.executeUpdate();
   	} catch( SQLException ex) {
   		System.out.println(ex);
   	}
   }



public void UpdateMesure(Mesure m, int id) {
	try {
		PreparedStatement stmt = con.prepareStatement("UPDATE Mesure SET code = ? ,valeur= ? ,id_palette= ? where id_mesure=?");
		
		stmt.setString(1, m.getCode());
		stmt.setFloat(2, m.getValeur());
		stmt.setInt(3, m.getId_palette());
		stmt.setInt(4, id);
		stmt.executeUpdate();
	} catch(SQLException ex) {
		System.out.println(ex);
	}
}


public Mesure getMesureById(int  id){
    try { 
    	PreparedStatement      stmt = con.prepareStatement("SELECT * FROM Mesure WHERE id_mesure = ? ");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        while(rs.next()) {
         m = new Mesure(rs.getInt("id"),rs.getString("code"),rs.getFloat("valeur"),rs.getInt("id_palette"));
        }
        return  m ;
    } catch (SQLException ex) {
        return null;
    }
}
}
