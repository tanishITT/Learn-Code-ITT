class WorkManager {
    public void manageWork(Workable worker) {
        worker.work();
    }

    public void scheduleMeeting(MeetingAttendable attendee) {
        attendee.attendMeeting();
    }

    public void collectTimesheets(TimesheetSubmittable worker) {
        worker.submitTimesheet();
    }

    public void provideBreak(Eatable worker) {
        worker.eat();
    }
}