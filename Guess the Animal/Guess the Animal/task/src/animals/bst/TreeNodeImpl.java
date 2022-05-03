package animals.bst;

class TreeNodeImpl<T> implements TreeNode<T> {
    private final T val;
    private final TreeNode<T> left;
    private final TreeNode<T> right;

    public TreeNodeImpl(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public T val() {
        return val;
    }

    @Override
    public TreeNode<T> left() {
        return left;
    }

    @Override
    public TreeNode<T> right() {
        return right;
    }
}
