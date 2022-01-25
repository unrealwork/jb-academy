package com.axibase.asts.client.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ClientConfig {

    Host getPreferredHost();

    List<Host> getHosts();

    String getServerId();

    UserCredentials getUserCredentials();

    String getInterfaceId();

    Map<String, String> getOptionalParams();

    default Map<String, String> asMap() {
        Map<String, String> res = new HashMap<>();
        final String hosts = getHosts().stream().map(Host::toConfigString)
                .collect(Collectors.joining(","));
        Host preferredHost = getPreferredHost();
        res.put(ParamNames.HOST, preferredHost != null ? preferredHost + "," : "" + hosts);
        if (preferredHost != null) {
            res.put(ParamNames.PREFERRED_HOST, preferredHost.toConfigString());
        }
        res.put(ParamNames.SERVER_ID, getServerId());
        UserCredentials credentials = getUserCredentials();
        res.put(ParamNames.USER_ID, credentials.getUsername());
        res.put(ParamNames.PASSWORD, credentials.getPassword());
        res.put(ParamNames.INTERFACE_ID, getInterfaceId());

        res.putAll(getOptionalParams());

        return Collections.unmodifiableMap(res);
    }
}
