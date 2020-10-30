package com.project.run;

import com.project.dao.GestionArticle;
import com.project.dao.GestionFamille;
import com.project.dao.GestionMesure;
import com.project.dao.GestionPalette;
import com.project.models.Article;
import com.project.models.Famille;
import com.project.models.Mesure;
import com.project.models.Palette;

public class Test {
	public static void main(String[] args) {
	GestionArticle GA= new GestionArticle();
	String ar=GA.getArticleByCode("50");
	System.out.println(ar);
		}

}
