package AdapterPatternLens;

public class alpha7 {
	// eMount reference
	private eMountLens eLens;
	
	public alpha7() {
		
	}
	
	public alpha7(eMountLens eLens) {
		this.eLens = eLens;
	}
	
	public void setLens(eMountLens eLens) {
		this.eLens = eLens;
	}
	
	public void tuneAperture() {
		eLens.setAperture();
	}
	
	public void tuneFocalDis () {
		eLens.setFocalDis();
	}
	
	public void shot() {
		System.out.println(
			"shot a picture with Aperture : " + eLens.getAperture() + " FocalDis： " + eLens.getFocalDis()
		);
	}
}
