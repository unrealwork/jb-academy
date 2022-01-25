package com.axibase.asts.client.transaction;

import org.omg.CORBA.Object;

import java.util.Map;

public interface OptionalStep<T> {
    OptionalStep<T> addParam(String paramName, T paramValue);

    default OptionalStep<T> addParams(Map<String, T> params) {
        params.forEach(this::addParam);
        return this;
    }

    Transaction build();
}
