package animals.cli;

import animals.Expression;
import animals.Fact;
import animals.Subject;
import animals.bst.TreeNode;

public class GuessGame implements Action<Subject> {
    private final TreeNode<Fact> decisionTree;
    private final ActionFactory actionFactory;


    public GuessGame(Subject baseAnimal, ActionFactory actionFactory) {
        this.decisionTree = TreeNode.create(fromSubject(baseAnimal), null, null);
        this.actionFactory = actionFactory;
    }

    @Override
    public Subject execute() {
        TreeNode<Fact> factNode = decisionTree;
        while (!factNode.isTerminal()) {
            Action<Boolean> confirmation = actionFactory.confirmation(factNode.val().question().asText());

            Boolean isConfirmed = confirmation.execute();
            while (isConfirmed == null) {
                isConfirmed = confirmation.execute();
            }
            factNode = isConfirmed ? factNode.right() : factNode.left();
        }
        
    }

    private static Fact fromSubject(Subject subject) {
        return Fact.fromExpression(Expression.parse("It is " + subject.asText()));
    }
}
