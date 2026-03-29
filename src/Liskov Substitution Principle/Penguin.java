class Penguin extends Bird implements Swimmable {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void move() {
        swim();
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming in the ocean.");
    }

    @Override
    public int getMaxDepth() {
        return 250; // meters
    }
}