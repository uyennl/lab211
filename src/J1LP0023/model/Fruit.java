package J1LP0023.model;

public class Fruit {
    private String id;
    private String name,amount;
    private int price;
    private String origin;;
   private int  quantity;

    public Fruit(String id, String name, int price, String origin, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.origin = origin;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        String line = String.format("%-15d%-20s%-15s%-15d%-10d", id, name, origin, price, quantity);
        return line;
    }

    public String toStringOrder() {
        return name + "   " + quantity + "    " + price + "$" + "   " + amount + "$";
    }
}
