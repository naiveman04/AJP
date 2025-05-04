package rmi;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class PalindromeImp extends UnicastRemoteObject implements Palindrome {

	public PalindromeImp() throws RemoteException {
		
		super();
	}

	@Override
	public boolean isPalindrome(String str) throws RemoteException {

		String modifiedString = String.valueOf(str).toLowerCase().trim();
		
		int i = 0, j = modifiedString.length() - 1;
		while(j > i) {
			if(modifiedString.charAt(i) != modifiedString.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
