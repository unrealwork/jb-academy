package com.axibase.asts.client.config;

public interface Parsable<T> {
    T parse(String s);
}
