class Contractor implements Workable, TimesheetSubmittable {
    private String name;

    public Contractor(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println(name + " (Contractor) is working remotely.");
    }

    @Override
    public void submitTimesheet() {
        System.out.println(name + " submitted contractor invoice.");
    }
}