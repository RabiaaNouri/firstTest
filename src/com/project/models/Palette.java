package com.project.models;

public class Palette {
private int id_palette;
private String code ;
private Float poids ;
private  int id_article ; 
public int getId() {
	return id_palette;
}
public void setId(int id_palette) {
	this.id_palette = id_palette;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public Float getPoids() {
	return poids;
}
public void setPoids(Float poids) {
	this.poids = poids;
}


public int getId_palette() {
	return id_palette;
}
public void setId_palette(int id_palette) {
	this.id_palette = id_palette;
}
public int getId_article() {
	return id_article;
}
public void setId_article(int id_article) {
	this.id_article = id_article;
}
public Palette(String code, Float poids, int id_article) {
	super();
	this.code = code;
	this.poids = poids;
	this.id_article = id_article;
}

public Palette(int id_palette, String code, Float poids, int id_article) {
	super();
	this.id_palette = id_palette;
	this.code = code;
	this.poids = poids;
	this.id_article = id_article;
}
@Override
public String toString() {
	return "Palette [id_palette=" + id_palette + ", code=" + code + ", poids=" + poids + ", id_article=" + id_article
			+ "]";
}
}