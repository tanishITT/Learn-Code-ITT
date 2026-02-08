public class Paperboy {
    public void collectPayment(Customer customer, double amount) {
        if (customer.pay(amount)) {
            System.out.println("Payment of $" + amount + " collected from " + customer.getFirstName() + " " + customer.getLastName());
        } else {
            System.out.println("Payment of $" + amount + " could not be collected from " + customer.getFirstName() + " " + customer.getLastName() + ". Not enough funds.");
        }
    }
}