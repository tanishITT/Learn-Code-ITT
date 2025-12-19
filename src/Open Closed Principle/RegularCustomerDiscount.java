class RegularCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.05;
    }

    @Override
    public String getCustomerType() {
        return "Regular";
    }
}