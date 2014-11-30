package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
// 實踐遠端介面
// 要成為遠端服務物件，須擴充UnicastRemoteObject將遠端功能繼承過來
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	// 使用UnicastRemoteObject建構式必須丟出RemoteException，所以本類別建構式也跟著丟RemoteException
	protected MyRemoteImpl() throws RemoteException {
	}

	public String sayHello() throws RemoteException {
		return "Server says, 'Hey'";
	}
	
	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			// RMI註冊此服務，Bind服務物件時，RMI會把服務物件轉成Stub再放到registry中
			// 使用 Naming 指定 binding URL 時，不能有white space
			Naming.bind("RemoteHello", service);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
