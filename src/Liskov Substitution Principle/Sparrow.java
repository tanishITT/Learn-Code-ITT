class Sparrow extends Bird implements Flyable {
    public Sparrow(String name) {
        super(name);
    }

    @Override
    public void move() {
        fly();
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying through the air.");
    }

    @Override
    public int getMaxAltitude() {
        return 1000; // meters
    }
}