package animals.cli;

import animals.lang.Fact;
import animals.lang.Subject;
import animals.lang.composer.Composer;
import animals.tree.TreeNode;

import static animals.lang.Fact.fromSubject;

public class GuessGame implements Action<TreeNode<Fact>> {
    private final TreeNode<Fact> decisionTree;
    private final ActionFactory actionFactory;


    public GuessGame(Subject baseAnimal, ActionFactory actionFactory) {
        this.decisionTree = TreeNode.create(fromSubject(baseAnimal), null, null);
        this.actionFactory = actionFactory;
    }

    @Override
    public TreeNode<Fact> execute() {
        TreeNode<Fact> factNode = decisionTree;
        while (!factNode.isTerminal()) {
            Action<Boolean> confirmation = actionFactory.confirmationQuestion(Composer.question(factNode.val()).asText());

            Boolean isConfirmed = confirmation.execute();
            while (isConfirmed == null) {
                isConfirmed = confirmation.execute();
            }
            factNode = isConfirmed ? factNode.right() : factNode.left();
        }
        return factNode;
    }
}
