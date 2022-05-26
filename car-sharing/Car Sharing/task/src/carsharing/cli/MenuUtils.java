package carsharing.cli;

final class MenuUtils {
    private MenuUtils() {
        
    }

    static <T extends MenuOption> String buildMenu(T... opts) {
        StringBuilder sb = new StringBuilder();
        for (T opt : opts) {
            sb.append(opt.num())
                    .append(". ")
                    .append(opt.label())
                    .append(System.lineSeparator());
        }
        String menu = sb.toString();
        return menu;
    }
}
