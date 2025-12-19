class MongoDBDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connected to MongoDB database");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnected from MongoDB database");
    }

    @Override
    public void save(String data) {
        System.out.println("MongoDB: Inserting document -> " + data);
    }

    @Override
    public String read(String id) {
        return "MongoDB: Document for ID " + id;
    }
}