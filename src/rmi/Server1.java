package rmi;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Server1 {

	public static void main(String[] args) {

		try {
			PrintC obj = new PrintC();
			Registry reg = LocateRegistry.createRegistry(5000);
			reg.rebind("factorialService", obj);
			System.out.println("Server started successfully for factorial.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
