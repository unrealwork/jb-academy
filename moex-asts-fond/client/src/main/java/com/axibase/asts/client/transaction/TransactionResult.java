package com.axibase.asts.client.transaction;

import com.micex.client.Client;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class TransactionResult {
    private final boolean isSuccess;
    private final String message;

    public static TransactionResult fromApiReport(Client.Report report) {
        return new TransactionResult(report.success, report.message);
    }
}
