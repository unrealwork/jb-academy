package animals.cli.menu;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.Subject;
import animals.lang.Token;
import animals.storage.MessageKeys;
import animals.storage.MessageStorage;
import animals.tree.TreeNode;
import animals.tree.TreeTraversals;

import java.util.List;

public class ListAnimalsAction implements Action<Void> {
    private final ActionFactory actionFactory;
    private final MessageStorage storage;
    private final TreeNode<Fact> tree;

    public ListAnimalsAction(ActionFactory actionFactory, MessageStorage storage, TreeNode<Fact> tree) {
        this.actionFactory = actionFactory;
        this.storage = storage;
        this.tree = tree;
    }

    @Override
    public Void execute() {
        String listMessage = buildMessage();
        actionFactory.message(listMessage).execute();
        return null;
    }

    private String buildMessage() {
        StringBuilder builder = new StringBuilder(storage.find(MessageKeys.LIST_TITLE))
                .append(System.lineSeparator());
        TreeTraversals.preOrder(tree, node -> {
            if (node.isTerminal()) {
                builder.append(" - ")
                        .append(extractAnimal(node.val()))
                        .append(System.lineSeparator());
            }
        });
        return builder.toString();
    }

    private String extractAnimal(final Fact fact) {
        List<Token> tokens = fact.exp().tokens();
        Expression expression = Expression.fromTokens(tokens.subList(2, tokens.size()));
        final Subject subject = new Subject(expression);
        return subject.withoutArticle().asText();
    }
}
