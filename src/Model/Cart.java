
package Model;

import java.util.ArrayList;
import java.util.Hashtable;

public class Cart {
    private ArrayList<Fruit> item;
    private Hashtable<String, ArrayList<Fruit>> order;

    public Cart() {
        this.item = new ArrayList<>();
        this.order = new Hashtable<>();
    }
    
    public void addItem(Fruit f){
        item.add(f);
    }
    
    public void makeOrder(String customer){
        ArrayList<Fruit> orderItem = new ArrayList<>(item);
        order.put(customer, orderItem);
        item.clear();
    }
    
    public Hashtable<String, ArrayList<Fruit>> getOrder(){
        return order;
    }
}
