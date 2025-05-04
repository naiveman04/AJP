package rmi;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Server {

	public static void main(String[] args) {
		try {
			PalindromeImp obj = new PalindromeImp();
			Registry reg = LocateRegistry.createRegistry(5000);
			reg.rebind("palindromeService", obj);
			System.out.println("Server is ready to use.");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
