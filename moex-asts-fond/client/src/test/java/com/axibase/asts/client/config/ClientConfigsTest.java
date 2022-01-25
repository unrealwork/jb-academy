package com.axibase.asts.client.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

class ClientConfigsTest {

    @Test
    void testDefaultConfig() {
        ClientConfig clientConfig = ClientConfigs.defaultConfig();
        Assertions.assertNotNull(clientConfig);
        assertThat(clientConfig.getHosts(), hasSize(1));
        Map<String, String> paramsMap = clientConfig.asMap();
        assertThat(paramsMap.keySet(), hasSize(7));
    }
}
