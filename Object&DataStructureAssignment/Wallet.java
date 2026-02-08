public class Wallet {
    private double value;
    
    public double getBalance() {
        return value;
    }
    public Wallet(double value) {
        this.value = value;
    }

    public void subtractMoney(double debit) {
        if (hasEnough(debit)) {
            value -= debit;
        }
    }

    public boolean hasEnough(double amount) {
        return value >= amount;
    }

}