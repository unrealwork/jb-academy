package com.axibase.asts.client.transaction;

import java.util.Map;

public interface Transaction {
    String getCommand();

    Map<String, Object> params();

    static CommandStep builder() {
        return new TransactionBuilder();
    }
}
