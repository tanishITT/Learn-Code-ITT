class VIPCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.20;
    }

    @Override
    public String getCustomerType() {
        return "VIP";
    }
}