package CommandPatternSimpleRemote;

public class RemoteControlTest {
	public static void main(String[] args) {
		// 遙控器就是一個Invoker(調用者)，透過傳入一個Command物件來發出請求
		SimpleRemoteControl remote = new SimpleRemoteControl();
		
		// Receiver
		Light light = new Light();
		GarageDoor garageDoor = new GarageDoor();
		
		// 建立Command物件，並傳入Receiver作為execute時呼叫Receiver功能
		LightOnCommand lightOn = new LightOnCommand(light);
		GarageDoorOpenCommand garageOpen = 
		    new GarageDoorOpenCommand(garageDoor);
 
		// 透過Invoker設定Command物件
		remote.setCommand(lightOn);
		// Invoker呼叫Command execute方法，再間接呼叫Receiver方法
		remote.buttonWasPressed();
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();
    }
}
