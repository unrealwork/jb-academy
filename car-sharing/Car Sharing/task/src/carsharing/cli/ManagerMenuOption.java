package carsharing.cli;

enum ManagerMenuOption implements MenuOption {
    COMPANY_LIST("Company list", 1), CREATE_COMPANY("Create a company", 2), BACK("Back", 0);

    private final String label;
    private final int num;

    ManagerMenuOption(String label, int num) {
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
