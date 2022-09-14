package Week_4;

import java.util.ArrayList;

public class Invoice {

//    private static class Item { // Item is nested inside Invoice
//    String description; // No need to set this as private
//    int quantity;
//    double unitPrice;
//    double price() {
//        return quantity * unitPrice;
//    }
//    }
//    private ArrayList<Item> items = new ArrayList<>();
//    //...
//    // A sample method using inner class Item:
//        public void addItem(String description, int quantity, double unitPrice) {
//        Item newItem = new Item();
//        newItem.description = description;
//        newItem.quantity = quantity;
//        newItem.unitPrice = unitPrice;
//        items.add(newItem);
//    }

    public static class Item { // A public nested class (1.2.4 Encapsulation)(1.2.15 Nested Classes)
        private String description; //Week4 Task 1.2.15.1 Static Nested Classes
        private int quantity;
        private double unitPrice;
        public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getDescription() {
            return description;
        }
        public double getPrice() {
            return quantity * unitPrice;
        }
        public double getUnitPrice() {
            return unitPrice;
        }
        public double getQuantity() {
            return quantity;
        }
        //...
    }
    private ArrayList<Item> items = new ArrayList<>();
    public void add(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems () {
        return items;
    }
    //...
}
