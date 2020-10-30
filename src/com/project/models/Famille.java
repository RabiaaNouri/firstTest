package com.project.models;

import javafx.scene.control.Button;

public class Famille {
	private int id;
	private String code ;
	private String intitule;
	
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
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	/*public Button getBtn_update() {
		return btn_update;
	}
	public void setBtn_update(Button btn_update) {
		this.btn_update = btn_update;
	}*/
	public Famille(int id, String code, String intitule) {
		super();
		this.id = id;
		this.code = code;
		this.intitule = intitule;
	}
	
	public Famille(String code, String intitule) {
		super();
		this.code = code;
		this.intitule = intitule;
	}
	
	
	@Override
	public String toString() {
		return "Famille [id=" + id + ", code=" + code + ", intitule=" + intitule + "]";
	}
	

}
