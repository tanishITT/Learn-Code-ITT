public class OCPDemo {
    public static void main(String[] args) {
        ShoppingCart cart1 = new ShoppingCart(new RegularCustomerDiscount());
        cart1.addItem(100.0);
        cart1.addItem(50.0);
        cart1.printReceipt();

        ShoppingCart cart2 = new ShoppingCart(new VIPCustomerDiscount());
        cart2.addItem(100.0);
        cart2.addItem(50.0);
        cart2.printReceipt();

        ShoppingCart cart3 = new ShoppingCart(new CorporateCustomerDiscount());
        cart3.addItem(100.0);
        cart3.addItem(50.0);
        cart3.printReceipt();
    }
}