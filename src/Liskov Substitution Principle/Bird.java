
abstract class Bird {
    protected String name;

    public Bird(String name) {
        this.name = name;
    }

    public abstract void move();

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public String getName() {
        return name;
    }
}

