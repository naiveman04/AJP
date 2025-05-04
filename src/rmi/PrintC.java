package rmi;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class PrintC extends UnicastRemoteObject implements PrintI{
	
	public PrintC() throws RemoteException {
		super();
	}

	@Override
	public long factorial(int number) throws RemoteException {
		long fact = 1;
		for(int i = 1; i <= number; i++) {
			fact = fact*i;
		}
		return fact;
	}
}
