package carsharing.cli;

public interface MenuOption {
    String label();

    int num();

    static <T extends MenuOption> T fromNumber(final int num, T... opts) {
        for (T opt : opts) {
            if (opt.num() == num) {
                return opt;
            }
        }
        throw new IllegalArgumentException(num + " is not associated with any menu option");
    }
}
