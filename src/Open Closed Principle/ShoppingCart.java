class ShoppingCart {
    private List<Double> items = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public ShoppingCart(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void addItem(double price) {
        items.add(price);
    }

    public double calculateTotal() {
        double total = items.stream().mapToDouble(Double::doubleValue).sum();
        double discount = discountStrategy.calculateDiscount(total);
        return total - discount;
    }

    public void printReceipt() {
        double subtotal = items.stream().mapToDouble(Double::doubleValue).sum();
        double discount = discountStrategy.calculateDiscount(subtotal);
        double total = subtotal - discount;

        System.out.println("\n===== RECEIPT =====");
        System.out.println("Customer Type: " + discountStrategy.getCustomerType());
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Discount: -$" + String.format("%.2f", discount));
        System.out.println("Total: $" + String.format("%.2f", total));
        System.out.println("===================\n");
    }
}