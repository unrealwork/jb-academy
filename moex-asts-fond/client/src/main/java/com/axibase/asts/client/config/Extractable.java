package com.axibase.asts.client.config;

import java.util.Map;

public interface Extractable<T> {
    String extract(Map<String, String> map);
}
