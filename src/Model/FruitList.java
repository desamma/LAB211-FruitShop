
package Model;

import java.util.ArrayList;

public class FruitList extends ArrayList<Fruit>{
    
    public Fruit findById(int id) {
        for (Fruit f : this) {
            if (f.getfId() == id) {
                return f;
            }
        }
        return null;
    }
    
}
