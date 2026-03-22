import java.util.ArrayList;
import java.util.List;

public class VehicleManager {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println(vehicle.getClass().getSimpleName() + " added.");
    }

    public void displayAll() {

        for (Vehicle vehicle : vehicles) {
            vehicle.printDetails();
        }
    }

    public double calcTotalValue() {
        double total = 0;

        for (Vehicle vehicle : vehicles) {
            total += vehicle.getPrice();
        }

        return total;
    }

    public void startAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.start();
        }
    }
}