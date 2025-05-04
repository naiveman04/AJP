// Develop a java program to simulate an online shopping cart using java collection framework.
// The program should be:
// 	1. Store the products with hash map.
//  2. Add Selected products through list in the cart.
//  3. Calculate and display the total bill of the cart.

package exam;

import java.util.*;

class Product {
    String name;
    double price;
    
    Product(String n, double p) {
        name = n;
        price = p;
    }
    
    public String toString() {
        return name + " costs Rs." + price;
    }
}

public class Practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        HashMap<Integer, Product> products = new HashMap<>();
        products.put(1, new Product("Laptop", 50000));
        products.put(2, new Product("Smartphone", 20000));
        products.put(3, new Product("Headphones", 3000));
        products.put(4, new Product("Mouse", 1000));
        products.put(5, new Product("Keyboard", 1500));
        
        ArrayList<Product> cart = new ArrayList<>();
        
        while (true) {
            System.out.println("Products:");
            for (Integer key : products.keySet()) {
                System.out.println(key + ". " + products.get(key));
            }
            System.out.println("6. Checkout");
            System.out.print("Enter number: ");
            
            int ch = sc.nextInt();
            if (ch == 6) {
                break;
            }
            if (products.containsKey(ch)) {
                cart.add(products.get(ch));
                System.out.println("Added: " + products.get(ch).name);
            } else {
                System.out.println("Wrong choice.");
            }
        }
        
        double total = 0;
        System.out.println("Your Cart:");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).name + " Rs." + cart.get(i).price);
            total += cart.get(i).price;
        }
        System.out.println("Total Rs." + total);
        sc.close();
    }
}
