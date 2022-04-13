package processor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Operation implements MenuEntry {
    ADD(1, "Add matrices"),
    SCALAR(2, "Multiply matrix by a constant"),
    TIMES(3, "Multiply matrices"),
    EXIT(0, "Exit");

    private final int choice;
    private final String title;

    Operation(int choice, String title) {
        this.choice = choice;
        this.title = title;
    }

    @Override
    public int getChoice() {
        return choice;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<MenuEntry> getChildren() {
        return Collections.emptyList();
    }

    public static Operation byChoice(int choice) {
        return Arrays.stream(values())
                .filter(op -> op.getChoice() == choice)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Unsupported choice"));
    }
}
