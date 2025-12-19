class MySQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connected to MySQL database");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected from MySQL database");
    }

    @Override
    public void save(String data) {
        System.out.println("MySQL: Saving data -> " + data);
    }

    @Override
    public String read(String id) {
        return "MySQL: Data for ID " + id;
    }
}