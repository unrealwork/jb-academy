package animals.tree;

class TreeNodeImpl<T> implements TreeNode<T> {
    private T val;
    private TreeNode<T> left;
    private TreeNode<T> right;

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

    @Override
    public void setVal(T val) {
        this.val = val;
    }

    @Override
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    @Override
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
