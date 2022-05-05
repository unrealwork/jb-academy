package animals.tree;

import animals.lang.Fact;
import animals.lang.Subject;

public class FactUtils {
    private FactUtils() {

    }

    public static void learn(TreeNode<Fact> factNode, Fact distinguish, Subject animal) {
        factNode.setLeft(TreeNode.create(Fact.fromExpression(factNode.val().exp())));
        factNode.setRight(TreeNode.create(Fact.fromSubject(animal)));
        factNode.setVal(distinguish);
    }

}
