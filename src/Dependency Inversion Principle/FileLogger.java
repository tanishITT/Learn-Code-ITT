class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("[FILE LOG] Writing to file: " + message);
    }
}