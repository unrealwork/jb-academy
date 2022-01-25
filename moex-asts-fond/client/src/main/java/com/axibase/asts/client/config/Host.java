package com.axibase.asts.client.config;

import lombok.Data;

@Data
public class Host {
    private final String hostName;
    private final int port;

    public String toConfigString() {
        return hostName + ":" + port;
    }
}
