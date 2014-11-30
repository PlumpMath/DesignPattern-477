package AdapterPatternLens;

public class shotTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		eMountLens eLens = new eMountLens();
		aMountLens aLens = new aMountLens();
		eMountAdapter eAdapter = new eMountAdapter(aLens);
		
		alpha7 a7 = new alpha7();
		
		a7.setLens(eLens);
		a7.tuneAperture();
		a7.tuneFocalDis();
		a7.shot();
		
		//a7.setLens(aLens);   不能接aMount鏡
		a7.setLens(eAdapter);
		a7.tuneAperture();
		a7.tuneFocalDis();
		a7.shot();
	}

}
