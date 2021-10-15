package client;

import java.io.IOException;

public interface Receiver<T> {
    T receive() throws IOException;

}
