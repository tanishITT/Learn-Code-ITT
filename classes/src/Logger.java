import java.util.Date;

class Logger {
    public void log(String message) {
        System.out.printf("[%tF %<tT] %s%n", new Date(), message);
    }
}