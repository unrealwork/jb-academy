package carsharing.config;

public interface AppConfig {
    public static String DB_DIR = "src/carsharing/db/";
    
    String getDatabaseFileName();

    static AppConfig fromArgs(String... args) {
        return AppConfigImpl.fromArgs(args);
    }
}
