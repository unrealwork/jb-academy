package com.axibase.asts.client.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@Getter
public enum ConfigParam implements Extractable<String>, Named {
    /**
     * List of comma-separated IP addresses with ports.
     */
    HOST(ParamNames.HOST, ""),
    /**
     * Preferred host address. If not defined, server with the smallest number
     * of users from the “HOST” list is used.
     */
    PREFERRED_HOST(ParamNames.PREFERRED_HOST),
    /**
     * Server ID
     */
    SERVER_ID(ParamNames.SERVER_ID),
    /**
     * User ID in the trading/clearing system
     */
    USER_ID(ParamNames.USER_ID),
    /**
     * User password in the trading/clearing system.
     */
    PASSWORD(ParamNames.PASSWORD),
    /**
     * Trading system interface ID.
     */
    INTERFACE_ID(ParamNames.INTERFACE_ID);

    private final String name;
    private final String defaultValue;

    ConfigParam(String name) {
        this.name = name;
        this.defaultValue = null;
    }

    @Override
    public String extract(Map<String, String> map) {
        return map.getOrDefault(name, defaultValue);
    }
}
