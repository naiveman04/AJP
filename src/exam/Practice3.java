// Design a bank transaction system using a queue (linked list).
// The program should be:
//  1. Add customers to the queue as they arrive at the bank.
//  2. Serve the customers in the fifo order.
//  3. Display the queue after every transaction. 

package exam;

import java.util.*;

class Customer {
    String name;
    int tokenNumber;
    
    Customer(String name, int tokenNumber) {
        this.name = name;
        this.tokenNumber = tokenNumber;
    }
    
    public String toString() {
        return "Token No: " + tokenNumber + ", Name: " + name;
    }
}

public class Practice3 {
    public static void main(String[] args) {
        Queue<Customer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int token = 1;
        
        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            if (choice == 1) {
                System.out.print("Enter customer name: ");
                String name = sc.next();
                Customer c = new Customer(name, token);
                queue.add(c);
                token++;
                System.out.println("Customer added.");
            }
            else if (choice == 2) {
                if (!queue.isEmpty()) {
                    System.out.println("Serving: " + queue.poll());
                } else {
                    System.out.println("No customers.");
                }
            }
            else if (choice == 3) {
                System.out.println("Queue:");
                for (Customer c : queue) {
                    System.out.println(c);
                }
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty.");
                }
            }
            else if (choice == 4) {
                System.out.println("Exiting.");
                break;
            }
            else {
                System.out.println("Invalid.");
            }
        }
    }
}
