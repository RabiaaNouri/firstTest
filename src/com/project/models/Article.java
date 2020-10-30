package com.project.models;

public class Article {
	private int  id;
	private  String code;
	private Double poids_max;
	private Double poids_min;
	private String designation;
	private int id_famille;
	
	public int getId_famille() {
		return id_famille;
	}
	public void setId_famille(int id_famille) {
		this.id_famille = id_famille;
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
	public Double getPoids_max() {
		return poids_max;
	}
	public void setDouble_max(Double poids_max) {
		this.poids_max = poids_max;
	}
	public Double getPoid_min() {
		return poids_min;
	}
	public void setPoid_min(Double poid_min) {
		this.poids_min = poid_min;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	public Article(String code, Double poids_max, Double poids_min, String designation) {
		super();
		this.code = code;
		this.poids_max = poids_max;
		this.poids_min = poids_min;
		this.designation = designation;
	}
	
	public Article(int id, String code, Double poids_max, Double poids_min, String designation) {
		super();
		this.id = id;
		this.code = code;
		this.poids_max = poids_max;
		this.poids_min = poids_min;
		this.designation = designation;
	}
	public Article(int id, String code, Double poids_max, Double poids_min, String designation, int id_famille) {
		super();
		this.id = id;
		this.code = code;
		this.poids_max = poids_max;
		this.poids_min = poids_min;
		this.designation = designation;
		this.id_famille = id_famille;
	}
	public Article( String code, Double poids_max, Double poids_min, String designation, int id_famille) {
		super();
		
		this.code = code;
		this.poids_max = poids_max;
		this.poids_min = poids_min;
		this.designation = designation;
		this.id_famille = id_famille;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", code=" + code + ", poids_max=" + poids_max + ", poids_min=" + poids_min
				+ ", designation=" + designation + "]";
	}
	
}