package animals.tree;


public interface BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> find(T value);

    TreeNode<T> insert(T value);
}
