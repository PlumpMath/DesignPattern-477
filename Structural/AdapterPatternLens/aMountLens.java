package AdapterPatternLens;

public class aMountLens {
	private String aperture;
	private String focalDis;
	
	public void setAperture() {
		aperture = "F3";
	}
	
	public void setFocalDis() {
		focalDis = "24mm";
	}
	
	public String getAperture() {
		return aperture;
	}
	
	public String getFocalDis() {
		return focalDis;
	}
}
