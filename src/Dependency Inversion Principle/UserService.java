class UserService {
    private final Database database;
    private final NotificationService notificationService;
    private final Logger logger;

    // Dependency injection through constructor
    public UserService(Database database, NotificationService notificationService, Logger logger) {
        this.database = database;
        this.notificationService = notificationService;
        this.logger = logger;
    }

    public void registerUser(String username, String email) {
        logger.log("Starting user registration for: " + username);

        database.connect();

        String userData = "User{name='" + username + "', email='" + email + "'}";
        database.save(userData);

        logger.log("User data saved successfully");

        notificationService.sendNotification(
                "Welcome " + username + "! Your account has been created."
        );

        database.disconnect();

        logger.log("User registration completed for: " + username);
    }

    public void retrieveUser(String userId) {
        logger.log("Retrieving user with ID: " + userId);
        database.connect();
        String data = database.read(userId);
        System.out.println("Retrieved: " + data);
        database.disconnect();
    }
}