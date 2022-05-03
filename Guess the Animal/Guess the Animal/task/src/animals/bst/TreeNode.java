package animals.bst;

public interface TreeNode<T> {
    T val();

    TreeNode<T> left();

    TreeNode<T> right();

    default boolean isTerminal() {
        return left() == null && right() == null;
    }

    static <T> TreeNode<T> create(T val, TreeNode<T> left, TreeNode<T> right) {
        return new TreeNodeImpl(val, left, right);
    }
}
