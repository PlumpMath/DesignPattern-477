package AdapterPatternLens;

public class eMountLens {
	private String aperture;
	private String focalDis;
	
	public void setAperture() {
		aperture = "F4";
	}
	
	public void setFocalDis() {
		focalDis = "28mm";
	}
	
	public String getAperture() {
		return aperture;
	}
	
	public String getFocalDis() {
		return focalDis;
	}
}
