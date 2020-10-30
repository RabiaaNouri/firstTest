package com.project.models;

import javafx.scene.control.Button;

public class Mesure {
	private int id;
	private String code ;
	private Float valeur;
    private int id_palette;
    private int id_article;
    
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public int getId_palette() {
		return id_palette;
	}
	public void setId_palette(int id_palette) {
		this.id_palette = id_palette;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	public Float getValeur() {
		return valeur;
	}
	public void setValeur(Float valeur) {
		this.valeur = valeur;
	}
	
	
	public Mesure(int id, String code, Float valeur, int id_palette) {
		super();
		this.id = id;
		this.code = code;
		this.valeur = valeur;
		this.id_palette = id_palette;
	}
	

	
	public Mesure(int id, String code, Float valeur, int id_palette, int id_article) {
		super();
		this.id = id;
		this.code = code;
		this.valeur = valeur;
		this.id_palette = id_palette;
		this.id_article = id_article;
	}
	public Mesure(String code, Float valeur, int id_palette) {
		super();
		this.code = code;
		this.valeur = valeur;
		this.id_palette = id_palette;
	}
	@Override
	public String toString() {
		return "Mesure [id=" + id + ", code=" + code + ", valeur=" + valeur + ", id_palette=" + id_palette
				+ ", id_article=" + id_article + "]";
	}
	
}

