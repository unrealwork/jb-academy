package carsharing.config;

import java.sql.Connection;

public interface AppConfig {
    String DB_DIR = "src/carsharing/db/";
    
    String getDatabaseFileName();
    
    static AppConfig fromArgs(String... args) {
        return AppConfigImpl.fromArgs(args);
    }
}
