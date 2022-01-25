package com.axibase.asts.client.transaction;

public interface CommandStep {
    OptionalStep command(String command);
}
