package common;

import java.io.InputStream;

public interface Bodied {
    InputStream getInputStream();
    String body();
}
