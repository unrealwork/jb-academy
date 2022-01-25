package com.axibase.asts.client.transaction;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TransactionBuilder<T> implements CommandStep, OptionalStep<T> {
    private String command;
    private Map<String, Object> params = new HashMap<>();

    @Override
    public OptionalStep<T> command(String command) {
        this.command = command;
        return this;
    }

    @Override
    public OptionalStep<T> addParam(String paramName, T paramValue) {
        params.put(paramName, paramValue);
        return this;
    }

    @Override
    public Transaction build() {
        return new SimpleTransaction(command, Collections.unmodifiableMap(params));
    }
}
