package com.axibase.asts.client;

import com.axibase.asts.client.config.ClientConfigs;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Clients {
    public MoexAstsClient defaultClient() {
        MoexAstsClientImpl client = new MoexAstsClientImpl(ClientConfigs.defaultConfig());
        client.connect();
        return client;
    }
}
