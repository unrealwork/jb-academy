package animals.tree;

import java.util.function.Consumer;

public final class TreeTraversals {
    private TreeTraversals() {
        
    }
    public static <T> void preOrder(TreeNode<T> node, Consumer<TreeNode<T>> callback) {
        if (node != null) {
            preOrder(node.left(), callback);
            callback.accept(node);
            preOrder(node.right(), callback);
        }
    }
}
