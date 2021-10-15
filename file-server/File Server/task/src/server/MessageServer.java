package server;

import java.io.IOException;

public interface MessageServer extends Server<String, String>, AutoCloseable {
    void start() throws Exception;

    void listen() throws Exception;

    void sendMessage(String message) throws IOException;

    void stop();

    void addMessageCallback(Handler<String, String> callback);
}
