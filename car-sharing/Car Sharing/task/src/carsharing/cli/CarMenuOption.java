package carsharing.cli;

enum CarMenuOption implements MenuOption {
    LIST("Car list", 1),
    CREAT("Create a car", 2),
    BACK("Back", 0);

    private final String label;
    private final int num;

    CarMenuOption(String label, int num) {
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
