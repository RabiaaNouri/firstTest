package interfaces;

import com.project.models.Palette;

public class HolderPalette {
	
	private Palette palette;
	
	private final static HolderPalette INSTANCE = new HolderPalette();

	private HolderPalette() {
	}

	public static HolderPalette getInstance() {
		return INSTANCE;
	}

	public Palette getPalette() {
		return palette;
	}

	public void setPalette(Palette palette ) {
		this.palette = palette;
	}


}
