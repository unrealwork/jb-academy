package carsharing.config;

import java.util.HashMap;
import java.util.Map;

import static carsharing.config.ParamNames.DATABASE_FILE_NAME;

class AppConfigImpl implements AppConfig {

    private static final String DEFAULT_DB_NAME = "carsharing";
    private final String databaseFileName;

    private AppConfigImpl(Map<String, String> params) {
        this.databaseFileName = params.getOrDefault(DATABASE_FILE_NAME, DEFAULT_DB_NAME);

    }


    @Override
    public String getDatabaseFileName() {
        return databaseFileName;
    }

    static AppConfig fromArgs(final String... args) {
        if (args.length % 2 != 0) {
            throw new IllegalStateException("Each parameter should has value as next argument");
        }
        final Map<String, String> params = new HashMap<>(args.length / 2);
        for (int i = 0; i < args.length; i += 2) {
            if (args[i].startsWith("-")) {
                params.put(args[i].substring(1), args[i + 1]);
            } else {
                throw new IllegalStateException("Invalid param name " + args[i] + ".Param name Should start with -");
            }
        }
        return new AppConfigImpl(params);
    }
}
