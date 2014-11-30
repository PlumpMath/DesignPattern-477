package CommandPatternRemoteLoader;

public class StereoOffCommand implements Command {
	// Receiver物件
	Stereo stereo;

	// 透過建構子傳入Receiver物件，儲存到實體變數
	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	// 透過Composition呼叫Receiver物件方法
	@Override
	public void execute() {
		stereo.off();
	}
	
}
