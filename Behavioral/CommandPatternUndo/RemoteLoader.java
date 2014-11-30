package CommandPatternUndo;

public class RemoteLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 建立遙控器物件(Invoker)
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		
		// 建立所有裝置(Receiver)
		Light livingRoomLight = new Light("Living Room");
		
		// 建立所有電燈的命令物件(Command)
		LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);
		
		 // 將命令載入遙控器插槽中(Invoker setCommand)
		remoteControl.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
		
		// 透過toString()印出每個遙控器的插槽與方法	
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		// 執行undo恢復上一動
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		System.out.println("=================================================");
		
		// 建立所有裝置(Receiver)
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		// 建立所有吊扇的命令物件(Command)
		CeilingFanMediumCommand ceilingFanMedium = 
				new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = 
				new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = 
				new CeilingFanOffCommand(ceilingFan);
  
		remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
		remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);
   
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
  
		remoteControl.onButtonWasPushed(1);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
	}

}
