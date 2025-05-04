package rmi;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public interface Palindrome extends Remote{

	public boolean isPalindrome(String str) throws RemoteException;
}
