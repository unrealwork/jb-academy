package carsharing.cli;

public enum MainMenuOption implements MenuOption {
    LOGIN("Log in as a manager", 1),
    CUSTOMER("Log in as a customer", 2),
    CREATE_CUSTOMER("Create a customer", 3),
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
