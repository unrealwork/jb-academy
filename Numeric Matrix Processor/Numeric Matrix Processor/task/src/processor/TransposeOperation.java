package processor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TransposeOperation implements MenuEntry {
    MAIN_DIAG(1, "Main diagonal", TranspositionType.MAIN_DIAG),
    SIDE_DIAG(2, "Side diagonal", TranspositionType.SIDE_DIAG),
    VERTICAL_LINE(3, "Vertical line", TranspositionType.VERTICAL_LINE),
    HORIZONTAL_LINE(4, "Horizontal line", TranspositionType.HORIZONTAL_LINE);
    private final int choice;
    private final String title;
    private final TranspositionType type;

    TransposeOperation(int choice, String title, TranspositionType type) {
        this.choice = choice;
        this.title = title;
        this.type = type;
    }

    public static TransposeOperation byChoice(int choice) {
        return Arrays.stream(values())
                .filter(op -> op.getChoice() == choice)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Unsupported choice"));
    }

    public TranspositionType getType() {
        return type;
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
}
