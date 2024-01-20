
package View;

import Model.Cart;
import Model.Fruit;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class View {
    
    public void print(ArrayList<Fruit> sl){
        System.out.println("List of Fruit:");
        for (Fruit s:sl) System.out.println(s);
    }
    
    public void printOder (Cart cart){
        Hashtable<String, ArrayList<Fruit>> orders = cart.getOrder();
        
        Enumeration<String> customerName = orders.keys();
        while (customerName.hasMoreElements()) {
            String cName = customerName.nextElement();
            ArrayList<Fruit> customerOrder = orders.get(cName);
            
            System.out.println("Customer: " + cName);
            System.out.println("Product | Quantity | Price | Amount");

            int totalAmount = 0;
            for (int i = 0; i < customerOrder.size(); i++) {
                Fruit fruit = customerOrder.get(i);
                int amount = fruit.getfQuantity() * fruit.getfPrice();
                totalAmount += amount;

                System.out.printf("%-14s%-9d%-9d%1d$%n", fruit.getfName(), fruit.getfQuantity(), fruit.getfPrice(), amount);
            }

            System.out.println("Total: " + totalAmount + "$\n");
        }
    }
    
}
