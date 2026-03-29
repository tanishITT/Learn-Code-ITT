class CorporateCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.15;
    }

    @Override
    public String getCustomerType() {
        return "Corporate";
    }
}
