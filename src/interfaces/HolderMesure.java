package interfaces;


import com.project.models.Mesure;

public final class HolderMesure {

	private Mesure mesure;
	  private final static HolderMesure INSTANCE = new HolderMesure();
	  
	  
	  private HolderMesure() {}
	  
	  public static HolderMesure getInstance() {
	    return INSTANCE;
	  }
	  
	

	public Mesure getMesure() {
		return mesure;
	}

	public void setMesure(Mesure mesure) {
		this.mesure = mesure;
	}
	  

}
