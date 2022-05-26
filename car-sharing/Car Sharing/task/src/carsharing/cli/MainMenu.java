package carsharing.cli;

import static carsharing.cli.MenuUtils.buildMenu;

class MainMenu implements Action<Void> {
    private final ActionFactory actionFactory;
    private final MenuActionFactory menuActionFactory;

    MainMenu(ActionFactory actionFactory, MenuActionFactory menuActionFactory) {
        this.actionFactory = actionFactory;
        this.menuActionFactory = menuActionFactory;
    }

    @Override
    public Void execute() {
        String menu = buildMenu(MainMenuOption.values());
        actionFactory.message(menu)
                .execute();
        MainMenuOption opt = actionFactory.menuOption(MainMenuOption.values())
                .execute();

        Action<Void> voidAction = menuActionFactory.get(opt);
        voidAction.execute();
        return null;
}


}
