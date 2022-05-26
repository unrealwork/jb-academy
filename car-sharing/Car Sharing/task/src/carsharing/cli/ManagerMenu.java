package carsharing.cli;

class ManagerMenu implements Action<Void> {
    private final ActionFactory actionFactory;
    private final MenuActionFactory menuActionFactory;

    public ManagerMenu(ActionFactory actionFactory, MenuActionFactory menuActionFactory) {
        this.actionFactory = actionFactory;
        this.menuActionFactory = menuActionFactory;
    }

    @Override
    public Void execute() {
        String menuText = MenuUtils.buildMenu(ManagerMenuOption.values());
        actionFactory.message(menuText).execute();
        ManagerMenuOption opt = actionFactory.menuOption(ManagerMenuOption.values()).execute();
        menuActionFactory.get(opt).execute();
        return null;
    }
}
