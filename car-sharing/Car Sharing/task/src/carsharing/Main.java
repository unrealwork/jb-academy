package carsharing;

import carsharing.config.AppConfig;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException {
        // write your code here
        AppConfig config = AppConfig.fromArgs(args);
        try (App app = App.create(config)) {
            app.start();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    
}
