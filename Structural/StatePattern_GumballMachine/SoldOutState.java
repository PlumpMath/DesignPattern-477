package StatePattern_GumballMachine;

// 實踐State介面
public class SoldOutState implements State {
	// 糖果機實體變數
	GumballMachine gumballMachine;
	
	// 從建構子得到糖果機參考，記錄到糖果機實體變數
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		// 糖果售罄，拒絕收錢
		System.out.println("You can't insert a quarter, the machine is sold out");
	}

	@Override
	public void ejectQuarter() {
		// 糖果售罄不可能接受25分錢，也不會退錢
    	System.out.println("You can't eject, you haven't inserted a quarter yet");
	}

	@Override
	public void turnCrank() {
		// 無法給糖果，因為沒有糖果
		System.out.println("You turned, but there are no gumballs");
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}
	
	public String toString() {
		return "sold out";
	}
}
