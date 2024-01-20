
package Model;

public class Fruit implements Comparable<Fruit>{
    private int fId = 0;
    private String fName;
    private int fPrice;
    private int fQuantity;
    private String fOrigin;

    public Fruit(int fId, String fName, int fPrice, int fQuantity, String fOrigin) {
        this.fId = fId;
        this.fName = fName;
        this.fPrice = fPrice;
        this.fQuantity = fQuantity;
        this.fOrigin = fOrigin;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getfPrice() {
        return fPrice;
    }

    public void setfPrice(int fPrice) {
        this.fPrice = fPrice;
    }

    public int getfQuantity() {
        return fQuantity;
    }

    public void setfQuantity(int fQuantity) {
        this.fQuantity = fQuantity;
    }

    public String getfOrigin() {
        return fOrigin;
    }

    public void setfOrigin(String fOrigin) {
        this.fOrigin = fOrigin;
    }

    @Override
    public String toString() {
        return String.format("      %-14s%-16s%-18s%1s$", fId, fName, fOrigin, fPrice);
    }

    @Override
    public int compareTo(Fruit o) {
        return Integer.compare(this.fId, o.fId);
    }
    
}
