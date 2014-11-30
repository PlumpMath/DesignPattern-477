package ProxyPattern_GamballMachine;

// 所有狀態必須繼承此介面
// 將狀態封裝成類別，類別都必須實踐此介面
// 將變動的部分封裝，針對介面寫程式
public interface State {
	void insertQuarter();
	
	void ejectQuarter();
	
	void turnCrank();
	
	void dispense();
}
