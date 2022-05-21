package animals.cli.menu;

public enum MenuOption {
    GAME(1), LIST(2), SEARCH(3), STAT(4), PRINT_TREE(5), EXIT(0);

    private final int order;

    MenuOption(int order) {
        this.order = order;
    }

    static MenuOption fromOrderNumber(int n) {
        for (MenuOption opt : values()) {
            if (opt.order == n) {
                return opt;
            }
        }
        throw new IllegalStateException("Unsupported menu option");
    }

    public int order() {
        return order;
    }
}
