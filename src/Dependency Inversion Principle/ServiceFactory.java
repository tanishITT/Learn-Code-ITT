class ServiceFactory {
    public static UserService createUserService(String dbType, String notificationType, String loggerType) {
        Database database = createDatabase(dbType);
        NotificationService notification = createNotificationService(notificationType);
        Logger logger = createLogger(loggerType);

        return new UserService(database, notification, logger);
    }

    private static Database createDatabase(String type) {
        switch (type.toLowerCase()) {
            case "mysql":
                return new MySQLDatabase();
            case "mongodb":
                return new MongoDBDatabase();
            default:
                return new MySQLDatabase();
        }
    }

    private static NotificationService createNotificationService(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            default:
                return new EmailNotification();
        }
    }

    private static Logger createLogger(String type) {
        switch (type.toLowerCase()) {
            case "console":
                return new ConsoleLogger();
            case "file":
                return new FileLogger();
            default:
                return new ConsoleLogger();
        }
    }
}