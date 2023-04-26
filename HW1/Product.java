package HW1;


public class Product {
    String name;
    String category;
    String discirption;
    String store_ID;
    String manufaturer_ID;
    double price;
    String current_inventory;

    public void initialize(String n, String s, double p) {
        name = n;
        store_ID = s;
        price = p;

    }

    public void adjust(String c) {
        current_inventory = c;
    }

    public void output() {
        System.out.println(current_inventory);
    }
}
