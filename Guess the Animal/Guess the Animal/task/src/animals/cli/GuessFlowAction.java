package animals.cli;

import animals.lang.Fact;
import animals.lang.composer.Composer;
import animals.tree.TreeNode;

public class GuessFlowAction implements Action<TreeNode<Fact>> {
    private final ActionFactory factory;
    private final TreeNode<Fact> tree;

    public GuessFlowAction(ActionFactory factory, TreeNode<Fact> tree) {
        this.factory = factory;
        this.tree = tree;
    }

    @Override
    public TreeNode<Fact> execute() {
        TreeNode<Fact> cur = tree;
        while (!cur.isTerminal()) {
            Fact fact = cur.val();
            final Action<Boolean> confirmation = factory.confirmationQuestion(Composer.question(fact).asText());
            Boolean ans = confirmation.execute();
            while (ans == null) {
                ans = confirmation.execute();
            }
            cur = ans ? cur.right() : cur.left();
        }
        return cur;
    }
}
