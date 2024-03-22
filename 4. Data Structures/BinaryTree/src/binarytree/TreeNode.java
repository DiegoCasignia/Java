package binarytree;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
