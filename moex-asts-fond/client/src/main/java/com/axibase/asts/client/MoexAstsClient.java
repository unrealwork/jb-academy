package com.axibase.asts.client;


import com.axibase.asts.client.config.ClientConfig;
import com.axibase.asts.client.model.ServerInfo;
import com.axibase.asts.client.transaction.TransactionResult;
import com.micex.client.Meta;

public interface MoexAstsClient extends AutoCloseable {
    boolean connect();

    TransactionResult changePassword(String newPassword);

    ServerInfo serverInfo();

    Meta.Market marketInfo();

    void disconnect();

    ClientConfig getConfig();
}
