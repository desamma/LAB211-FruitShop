
package Controller;

import Common.Library;
import Model.Cart;
import Model.Fruit;
import Model.FruitList;
import View.View;
import view.Menu;

public class FruitShop extends Menu{

    private static String[] mc = {"Create fruit", "View orders", "Shopping (for buyer)", "Exit"};
    private FruitList fList;
    private Library lib;
    private View v;
    private Cart c;
    
    public FruitShop(){
        super("FRUIT SHOP SYSTEM", mc);
        lib = new Library();
        fList = new FruitList();
        v = new View();
        c = new Cart();
        fList.add(new Fruit(0, "Coconut", 2, 10, "Vietnam"));
        fList.add(new Fruit(1, "Orange", 3, 15, "US"));
        fList.add(new Fruit(2, "Apple", 4, 20, "Thailand"));
    }

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                addFruit();
                break;
            case 2:
                viewOrder();
                break;
            case 3:
                selected();
                break;
            case 4:
                System.exit(0);
        }
    }
    
    public void addFruit(){
        char choice;
        int id;
        do {
            id = fList.size();
            String name = lib.getString("Enter name: ");
            int price = lib.getInt("Enter price: ");
            int quantity = lib.getInt("Enter quantity: ");
            String origin = lib.getString("Enter origin: ");
            fList.add(new Fruit(id, name, price, quantity, origin));
            id++;
            choice = lib.getChar("Do you want to continue (Y/N)?");
        } while (choice == 'y' || choice == 'Y');
    }
    
    public void selected() {
    char choice;
    
    do {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        v.print(fList);
        int rmsId = lib.getInt("Enter fruit id: ");
        Fruit rms = fList.findById(rmsId);
        choice = lib.getChar("Do you want to order this item (Y/N)");

        if (choice == 'y' || choice == 'Y') {
            System.out.println("You selected: " + rms.getfName());
            int rmq = lib.getInt("Please input quantity: ");
            if (rmq <= rms.getfQuantity()) {
                rms.setfQuantity(rms.getfQuantity() - rmq);
                c.addItem(rms);
                System.out.println("Selected successfully. There are " + rms.getfQuantity() + " fruits left");
                System.out.printf("%-10s%-12s%-10s%-10s%n", "Product", "Quantity", "Price", "Amount");
                int amount = rmq * rms.getfPrice();
                System.out.printf("%-10s%-12d%-10d%-10d%n", rms.getfName(), rmq, rms.getfPrice(), amount);
                System.out.println("Total: " + amount + "$");
            } else {
                System.out.println("There are not enough fruit");
            }
        }
        choice = lib.getChar("Do you want to order more items (Y/N)");
    } while (choice == 'y' || choice == 'Y');
    
    String customerName = lib.getString("Input your name: ");
    c.makeOrder(customerName);
}

    
    public void viewOrder(){
        v.printOder(c);
    }
}
