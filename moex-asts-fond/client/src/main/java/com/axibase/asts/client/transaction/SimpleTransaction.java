package com.axibase.asts.client.transaction;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class SimpleTransaction implements Transaction {
    private final String command;
    private final Map<String, Object> params;


    @Override
    public Map<String, Object> params() {
        return params;
    }
}
