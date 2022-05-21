package animals.cli.menu;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.cli.Message;
import animals.lang.Fact;
import animals.storage.MessageStorage;
import animals.tree.FileFormat;
import animals.tree.TreeNode;

public interface MenuService {
    Action<Void> menuAction(MenuOption option);

    String menuName(MenuOption option);

    Message menuIntro();

    static MenuService create(final ActionFactory actionFactory,
                              final MessageStorage storage,
                              final TreeNode<Fact> treeNode,
                              final FileFormat format) {
        return new MenuServiceImpl(actionFactory, storage, treeNode, format);
    }

    Action<MenuOption> menuRoutine();
}
