package animals.cli.menu;

import animals.cli.Message;
import animals.cli.Question;

import java.util.Scanner;

public class MenuAction extends Question<MenuOption> {
    private final MenuService menuService;
    public MenuAction(Scanner scanner, MenuService menuService) {
        super(scanner);
        this.menuService = menuService;
    } 
    @Override
    public MenuOption read(Scanner sc) {
        return MenuOption.fromOrderNumber(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public Message question() {
        return menuService.menuIntro();
    }
}
