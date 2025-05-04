package rmi;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice;
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 5000);
			Palindrome stubObj = (Palindrome) reg.lookup("palindromeService");
			System.out.println("Do you want to find if a string is a palindrome or not? Press 1 for find out!");
			choice = sc.nextInt();
			while(choice == 1) {
				System.out.println("Enter the string you want to test for palindrome: ");
				String str = sc.next();
				boolean response = stubObj.isPalindrome(str);
				if(response == true) {
					System.out.println(str + " is a palindrome!");
				}
				else {
					System.out.println(str + " is not a palindrome :(");
				}
				System.out.println("\nDo you want to find if another string is a palindrome or not? Press 1 for find out or any other key to exit the program.");
				choice = sc.nextInt();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
}
