package animals.cli.menu;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.Token;
import animals.lang.composer.Composer;
import animals.tree.TreeNode;

import java.util.List;
import java.util.function.Consumer;

class PrintTreeAction implements Action<Void> {
    private static final char RIGHT_CHILD = '└';
    private static final char LEFT_CHILD = '├';
    private static final char SKIP_SYMBOL = '│';
    private final ActionFactory actionFactory;
    private final TreeNode<Fact> tree;

    PrintTreeAction(ActionFactory actionFactory, TreeNode<Fact> tree) {
        this.actionFactory = actionFactory;
        this.tree = tree;
    }

    @Override
    public Void execute() {
        actionFactory.message(buildMessage())
                .execute();
        return null;
    }

    private String buildMessage() {
        StringBuilder builder = new StringBuilder();
        traverse(tree, true, new StringBuilder(" "),
                s -> builder.append(s).append(System.lineSeparator()));
        return builder.toString();
    }

    private static void traverse(TreeNode<Fact> node, boolean isRight, StringBuilder acc, Consumer<String> consumer) {
        if (node == null) {
            return;
        }
        StringBuilder nextLeft = nextAcc(acc);
        StringBuilder nextRight = nextAcc(acc);
        final String res = acc.append(isRight ? RIGHT_CHILD : LEFT_CHILD)
                .append(' ')
                .append(factAsText(node))
                .toString();
        consumer.accept(res);
        traverse(node.left(), false, nextLeft, consumer);
        traverse(node.right(), true, nextRight, consumer);
    }

    private static String factAsText(TreeNode<Fact> factTreeNode) {
        if (factTreeNode.isTerminal()) {
            List<Token> tokens = factTreeNode.val().exp().tokens();
            return Expression.fromTokens(tokens.subList(2, tokens.size()))
                    .asText();
        }
        return Composer.question(factTreeNode.val()).asText();
    }

    private static StringBuilder nextAcc(StringBuilder acc) {
        return new StringBuilder(acc)
                .append(acc.length() == 1 ? ' ' : SKIP_SYMBOL);
    }
}
