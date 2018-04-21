package ws;

import java.rmi.RemoteException;

public class AppSaluto {

	public static void main(String[] args) throws RemoteException {
		
		WsSalutoProxy wsSaluto=new WsSalutoProxy();
		System.out.println(wsSaluto.saluto(3));
		
	}

}