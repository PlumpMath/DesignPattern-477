package ProxyPattern_GamballMachine;

// 實踐State介面
public class NoQuarterState implements State {
	// 糖果機實體變數
	GumballMachine gumballMachine;
	
	// 從建構子得到糖果機參考，記錄到糖果機實體變數
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		// 再沒有25分錢狀態下，將狀態轉成有25分錢
		System.out.println("You inserted a quarter");
		gumballMachine.setState(gumballMachine.hasQuarterState);
	}

	@Override
	public void ejectQuarter() {
		// 沒有投入$$當然不給你退
		System.out.println("You haven't inserted a quarter");
	}

	@Override
	public void turnCrank() {
		// 須先投入$25
		System.out.println("You turned but there's no quarter");
	}

	@Override
	public void dispense() {
		System.out.println("You need to pay first");
	}
	
	public String toString() {
		return "waiting for quarter";
	}
}
