package CommandPatternRemoteLoader;

public class RemoteLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 建立遙控器物件(Invoker)
		RemoteControl remoteControl = new RemoteControl();
		
		// 建立所有裝置(Receiver)
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("");
		Stereo stereo = new Stereo("Living Room");
		
		// 建立所有電燈的命令物件(Command)
		LivingRoomLightOnCommand livingRoomLightOnCommand 
			= new LivingRoomLightOnCommand(livingRoomLight);
		LivingRoomLightOffCommand livingRoomLightOffCommand 
			= new LivingRoomLightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);
		
		// 建立天花板電扇開關命令物件
		CeilingFanOnCommand ceilingFanOnCommand 
			= new CeilingFanOnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOffCommand 
		= new CeilingFanOffCommand(ceilingFan);
		
		// 建立車庫門上與下命令物件
		GarageDoorUpCommand garageDoorUpCommand 
			= new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDownCommand 
		= new GarageDoorDownCommand(garageDoor);
			
		// 建立音響的開與關命令物件
		StereoOnWithCDCommand stereoOnWithCDCommand
			= new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOffCommand
		= new StereoOffCommand(stereo);
		
		 // 將命令載入遙控器插槽中(Invoker setCommand)
		remoteControl.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
		remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand);
		remoteControl.setCommand(2, ceilingFanOnCommand, ceilingFanOffCommand);
		remoteControl.setCommand(3, stereoOnWithCDCommand, stereoOffCommand);
		
		// 透過toString()印出每個遙控器的插槽與方法
		System.out.println(remoteControl);
		
		// 
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
	}

}
