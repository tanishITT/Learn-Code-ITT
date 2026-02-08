public class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet(89);
        Customer customer = new Customer("Augustya", "Yadav", wallet);
        Paperboy paperboy = new Paperboy();

        paperboy.collectPayment(customer, 40.0);
        paperboy.collectPayment(customer, 10.0);
    }
}