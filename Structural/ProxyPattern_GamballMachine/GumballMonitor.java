package ProxyPattern_GamballMachine;


public class GumballMonitor {
	GumballMachine machine;
 
	// 此監視器建構子傳入糖果機，記錄在實體變數中
	public GumballMonitor(GumballMachine machine) {
		this.machine = machine;
	}
 
	// 列印報表
	public void report() {
		System.out.println("Gumball Machine: " + machine.getLocation());
		System.out.println("Current inventory: " + machine.getCount() + " gumballs");
		System.out.println("Current state: " + machine.getState());
	}
}
