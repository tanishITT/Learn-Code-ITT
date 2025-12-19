class RobotWorker implements Workable, MeetingAttendable, TimesheetSubmittable {
    private String serialNumber;

    public RobotWorker(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public void work() {
        System.out.println("Robot " + serialNumber + " is processing tasks 24/7.");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Robot " + serialNumber + " is connected to virtual meeting.");
    }

    @Override
    public void submitTimesheet() {
        System.out.println("Robot " + serialNumber + " auto-submitted activity log.");
    }
}