package animals.tree.stats;

import animals.lang.Fact;
import animals.tree.TreeNode;

public interface StatisticHolder {
    Object get(StatisticType type);

    static StatisticHolder fromTree(TreeNode<Fact> factTreeNode) {
        return StatisticHolderImpl.fromTree(factTreeNode);
    }
}
