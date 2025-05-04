package rmi;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public interface PrintI extends Remote {
	public long factorial(int number) throws RemoteException;
	
}
