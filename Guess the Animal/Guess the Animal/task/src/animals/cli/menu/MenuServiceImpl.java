package animals.cli.menu;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.cli.Message;
import animals.cli.StatisticsAction;
import animals.lang.Fact;
import animals.storage.MessageKeys;
import animals.storage.MessageStorage;
import animals.tree.FileFormat;
import animals.tree.TreeNode;
import animals.util.MapBuilder;

import java.util.EnumMap;
import java.util.Map;

public class MenuServiceImpl implements MenuService {
    private static final Map<MenuOption, String> MENU_LABEL_KEYS = MapBuilder.<MenuOption, String>immutable()
            .put(MenuOption.GAME, MessageKeys.MENU_GAME)
            .put(MenuOption.LIST, MessageKeys.MENU_LIST)
            .put(MenuOption.SEARCH, MessageKeys.MENU_SEARCH)
            .put(MenuOption.STAT, MessageKeys.MENU_STAT)
            .put(MenuOption.PRINT_TREE, MessageKeys.MENU_PRINT_TREE)
            .put(MenuOption.EXIT, MessageKeys.MENU_EXIT)
            .build();

    private final Map<MenuOption, Action<Void>> actionMap = new EnumMap<>(MenuOption.class);
    private final ActionFactory actionFactory;
    private final MessageStorage messageStorage;

    private final TreeNode<Fact> tree;

    private final FileFormat format;

    MenuServiceImpl(ActionFactory actionFactory, MessageStorage messageStorage, TreeNode<Fact> tree, FileFormat format) {
        this.actionFactory = actionFactory;
        this.messageStorage = messageStorage;
        this.tree = tree;
        this.format = format;
    }

    @Override
    public Action<Void> menuAction(MenuOption option) {
        return actionMap.computeIfAbsent(option, o -> {
            switch (o) {
                case GAME:
                    return new GameAction(actionFactory, messageStorage, tree, format);
                case EXIT:
                    return () -> null;
                case LIST:
                    return new ListAnimalsAction(actionFactory, messageStorage, tree);
                case SEARCH:
                    return new SearchAnimalAction(actionFactory, messageStorage, tree);
                case PRINT_TREE:
                    return new PrintTreeAction(actionFactory, tree);
                case STAT:
                    return new StatisticsAction(actionFactory, messageStorage, tree);


                default:
                    throw new IllegalStateException("Unsupported Game Action");
            }
        });
    }

    @Override
    public String menuName(MenuOption option) {
        return messageStorage
                .find(MENU_LABEL_KEYS.get(option));
    }

    @Override
    public Message menuIntro() {
        String introMessage = messageStorage.find(MessageKeys.MENU_INTRO);
        StringBuilder res = new StringBuilder(introMessage);
        for (MenuOption opt : MenuOption.values()) {
            res.append(opt.order())
                    .append(". ")
                    .append(menuName(opt))
                    .append(System.lineSeparator());
        }
        return actionFactory.message(res.toString());
    }

    @Override
    public Action<MenuOption> menuRoutine() {
        return actionFactory.menuAction(this);
    }
}
