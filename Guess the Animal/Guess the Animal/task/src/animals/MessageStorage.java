package animals;

import java.util.Set;

public interface MessageStorage {
    Set<String> get(String messageKey);

    String find(String messageKey);

    static MessageStorage def() {
        return new DefaultMessageStorage();
    }
}
