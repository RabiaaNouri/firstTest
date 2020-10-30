package interfaces;

import com.project.models.Article;

public final class HolderArticle {

	private Article article;
	private final static HolderArticle INSTANCE = new HolderArticle();

	private HolderArticle() {
	}

	public static HolderArticle getInstance() {
		return INSTANCE;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
