package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

// 製作遠端介面，此介面當作遠端介面使用
public interface MyRemote extends Remote {
	// 選告的所有方法都要丟出RemoteException
	// 確定參數及回傳值必須是可序列化型態
	// 若是自己定義型別，必須實踐Serializable
	public String sayHello() throws RemoteException;
}
