package StatePattern_GumballMachine;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		// 一開始裝5顆糖
		GumballMachine gumballMachine = new GumballMachine(5);
		// 印出機器初始狀態
		System.out.println(gumballMachine);

		// 投入$25
		gumballMachine.insertQuarter();
		// 轉動曲柄
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
		
		gumballMachine.refill(5);
		System.out.println(gumballMachine);
	}
}
