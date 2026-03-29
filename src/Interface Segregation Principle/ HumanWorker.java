class HumanWorker implements Workable, Eatable, Sleepable, MeetingAttendable, TimesheetSubmittable {
    private String name;

    public HumanWorker(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println(name + " is working on tasks.");
    }

    @Override
    public void eat() {
        System.out.println(name + " is taking a lunch break.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is resting.");
    }

    @Override
    public void attendMeeting() {
        System.out.println(name + " is attending a team meeting.");
    }

    @Override
    public void submitTimesheet() {
        System.out.println(name + " submitted their timesheet.");
    }
}