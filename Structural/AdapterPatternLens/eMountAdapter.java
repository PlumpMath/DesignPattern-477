package AdapterPatternLens;

public class eMountAdapter extends eMountLens {
	aMountLens aLens = new aMountLens();
	
	public eMountAdapter(aMountLens aLens) {
		this.aLens = aLens;
	}
	
	public void setAperture() {
		aLens.setAperture();
	}
	
	public void setFocalDis() {
		aLens.setFocalDis();
	}
	
	public String getAperture() {
		return aLens.getAperture();
	}
	
	public String getFocalDis() {
		return aLens.getFocalDis();
	}
}
