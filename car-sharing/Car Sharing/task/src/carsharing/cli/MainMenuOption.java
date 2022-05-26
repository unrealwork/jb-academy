package carsharing.cli;

public enum MainMenuOption implements MenuOption {
    LOGIN("Log in as a manager", 1),
    EXIT("Exit", 0);

    private final String label;
    private final int num;

    MainMenuOption(String label, int num) {
        this.label = label;
        this.num = num;
    }

    @Override
    public String label() {
        return label;
    }

    @Override
    public int num() {
        return num;
    }
}
