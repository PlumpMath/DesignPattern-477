package CommandPatternRemoteLoader;

public class StereoOnWithCDCommand implements Command {
	Stereo stereo;
 
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
 
	public void execute() {
		// 1. turn on  2. play cd  3. set volume 
		stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
	}
}
