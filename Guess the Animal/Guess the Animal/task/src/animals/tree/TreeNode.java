package animals.tree;

public interface TreeNode<T> {
    T val();

    TreeNode<T> left();

    TreeNode<T> right();

    void setVal(T val);

    void setLeft(TreeNode<T> left);

    void setRight(TreeNode<T> setRight);

    default boolean isTerminal() {
        return left() == null && right() == null;
    }

    static <T> TreeNode<T> create(T val, TreeNode<T> left, TreeNode<T> right) {
        return new TreeNodeImpl<>(val, left, right);
    }

    static <T> TreeNode<T> create(T val) {
        return create(val, null, null);
    }
}
