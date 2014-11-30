package FacadePattern;

// FacadePattern提供簡化介面，並由子系統來實踐
// 但是並沒有封裝子系統
public class HomeTheaterFacade {
	// 創造使用到的子系統元件變數
	Amplifier amplifier;
	CdPlayer cdPlayer;
	DvdPlayer dvdPlayer;
	PopcornPopper popcornPopper;
	Projector projector;
	Screen screen;
	TheaterLights theaterLights;
	Tuner tuner;
	
	// 透過建構子醬元件儲存在變數中
	public HomeTheaterFacade(Amplifier amplifier, CdPlayer cdPlayer, DvdPlayer dvdPlayer,
		PopcornPopper popcornPopper, Projector projector, Screen screen, TheaterLights theaterLights,
		Tuner tuner) {
		this.amplifier = amplifier;
		this.cdPlayer = cdPlayer;
		this.dvdPlayer = dvdPlayer;
		this.popcornPopper = popcornPopper;
		this.projector = projector;
		this.screen = screen;
		this.theaterLights = theaterLights;
		this.tuner = tuner;
	}
	
	// 提供簡化介面，並由子系統元件實踐(Delegation)
	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie...");
		popcornPopper.on();
		popcornPopper.pop();
		theaterLights.dim(10);
		screen.down();
		projector.on();
		projector.wideScreenMode();
		amplifier.on();
		amplifier.setDvd(dvdPlayer);
		amplifier.setSurroundSound();
		amplifier.setVolume(5);
		dvdPlayer.on();
		dvdPlayer.play(movie);
	}
 
	public void endMovie() {
		System.out.println("Shutting movie theater down...");
		popcornPopper.off();
		theaterLights.on();
		screen.up();
		projector.off();
		amplifier.off();
		dvdPlayer.stop();
		dvdPlayer.eject();
		dvdPlayer.off();
	}

	public void listenToCd(String cdTitle) {
		System.out.println("Get ready for an audiopile experence...");
		theaterLights.on();
		amplifier.on();
		amplifier.setVolume(5);
		amplifier.setCd(cdPlayer);
		amplifier.setStereoSound();
		cdPlayer.on();
		cdPlayer.play(cdTitle);
	}

	public void endCd() {
		System.out.println("Shutting down CD...");
		amplifier.off();
		amplifier.setCd(cdPlayer);
		cdPlayer.eject();
		cdPlayer.off();
	}

	public void listenToRadio(double frequency) {
		System.out.println("Tuning in the airwaves...");
		tuner.on();
		tuner.setFrequency(frequency);
		amplifier.on();
		amplifier.setVolume(5);
		amplifier.setTuner(tuner);
	}

	public void endRadio() {
		System.out.println("Shutting down the tuner...");
		tuner.off();
		amplifier.off();
	}
}
