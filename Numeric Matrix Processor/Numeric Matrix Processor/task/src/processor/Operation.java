package processor;

import java.util.Arrays;
import java.util.List;

public enum Operation implements MenuEntry {
    ADD(1, "Add matrices"),
    SCALAR(2, "Multiply matrix by a constant"),
    TIMES(3, "Multiply matrices"),
    TRANSPOSE(4, "Transpose matrix", TransposeOperation.values()),
    DETERMINANT(5, "Calculate a determinant"),
    INVERSE(6, "Inverse matrix"),
    EXIT(0, "Exit");

    private final int choice;
    private final String title;
    private final List<MenuEntry> children;

    Operation(int choice, String title) {
        this(choice, title, new MenuEntry[] {});
    }

    Operation(int choice, String title, MenuEntry... values) {
        this.choice = choice;
        this.title = title;
        this.children = Arrays.asList(values);
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
        return children;
    }

    public static Operation byChoice(int choice) {
        return Arrays.stream(values())
                .filter(op -> op.getChoice() == choice)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Unsupported choice"));
    }
}
