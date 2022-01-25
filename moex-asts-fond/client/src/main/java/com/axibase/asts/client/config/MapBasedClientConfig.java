package com.axibase.asts.client.config;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.axibase.asts.client.config.ConfigParam.HOST;
import static com.axibase.asts.client.config.ConfigParam.PASSWORD;
import static com.axibase.asts.client.config.ConfigParam.PREFERRED_HOST;
import static com.axibase.asts.client.config.ConfigParam.SERVER_ID;
import static com.axibase.asts.client.config.ConfigParam.USER_ID;

@Getter
public class MapBasedClientConfig implements ClientConfig {
    private final List<Host> hosts;
    private final Host preferredHost;
    private final String serverId;
    private final UserCredentials userCredentials;
    private final String interfaceId;
    private final Map<String, String> optionalParams;


    public MapBasedClientConfig(Map<String, String> map) {
        this.hosts = ParseUtil.parseHosts(HOST.extract(map));
        this.preferredHost = ParseUtil.parseHost(PREFERRED_HOST.extract(map));
        this.serverId = SERVER_ID.extract(map);
        this.userCredentials = new UserCredentials(USER_ID.extract(map), PASSWORD.extract(map));
        this.interfaceId = ConfigParam.INTERFACE_ID.extract(map);

        Set<String> requiredParamNames = Arrays.stream(ConfigParam.values())
                .map(Named::getName)
                .collect(Collectors.toSet());
        this.optionalParams = map.entrySet().stream()
                .filter(ev -> !requiredParamNames.contains(ev.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
