package processor;

import java.util.List;

public interface MenuEntry {
    int getChoice();

    String getTitle();

    List<MenuEntry> getChildren();
}
