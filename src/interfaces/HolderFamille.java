package interfaces;

import com.project.models.Famille;
import com.project.models.Mesure;

public final  class HolderFamille {
	private Famille famille;
	private Mesure mesure;
	  private final static HolderFamille INSTANCE = new HolderFamille();
	  
	  
	  private HolderFamille() {}
	  
	  public static HolderFamille getInstance() {
	    return INSTANCE;
	  }
	  
	  public void setFamille(Famille f) {
	    this.famille = f;
	  }
	  
	  public Famille getFamille() {
	    return this.famille;
	  }

	public Mesure getMesure() {
		return mesure;
	}

	public void setMesure(Mesure mesure) {
		this.mesure = mesure;
	}
	  

}
