package com.axibase.asts.client.config;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
class ParseUtil {
    Host parseHost(final String hostString) {
        if (hostString == null) {
            return null;
        }
        String[] parts = hostString.split(":");
        if (parts.length != 2) {
            throw new IllegalStateException("Incorrect host format");
        }
        return new Host(parts[0], Integer.parseInt(parts[1]));
    }

    List<Host> parseHosts(final String hostsString) {
        return Arrays.stream(hostsString.trim().split(","))
                .map(String::trim)
                .map(ParseUtil::parseHost)
                .collect(Collectors.toList());
    }
}
