class Eagle extends Bird implements Flyable {
    public Eagle(String name) {
        super(name);
    }

    @Override
    public void move() {
        fly();
    }

    @Override
    public void fly() {
        System.out.println(name + " is soaring at high altitude.");
    }

    @Override
    public int getMaxAltitude() {
        return 5000; // meters
    }
}