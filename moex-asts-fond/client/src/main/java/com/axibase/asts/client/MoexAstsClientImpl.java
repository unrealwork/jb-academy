package com.axibase.asts.client;

import com.axibase.asts.client.config.ClientConfig;
import com.axibase.asts.client.model.ServerInfo;
import com.axibase.asts.client.transaction.Transaction;
import com.axibase.asts.client.transaction.TransactionResult;
import com.micex.client.Client;
import com.micex.client.ClientException;
import com.micex.client.Meta;
import lombok.Getter;
import lombok.SneakyThrows;
import org.scijava.nativelib.NativeLoader;

import java.util.HashMap;
import java.util.Map;


public class MoexAstsClientImpl implements MoexAstsClient {

    static {
        initNatives();
    }

    @Getter
    private final ClientConfig config;
    private final Client client;

    public MoexAstsClientImpl(ClientConfig clientConfig) {
        this.config = clientConfig;
        this.client = new Client();
    }

    @Override
    @SneakyThrows
    public boolean connect() {
        if (!client.active()) {
            client.start(config.asMap());
        } else {
            return false;
        }
        return true;
    }


    @Override
    public TransactionResult changePassword(String newPassword) {
        Transaction transaction = Transaction.builder()
                .command("CHANGE_PASSWORD")
                .addParam("NEWPW", newPassword)
                .addParam("CURRENTPW", config.getUserCredentials().getPassword())
                .build();
        return performTransaction(transaction);
    }

    private TransactionResult performTransaction(Transaction transaction) {
        try {
            Client.Report report = client.execute(transaction.getCommand(), transaction.params());
            return TransactionResult.fromApiReport(report);
        } catch (ClientException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public ServerInfo serverInfo() {
        return ServerInfo.fromAPIObject(client.getServerInfo());
    }

    @Override
    public Meta.Market marketInfo() {
        return client.getMarketInfo();
    }

    @Override
    public void disconnect() {
        client.close();
    }

    @SneakyThrows
    public static void initNatives() {
        System.setProperty("com.moex.asts.mtejni.load", "false");
        NativeLoader.loadLibrary("mtesrl64");
        NativeLoader.loadLibrary("mtejni");
    }

    @Override
    public void close() {
        if (client.active()) {
            client.close();
        }
    }
}
