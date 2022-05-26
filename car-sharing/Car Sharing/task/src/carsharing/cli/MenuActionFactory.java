package carsharing.cli;

public interface MenuActionFactory {
    Action<Void> get(MenuOption option);
}
