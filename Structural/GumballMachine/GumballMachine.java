package GumballMachine;

public class GumballMachine {
	// 定義糖果機器的四種狀態
	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;
	
	// 實體變數記錄目前狀態，一開始是糖果售罄狀態
	int state = SOLD_OUT;
	// 另一實體變數，追蹤糖果機內的糖果數目
	int count = 0;
	
	// 建構式將糖果數目當參數
	public GumballMachine(int count) {
		this.count = count;
		// 若庫存不為0，機器進入沒有25分錢狀態(等人投入)，否則維持在糖果售罄狀態
		if (count > 0) {
			state = NO_QUARTER;
		}
	}
	
	// 投入25分錢動作
	public void insertQuarter() {
		if (state == HAS_QUARTER) {
			// 已投錢不需再投
			System.out.println("You can't insert another quarter");
		} else if (state == NO_QUARTER) {
			// 再沒有25分錢狀態下，將狀態轉成有25分錢
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter");
		} else if (state == SOLD_OUT) {
			// 糖果售罄，拒絕收錢
			System.out.println("You can't insert a quarter, the machine is sold out");
		} else if (state == SOLD) {
			// 顧客剛買糖果，稍等一下讓狀態回復到沒有25分錢狀態
        	System.out.println("Please wait, we're already giving you a gumball");
		}
	}

	// 退出25分錢
	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			// 若有投入25分錢，則退回並把狀態改回沒有25分錢
			System.out.println("Quarter returned");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {
			// 沒有投入$$當然不給你退
			System.out.println("You haven't inserted a quarter");
		} else if (state == SOLD) {
			// 若已轉動曲柄拿了糖果，當然不能退$$
			System.out.println("Sorry, you already turned the crank");
		} else if (state == SOLD_OUT) {
			// 糖果售罄不可能接受25分錢，也不會退錢
        	System.out.println("You can't eject, you haven't inserted a quarter yet");
		}
	}
	
	// 轉動曲柄
	public void turnCrank() {
		if (state == SOLD) {
			// 轉兩次也沒用
			System.out.println("Turning twice doesn't get you another gumball!");
		} else if (state == NO_QUARTER) {
			// 須先投入$25
			System.out.println("You turned but there's no quarter");
		} else if (state == SOLD_OUT) {
			// 無法給糖果，因為沒有糖果
			System.out.println("You turned, but there are no gumballs");
		} else if (state == HAS_QUARTER) {
			// 可以拿到糖果，並將狀態轉為售出糖果
			System.out.println("You turned...");
			state = SOLD;
			// 呼叫機器分送糖果的方法
			dispense();
		}
	}
 
	// 發送糖果
	public void dispense() {
		if (state == SOLD) {
			// 在售出糖果狀態，可以發送糖果
			System.out.println("A gumball comes rolling out the slot");
			// 糖果庫存-1
			count = count - 1;
			if (count == 0) {
				// 若是最後一顆糖果，將狀態設定為糖果售罄
				System.out.println("Oops, out of gumballs!");
				state = SOLD_OUT;
			} else {
				// 否則回到沒有$25狀態
				state = NO_QUARTER;
			}
		} else if (state == NO_QUARTER) {
			System.out.println("You need to pay first");
		} else if (state == SOLD_OUT) {
			System.out.println("No gumball dispensed");
		} else if (state == HAS_QUARTER) {
			System.out.println("No gumball dispensed");
		}
	}
 
	// 填裝糖果
	public void refill(int numGumBalls) {
		// 設定填裝庫存，並設為沒有$25狀態
		this.count = numGumBalls;
		state = NO_QUARTER;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is ");
		if (state == SOLD_OUT) {
			result.append("sold out");
		} else if (state == NO_QUARTER) {
			result.append("waiting for quarter");
		} else if (state == HAS_QUARTER) {
			result.append("waiting for turn of crank");
		} else if (state == SOLD) {
			result.append("delivering a gumball");
		}
		result.append("\n");
		return result.toString();
	}
}
