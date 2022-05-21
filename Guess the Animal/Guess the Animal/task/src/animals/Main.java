package animals;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.cli.Question;
import animals.cli.menu.MenuOption;
import animals.cli.menu.MenuService;
import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.Subject;
import animals.lang.Token;
import animals.storage.MessageKeys;
import animals.storage.MessageStorage;
import animals.tree.FileFormat;
import animals.tree.TreeLoader;
import animals.tree.TreeNode;

import java.util.List;

import static animals.storage.MessageKeys.FACT_TEMPLATE;
import static java.lang.Boolean.TRUE;

public class Main {
    public static void main(String[] args) throws Exception {
        MessageStorage storage = MessageStorage.def();
        final FileFormat format = FileFormat.fromArgs(args);
        try (ActionFactory actionFactory = ActionFactory.cli()) {
            actionFactory.greetingMessage().execute();
            actionFactory.lineBreak().execute();
            TreeNode<Fact> tree = TreeLoader.load(format);
            if (tree == null) {
                final Question<Subject> baseAnimalRequest = actionFactory.subjectQuestion(storage.find(MessageKeys.BASE_ANIMAL_REQUEST));
                final Subject baseAnimal = baseAnimalRequest.execute();
                tree = TreeNode.create(Fact.fromSubject(baseAnimal));
            }
            final MenuService menuService = MenuService.create(actionFactory, storage, tree, format);
            final Action<MenuOption> menuRoutine = menuService.menuRoutine();
            MenuOption option = null;
            do {
                option = menuRoutine.execute();
                menuService.menuAction(option)
                        .execute();
            } while (option != MenuOption.EXIT);
            actionFactory.lineBreak().execute();
            actionFactory.byeMessage().execute();
        }
    }
}
