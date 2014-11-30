package StatePattern_GumballMachine;

// 實踐State介面
public class SoldState implements State {
	// 糖果機實體變數
	GumballMachine gumballMachine;
	
	// 從建構子得到糖果機參考，記錄到糖果機實體變數
	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		// 顧客剛買糖果，稍等一下讓狀態回復到沒有25分錢狀態
    	System.out.println("Please wait, we're already giving you a gumball");
	}

	@Override
	public void ejectQuarter() {
		// 若已轉動曲柄拿了糖果，當然不能退$$
		System.out.println("Sorry, you already turned the crank");
	}

	@Override
	public void turnCrank() {
		// 轉兩次也沒用
		System.out.println("Turning twice doesn't get you another gumball!");
	}

	@Override
	public void dispense() {
		// 在售出糖果狀態，可以發送糖果
		gumballMachine.releaseBall();
		
		if (gumballMachine.getCount() > 0) {
			// 回到沒有$25狀態
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			// 若是最後一顆糖果，將狀態設定為糖果售罄
			System.out.println("Oops, out of gumballs!");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

	public String toString() {
		return "dispensing a gumball";
	}
}
