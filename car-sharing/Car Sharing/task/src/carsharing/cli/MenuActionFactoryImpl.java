package carsharing.cli;

import carsharing.model.Company;
import carsharing.service.dao.Dao;
import carsharing.util.MapBuilder;

import java.util.Map;
import java.util.function.Supplier;

class MenuActionFactoryImpl implements MenuActionFactory {
    private final Map<MenuOption, Supplier<Action<Void>>> actionsMap;

    public MenuActionFactoryImpl(ActionFactory actionFactory, Dao<Company> dao) {
        this.actionsMap = MapBuilder.<MenuOption, Supplier<Action<Void>>>immutable()
                .put(MainMenuOption.LOGIN, () -> new ManagerMenu(actionFactory, this))
                .put(ManagerMenuOption.BACK, () -> actionFactory.app(dao))
                .put(ManagerMenuOption.COMPANY_LIST, () -> new CompanyList(actionFactory, dao, this))
                .put(ManagerMenuOption.CREATE_COMPANY, () -> new CompanyCreate(actionFactory, dao, this))
                .put(MainMenuOption.EXIT, () -> {
                    System.exit(0);
                    return null;
                })
                .build();
    }

    @Override
    public Action<Void> get(MenuOption option) {
        return actionsMap.get(option).get();
    }
}
