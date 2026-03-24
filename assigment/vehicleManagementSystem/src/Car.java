public class Car implements Vehicle {

    private final VehicleInfo vehicleInfo;
    private double energyLevel;
    private boolean isRunning;

    public Car(VehicleInfo vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
        this.energyLevel = 0.0;
        this.isRunning = false;
    }

    @Override
    public double getPrice() {
        return vehicleInfo.getPrice();
    }

    @Override
    public void updatePrice(double newPrice) {
        vehicleInfo.setPrice(newPrice);
    }

    @Override
    public void start() {
        if (energyLevel > 0) {
            isRunning = true;
            System.out.println(vehicleInfo.getBrand() + " " + vehicleInfo.getModel() + " started.");
        } else {
            System.out.println("Cannot start " + vehicleInfo.getModel() + " - out of energy!");
        }
    }

    @Override
    public void stop() {
        if (isRunning) {
            isRunning = false;
            System.out.println(vehicleInfo.getBrand() + " " + vehicleInfo.getModel() + " stopped.");
        }
    }

    @Override
    public void replenishEnergy(double amount) {
        if (amount < 0 || energyLevel + amount > vehicleInfo.getMaxEnergyCapacity()) {
            System.out.println("Invalid energy amount.");
            return;
        }
        energyLevel += amount;
    }

    @Override
    public void printDetails() {
        System.out.println("Car: " + vehicleInfo.getYearOfManufacture() + " " +
                vehicleInfo.getBrand() + " " + vehicleInfo.getModel() +
                ", Price: $" + vehicleInfo.getPrice());
    }
}