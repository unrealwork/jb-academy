package com.axibase.asts.client.model;

import com.micex.client.API;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ServerInfo {
    public final int sessionID;
    public final char systemID;
    public final String userID;

    public static ServerInfo fromAPIObject(API.ServerInfo serverInfo) {
        return new ServerInfo(serverInfo.sessionID, serverInfo.systemID, serverInfo.userID);
    }
}
