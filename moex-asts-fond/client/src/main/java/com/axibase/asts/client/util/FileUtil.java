package com.axibase.asts.client.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@UtilityClass
public class FileUtil {
    @SneakyThrows
    public Path classPathResource(final Class<?> clazz, final String relativePath) {
        URL resourceRoot = clazz.getClassLoader().getResource("");
        if (resourceRoot == null) {
            throw new IllegalStateException("classpath root is not found");
        }
        return Paths.get(resourceRoot.toURI()).resolve(relativePath).toAbsolutePath();
    }


    public Path classPathResource(final String relativePath) {
        return classPathResource(FileUtil.class, relativePath);
    }


    public Properties readProperties(final Path pathToProperties) throws IOException {
        Properties properties = new Properties();
        if (!Files.exists(pathToProperties)) {
            throw new IllegalStateException("Properties file " + pathToProperties + " is not found");
        }
        try (Reader reader = Files.newBufferedReader(pathToProperties)) {
            properties.load(reader);
            return properties;
        }
    }
}
