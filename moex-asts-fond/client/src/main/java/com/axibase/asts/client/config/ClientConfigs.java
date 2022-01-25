package com.axibase.asts.client.config;

import com.axibase.asts.client.util.FileUtil;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@UtilityClass
public class ClientConfigs {

    public static final String DEFAULT_CONFIG_NAME = "asts.config";

    public ClientConfig fromFile(Path pathToFile) throws IOException {
        Properties properties = FileUtil.readProperties(pathToFile);
        try (Reader reader = Files.newBufferedReader(pathToFile)) {
            properties.load(reader);
            return new MapBasedClientConfig(propertiesAsMap(properties));
        }
    }

    public ClientConfig defaultConfig() {
        try {
            return fromFile(FileUtil.classPathResource(DEFAULT_CONFIG_NAME));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Map<String, String> propertiesAsMap(Properties prop) {
        HashMap<String, String> retMap = new HashMap<>();
        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            retMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
        return retMap;
    }
}
