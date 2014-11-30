package StatePattern_GumballMachine;

public class GumballMachine {
	// 定義糖果機器的四種狀態
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	// 新加入贏家模式
	State winnerState;

	
	// 實體變數記錄目前狀態，一開始是糖果售罄狀態
	State state = soldOutState;
	// 另一實體變數，追蹤糖果機內的糖果數目
	int count = 0;
	
	// 建構式將糖果數目當參數
	public GumballMachine(int count) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		// 建構子將winnerState初始化
		winnerState = new WinnerState(this);

		
		this.count = count;
		// 若庫存不為0，機器進入沒有25分錢狀態(等人投入)，否則維持在糖果售罄狀態
		if (count > 0) {
			state = noQuarterState;
		}
	}
	
	// 設定狀態
	void setState(State state) {
		this.state = state;
	}
	
    public State getState() {
        return state;
    }
    
    // 取得售罄狀態
    public State getSoldOutState() {
        return soldOutState;
    }

    // 取得沒有$25狀態
    public State getNoQuarterState() {
        return noQuarterState;
    }

    // 取得有$25狀態
    public State getHasQuarterState() {
        return hasQuarterState;
    }

    // 取得已售狀態
    public State getSoldState() {
        return soldState;
    }
    
    // 取得贏家狀態
    public State getWinnerState() {
        return winnerState;
    } 
	
    // 發送糖果
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			// 糖果庫存-1
			count = count - 1;
		}
	}
    
	int getCount() {
		return count;
	}
	
	// 投入25分錢動作
	public void insertQuarter() {
		state.insertQuarter();
	}

	// 退出25分錢
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	// 轉動曲柄
	public void turnCrank() {
		state.turnCrank();
		// 發送糖果
		state.dispense();
	}

 
	// 填裝糖果
	public void refill(int numGumBalls) {
		System.out.println("refill GumballMachine, add GumBall num : " + numGumBalls);
		// 設定填裝庫存，並設為沒有$25狀態
		this.count = numGumBalls;
		state = noQuarterState;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is " + state);
		result.append("\n");
		return result.toString();
	}
}
