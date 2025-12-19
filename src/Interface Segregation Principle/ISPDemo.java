import java.util.ArrayList;
import java.util.List;

public class ISPDemo {
    public static void main(String[] args) {
        HumanWorker alice = new HumanWorker("Alice");
        RobotWorker robot = new RobotWorker("R2D2");
        Contractor bob = new Contractor("Bob");

        WorkManager manager = new WorkManager();

        System.out.println("===== WORK MANAGEMENT =====");
        manager.manageWork(alice);
        manager.manageWork(robot);
        manager.manageWork(bob);

        System.out.println("\n===== MEETINGS =====");
        manager.scheduleMeeting(alice);
        manager.scheduleMeeting(robot);

        System.out.println("\n===== LUNCH BREAK =====");
        manager.provideBreak(alice);

        System.out.println("\n===== TIMESHEET COLLECTION =====");
        manager.collectTimesheets(alice);
        manager.collectTimesheets(robot);
        manager.collectTimesheets(bob);

        System.out.println("\n===== REST TIME =====");
        if (alice instanceof Sleepable) {
            ((Sleepable) alice).sleep();
        }
    }
}