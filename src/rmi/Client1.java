package rmi;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.Scanner;

public class Client1 {
	
	public static void main(String[] args) {

		int input, num;
		Scanner sc = new Scanner(System.in);

		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 5000);
			PrintI stubObj = (PrintI) reg.lookup("factorialService");
			System.out.println("Do you want to find factorial? If yes, type 1, if no, type 0 and enter!");
			input = sc.nextInt();
			while(input == 1) {
				System.out.println("Enter the number of which you want the factorial of: ");
				num = sc.nextInt();
				System.out.println("Factorial of "+num+" is "+stubObj.factorial(num));
				System.out.println("Do you want to find factorial again? If yes, type 1, if no, type any other number and enter!");
				input = sc.nextInt();
			}
			System.out.println("Program Stopped :(");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
