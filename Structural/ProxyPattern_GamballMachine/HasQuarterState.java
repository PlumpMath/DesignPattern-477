package ProxyPattern_GamballMachine;

import java.util.Random;

// 實踐State介面
public class HasQuarterState implements State {
	// 加入亂數產生器，產生10%贏的機率
	Random randomWinner = new Random(System.currentTimeMillis());
	
	// 糖果機實體變數
	GumballMachine gumballMachine;
	
	// 從建構子得到糖果機參考，記錄到糖果機實體變數
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		// 已投錢不需再投
		System.out.println("You can't insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		// 若有投入25分錢，則退回並把狀態改回沒有25分錢
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		// 可以拿到糖果，並將狀態轉為售出糖果
		System.out.println("You turned...");
		// 決定是否為Winner
		int winner = randomWinner.nextInt(10);
		// 若贏惹且有足夠兩顆糖果，才進入贏家模式
		if ((winner == 0) && (gumballMachine.getCount() > 2)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			// 否則跟平常一樣
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}

	public String toString() {
		return "waiting for turn of crank";
	}
}
