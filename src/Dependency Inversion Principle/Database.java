interface Database {
    void connect();
    void disconnect();
    void save(String data);
    String read(String id);
}