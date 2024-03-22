package binarytree;

/**
 *
 * @author Diego Casignia
 * @param <T>
 */
public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    public void insert(T data) {
        root = insert(root, data);
    }
    
    private TreeNode<T> insert(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }
        
        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        }
        
        return node;
    }
    
    public boolean search(T data) {
        return search(root, data);
    }
    
    private boolean search(TreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }
        
        if (data.equals(node.data)) {
            return true;
        } else if (data.compareTo(node.data) < 0) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }
    
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }
    
    private void printInOrder(TreeNode<T> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }
    
    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }
    
    private void printPreOrder(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
    
    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }
    
    private void printPostOrder(TreeNode<T> node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}
