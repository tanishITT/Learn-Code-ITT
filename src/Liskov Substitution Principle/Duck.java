class Duck extends Bird implements Flyable, Swimmable {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " can fly or swim.");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying.");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming.");
    }

    @Override
    public int getMaxAltitude() {
        return 800; // meters
    }

    @Override
    public int getMaxDepth() {
        return 10; // meters
    }
}